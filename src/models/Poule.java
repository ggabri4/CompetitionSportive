package models;
import java.util.ArrayList;
import java.util.List;

public class Poule {
    private String nom;
    private List<Equipe> equipes;
    private FormuleChampionnat formule;

    // Constructeur
    public Poule(String nom, FormuleChampionnat formule) {
        this.nom = nom;
        this.equipes = new ArrayList<>();
        this.formule = formule;
    }

    // Getter pour le nom
    public String getNom() {
        return this.nom;
    }

    // Getter pour les equipes
    public List<Equipe> getEquipes() {
        return this.equipes;
    }

    // Méthode pour ajouter une équipe
    public void ajouterEquipe(Equipe equipe) {
        this.equipes.add(equipe);
    }

    // Méthode pour supprimer une équipe
    public void supprimerEquipe(Equipe equipe) {
        this.equipes.remove(equipe);
    }
    
    // Getter pour la formule
    public FormuleChampionnat getFormule() {
        return this.formule;
    }

    // Setter pour la formule
    public void setFormule(FormuleChampionnat formule) {
        this.formule = formule;
    }

    public void ajouterEquipes(List<Equipe> equipes) {
        this.equipes.addAll(equipes);
    }
}
