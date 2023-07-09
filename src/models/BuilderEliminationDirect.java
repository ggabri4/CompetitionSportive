package models;

import java.util.List;

public class BuilderEliminationDirect implements FormuleBuilder {

    private List<Equipe> equipes;

    public BuilderEliminationDirect(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public FormuleChampionnat construireFormule() {
        FormuleEliminationDirecte formule = new FormuleEliminationDirecte();
        formule.organiserMatches(equipes);
        return formule;
    }

}
