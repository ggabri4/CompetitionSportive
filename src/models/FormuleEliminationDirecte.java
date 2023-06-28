package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class FormuleEliminationDirecte implements FormuleChampionnat {
    private Noeud finale;// hypothétiquement, une structure de match qui représente la finale

    // Méthode pour organiser des matchs
    public void organiserMatches(List<Equipe> equipes) {

        Queue<Noeud> queue = new LinkedList<>();
        for (int i = 0; i < equipes.size(); i += 2) {
            Match match = new Match(equipes.get(i), equipes.get(i + 1));
            queue.add(new Noeud(match));
        }

        while (queue.size() > 1) {
            Noeud noeud1 = queue.poll();
            Noeud noeud2 = queue.poll();
            // Un match "virtuel" qui sera mis à jour avec les bonnes équipes plus tard
            Match match = new Match(null, null);
            Noeud parent = new Noeud(match);
            parent.enfantGauche = noeud1;
            parent.enfantDroite = noeud2;
            queue.add(parent);
        }

        finale = queue.poll();
    }

    // Méthode pour générer un classement
    public List<Equipe> genererClassement() {
        List<Equipe> classement = new ArrayList<>();

        Stack<Noeud> stack = new Stack<>();
        stack.push(finale);

        while (!stack.isEmpty()) {
            Noeud noeud = stack.pop();

            if (noeud.match.getEquipeGagnante() != null) {
                // On ajoute l'équipe perdante en première position de la liste
                if (noeud.match.getEquipeGagnante().equals(noeud.match.getEquipe1())) {
                    classement.add(0, noeud.match.getEquipe2());
                } else {
                    classement.add(0, noeud.match.getEquipe1());
                }
            }

            if (noeud.enfantGauche != null) {
                stack.push(noeud.enfantGauche);
            }

            if (noeud.enfantDroite != null) {
                stack.push(noeud.enfantDroite);
            }
        }

        // Finalement, on ajoute l'équipe gagnante en première position
        classement.add(0, finale.match.getEquipeGagnante());

        return classement;
    }


}