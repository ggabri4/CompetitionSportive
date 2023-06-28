package models;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    private String nom;
    private List<Phase> phases;

    // Constructeur
    public Competition(String nom) {
        this.nom = nom;
        this.phases = new ArrayList<>();
    }

    // Getter pour le nom
    public String getNom() {
        return this.nom;
    }

    // Getter pour les phases
    public List<Phase> getPhases() {
        return this.phases;
    }

    // Méthode pour ajouter une phase
    public void ajouterPhase(Phase phase) {
        this.phases.add(phase);
    }

    // Méthode pour supprimer une phase
    public void supprimerPhase(Phase phase) {
        this.phases.remove(phase);
    }
}
