package models;

import java.util.List;

public interface FormuleChampionnat {
    
    void organiserMatches(List<Equipe> equipes);

    List<Equipe> genererClassement();    
    List<Match> getMatchs();
}
