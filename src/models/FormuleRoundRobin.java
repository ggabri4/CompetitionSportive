package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class FormuleRoundRobin implements FormuleChampionnat {
    private List<Match> matchs;

    public void organiserMatches(List<Equipe> equipes) {
        matchs = new ArrayList<>();

        int totalEquipes = equipes.size();
        int totalRounds = totalEquipes - 1; // Le nombre total de rounds nécessaires pour que chaque équipe se rencontre

        int equipesParRound = totalEquipes / 2; // Nombre d'équipes par round

        for (int round = 0; round < totalRounds; round++) {
            for (int i = 0; i < equipesParRound; i++) {
                int equipeAIndex = i;
                int equipeBIndex = (totalRounds + round - i) % totalRounds;

                Equipe equipeA = equipes.get(equipeAIndex);
                Equipe equipeB = equipes.get(equipeBIndex);

                Match match = new Match(equipeA, equipeB); // Création d'un nouveau match avec les équipes concernées

                matchs.add(match); // Ajout du match à la liste des matchs
            }

            // Rotation des équipes (sauf la première équipe) pour créer de nouveaux matchs
            // au prochain round
            Equipe premiereEquipe = equipes.get(0);
            Equipe derniereEquipe = equipes.get(totalEquipes - 1);

            // Déplacement des équipes vers la droite (en les décalant d'une position vers
            // la droite)
            for (int i = totalEquipes - 1; i > 1; i--) {
                equipes.set(i, equipes.get(i - 1));
            }

            equipes.set(1, derniereEquipe); // La dernière équipe devient la deuxième

            // Déplacement de la première équipe à la fin
            equipes.set(totalEquipes - 1, premiereEquipe);
        }
    }

    public List<Equipe> genererClassement(List<Equipe> equipes, List<Match> matchs) {
        List<Equipe> classement = new ArrayList<>();

        // Calcul des scores et classement des équipes
        for (Equipe equipe : equipes) {
            int points = 0;
            int victoires = 0;
            int defaites = 0;
            int matchsNuls = 0;
            int butsPour = 0;
            int butsContre = 0;

            for (Match match : matchs) {
                if (match.getEquipe1().equals(equipe)) {
                    int resultat = match.getResultat();
                    butsPour += match.getScoreEquipe1();
                    butsContre += match.getScoreEquipe2();

                    if (resultat == 1) {
                        points += 3;
                        victoires++;
                    } else if (resultat == -1) {
                        defaites++;
                    } else {
                        points++;
                        matchsNuls++;
                    }
                } else if (match.getEquipe2().equals(equipe)) {
                    int resultat = match.getResultat();
                    butsPour += match.getScoreEquipe2();
                    butsContre += match.getScoreEquipe1();

                    if (resultat == -1) {
                        points += 3;
                        victoires++;
                    } else if (resultat == 1) {
                        defaites++;
                    } else {
                        points++;
                        matchsNuls++;
                    }
                }
            }

            equipe.setPoints(points);
            equipe.setVictoires(victoires);
            equipe.setDefaites(defaites);
            equipe.setMatchsNuls(matchsNuls);
            equipe.setButsPour(butsPour);
            equipe.setButsContre(butsContre);

            classement.add(equipe);
        }

        // Tri du classement selon les critères (points, différence de buts, buts
        // marqués)
        Collections.sort(classement, new Comparator<Equipe>() {
            public int compare(Equipe equipe1, Equipe equipe2) {
                if (equipe1.getPoints() != equipe2.getPoints()) {
                    return equipe2.getPoints() - equipe1.getPoints();
                } else if (equipe1.getButsPour() - equipe1.getButsContre() != equipe2.getButsPour()
                        - equipe2.getButsContre()) {
                    return (equipe2.getButsPour() - equipe2.getButsContre())
                            - (equipe1.getButsPour() - equipe1.getButsContre());
                } else {
                    return equipe2.getButsPour() - equipe1.getButsPour();
                }
            }
        });

        return classement;
    }

}
