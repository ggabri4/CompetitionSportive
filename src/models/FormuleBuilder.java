package models;

import java.util.List;

public interface FormuleBuilder {
    
    // Méthode pour construire des matchs
    List<Match> construireMatchs();

    // Méthode pour construire la formule
    FormuleChampionnat construireFormule();
}
