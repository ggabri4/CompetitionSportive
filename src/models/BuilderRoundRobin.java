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
    
    // Méthode pour construire des matchs
    @Override
    public List<Match> construireMatchs() {
        // Implémentation dépendra de la logique spécifique de l'organisation des matchs d'élimination directe
        return null;
    }
}
