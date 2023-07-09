package models;

import java.util.List;

public class BuilderRoundRobin implements FormuleBuilder {
    
    private List<Equipe> equipes;

    public BuilderRoundRobin(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public FormuleChampionnat construireFormule() {
        FormuleRoundRobin formule = new FormuleRoundRobin();
        formule.organiserMatches(equipes);
        return formule;
    }
}
