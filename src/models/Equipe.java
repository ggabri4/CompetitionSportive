package models;

public class Equipe {
    private String nom;
    private String categorie;

    // Constructeur
    public Equipe(String nom, String categorie) {
        this.nom = nom;
        this.categorie = categorie;
    }

    // Getter pour le nom
    public String getNom() {
        return this.nom;
    }

    // Getter pour la categorie
    public String getCategorie() {
        return this.categorie;
    }

    // Setter pour le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Setter pour la categorie
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
