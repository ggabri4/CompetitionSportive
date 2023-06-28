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

    public List<Equipe> genererClassement() {
        List<ClassementEquipe> classement = new ArrayList<>();

        // Calcul des scores et classement des équipes
        for (Equipe equipe : equipes) {
            ClassementEquipe classementEquipe = new ClassementEquipe(equipe);

            for (Match match : matchs) {
                if (match.getEquipe1().equals(equipe)) {
                    int resultat = match.getResultat();
                    classementEquipe.butsPour += match.getScoreEquipe1();
                    classementEquipe.butsContre += match.getScoreEquipe2();

                    if (resultat == 1) {
                        classementEquipe.points += 3;
                        classementEquipe.victoires++;
                    } else if (resultat == -1) {
                        classementEquipe.defaites++;
                    } else {
                        classementEquipe.points++;
                        classementEquipe.matchsNuls++;
                    }
                } else if (match.getEquipe2().equals(equipe)) {
                    int resultat = match.getResultat();
                    classementEquipe.butsPour += match.getScoreEquipe2();
                    classementEquipe.butsContre += match.getScoreEquipe1();

                    if (resultat == -1) {
                        classementEquipe.points += 3;
                        classementEquipe.victoires++;
                    } else if (resultat == 1) {
                        classementEquipe.defaites++;
                    } else {
                        classementEquipe.points++;
                        classementEquipe.matchsNuls++;
                    }
                }
            }

            classement.add(classementEquipe);
        }

        // Tri du classement selon les critères (points, différence de buts, buts
        // marqués)
        Collections.sort(classement, new Comparator<ClassementEquipe>() {
            public int compare(ClassementEquipe classementEquipe1, ClassementEquipe classementEquipe2) {
                if (classementEquipe1.points != classementEquipe2.points) {
                    return classementEquipe2.points - classementEquipe1.points;
                } else if (classementEquipe1.getDifferenceButs() != classementEquipe2.getDifferenceButs()) {
                    return classementEquipe2.getDifferenceButs() - classementEquipe1.getDifferenceButs();
                } else {
                    return classementEquipe2.butsPour - classementEquipe1.butsPour;
                }
            }
        });

        // Conversion des objets ClassementEquipe en objets Equipe pour le classement
        // final
        List<Equipe> classementFinal = new ArrayList<>();
        for (ClassementEquipe classementEquipe : classement) {
            classementFinal.add(classementEquipe.equipe);
        }

        return classementFinal;
    }

    // Classe interne pour stocker les statistiques de

}
