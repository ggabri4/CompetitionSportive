package models;

import java.util.List;

public class FormuleRoundRobin implements FormuleChampionnat {
    private List<Match> matchs; // hypothétiquement, une liste de tous les matchs

    // Méthode pour organiser des matchs
    public void organiserMatches(List<Equipe> equipes) {
        // Implémentation dépendra de la logique spécifique de l'organisation des matchs en round robin
    }

    // Méthode pour générer un classement
    public List<Equipe> genererClassement() {
        // Implémentation dépendra de la logique spécifique de la génération du classement en round robin
        return null;
    }
}