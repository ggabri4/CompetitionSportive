package models;

import java.util.List;

public interface FormuleChampionnat {
    
    // Méthode pour organiser des matchs
    void organiserMatches(List<Equipe> equipes);

    // Méthode pour générer un classement
    List<Equipe> genererClassement();
}
