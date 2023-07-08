package models;

import java.util.List;

public class Equipe {
    private String nom;
    private int points;
    private int victoires;
    private int defaites;
    private int matchsNuls;
    private int butsPour;
    private int butsContre;

    // Constructeur
    public Equipe(String nom) {
        this.nom = nom;
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

    // Setter pour le nom
    public void setNom(String nom) {
        this.nom = nom;
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

    public void calculerScore(List<Match> matchs) {
        for (Match match : matchs) {
            if (match.getEquipe1().equals(this)) {
                calculerScorePourMatch(match, match.getScoreEquipe1(), match.getScoreEquipe2(), 1);
            } else if (match.getEquipe2().equals(this)) {
                calculerScorePourMatch(match, match.getScoreEquipe2(), match.getScoreEquipe1(), 2);
            }
        }
    }
    private void calculerScorePourMatch(Match match, int butsPour, int butsContre, int numEquipe) {
        this.butsPour += butsPour;
        this.butsContre += butsContre;
        int resultat = match.getResultat();
        if(resultat == -1){
            return;
        }

        if (resultat == numEquipe) {
            points += 3;
            victoires++;
        } else if (resultat != 3) {
            defaites++;
        } else {
            points++;
            matchsNuls++;
        }
    }

    public void resetScores() {
        this.points = 0;
        this.victoires = 0;
        this.defaites = 0;
        this.matchsNuls = 0;
        this.butsPour = 0;
        this.butsContre = 0;
    }
}
