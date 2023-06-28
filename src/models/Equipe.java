package models;

public class Equipe {
    private String nom;
    private String categorie;
    private int points;
    private int victoires;
    private int defaites;
    private int matchsNuls;
    private int butsPour;
    private int butsContre;

    // Constructeur
    public Equipe(String nom, String categorie) {
        this.nom = nom;
        this.categorie = categorie;
        this.points = 0;
        this.victoires = 0;
        this.defaites = 0;
        this.matchsNuls = 0;
        this.butsPour = 0;
        this.butsContre = 0;
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

    // Getter pour les points
    public int getPoints() {
        return this.points;
    }

    // Setter pour les points
    public void setPoints(int points) {
        this.points = points;
    }

    // Getter pour les victoires
    public int getVictoires() {
        return this.victoires;
    }

    // Setter pour les victoires
    public void setVictoires(int victoires) {
        this.victoires = victoires;
    }

    // Getter pour les défaites
    public int getDefaites() {
        return this.defaites;
    }

    // Setter pour les défaites
    public void setDefaites(int defaites) {
        this.defaites = defaites;
    }

    // Getter pour les matchs nuls
    public int getMatchsNuls() {
        return this.matchsNuls;
    }

    // Setter pour les matchs nuls
    public void setMatchsNuls(int matchsNuls) {
        this.matchsNuls = matchsNuls;
    }

    // Getter pour les buts marqués
    public int getButsPour() {
        return this.butsPour;
    }

    // Setter pour les buts marqués
    public void setButsPour(int butsPour) {
        this.butsPour = butsPour;
    }

    // Getter pour les buts encaissés
    public int getButsContre() {
        return this.butsContre;
    }

    // Setter pour les buts encaissés
    public void setButsContre(int butsContre) {
        this.butsContre = butsContre;
    }
}
