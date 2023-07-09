package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class FormuleRoundRobin implements FormuleChampionnat {
    private List<Match> matchs;
    private List<Equipe> equipes;

    public void organiserMatches(List<Equipe> equipes) {
        this.equipes = new ArrayList<>(equipes);
        matchs = new ArrayList<>();

        int totalEquipes = equipes.size();
        int totalRounds = totalEquipes - 1;

        for (int round = 0; round < totalRounds; round++) {
            for (int i = 0; i < totalEquipes / 2; i++) {
                Equipe equipeA = equipes.get(i);
                Equipe equipeB = equipes.get(totalEquipes - i - 1);

                Match match = new Match(equipeA, equipeB);
                matchs.add(match);
            }

            Equipe temp = equipes.get(1);
            for (int i = 1; i < totalEquipes - 1; i++) {
                equipes.set(i, equipes.get(i + 1));
            }
            equipes.set(totalEquipes - 1, temp);
        }
    }
    
    public List<Match> getMatchs() {
        return matchs;
    }

    public List<Equipe> genererClassement() {
        System.out.println();
        
        for (Equipe equipe : this.equipes) {
            equipe.resetScores();
            equipe.calculerScore(matchs);
        }

        return equipes.stream()
            .sorted(Comparator.comparing(Equipe::getPoints).reversed()
                    .thenComparing(e -> e.getButsPour() - e.getButsContre(), Comparator.reverseOrder())
                    .thenComparing(Equipe::getButsPour, Comparator.reverseOrder()))
            .collect(Collectors.toList());
    }
}
