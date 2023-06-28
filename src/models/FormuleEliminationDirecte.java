package models;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        // Implémentation dépendra de la logique spécifique de la génération du classement d'élimination directe
        return null;
    }
}