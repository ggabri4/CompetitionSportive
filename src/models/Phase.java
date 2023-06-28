package models;

import java.util.ArrayList;
import java.util.List;

public class Phase {
    private String nom;
    private List<Poule> poules;
    private FormuleChampionnat formule;

    // Constructeur
    public Phase(String nom, FormuleChampionnat formule) {
        this.nom = nom;
        this.poules = new ArrayList<>();
        this.formule = formule;
    }

    // Getter pour le nom
    public String getNom() {
        return this.nom;
    }

    // Getter pour les poules
    public List<Poule> getPoules() {
        return this.poules;
    }

    // Méthode pour ajouter une poule
    public void ajouterPoule(Poule poule) {
        this.poules.add(poule);
    }

    // Méthode pour supprimer une poule
    public void supprimerPoule(Poule poule) {
        this.poules.remove(poule);
    }
    
    // Getter pour la formule
    public FormuleChampionnat getFormule() {
        return this.formule;
    }

    // Setter pour la formule
    public void setFormule(FormuleChampionnat formule) {
        this.formule = formule;
    }
}
