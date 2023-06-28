package models;

public class Match {
    private Equipe equipe1;
    private Equipe equipe2;
    private int scoreEquipe1;
    private int scoreEquipe2;

    // Pour Round Robin
    private int resultat;

    // Pour élimination direct
    private Equipe equipeGagnante;

    // Constructeur
    public Match(Equipe equipe1, Equipe equipe2) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
    }

    // Getter pour l'équipe 1
    public Equipe getEquipe1() {
        return this.equipe1;
    }

    // Getter pour l'équipe 2
    public Equipe getEquipe2() {
        return this.equipe2;
    }

    // Getter pour le score de l'équipe 1
    public int getScoreEquipe1() {
        return this.scoreEquipe1;
    }

    // Getter pour le score de l'équipe 2
    public int getScoreEquipe2() {
        return this.scoreEquipe2;
    }

    // Getter pour le résultat (Victoire, défaite ou null)
    public int getResultat() {
        return this.resultat;
    }

    // Méthode pour définir les scores
    public void setScore(int scoreEquipe1, int scoreEquipe2) {
        this.scoreEquipe1 = scoreEquipe1;
        this.scoreEquipe2 = scoreEquipe2;
        this.resultat = Integer.compare(scoreEquipe1, scoreEquipe2); // Un résultat négatif indique que l'équipe 1 a
                                                                     // perdu, un résultat positif indique qu'elle a
                                                                     // gagné, et zéro indique un match nul.
        this.scoreEquipe1 = scoreEquipe1;
        this.scoreEquipe2 = scoreEquipe2;
        determineGagnant();
    }

    // Méthode pour déterminer le gagnant
    private void determineGagnant() {
        if (scoreEquipe1 > scoreEquipe2) {
            equipeGagnante = equipe1;
        } else if (scoreEquipe2 > scoreEquipe1) {
            equipeGagnante = equipe2;
        } else {
            equipeGagnante = null; // dans le cas d'un match nul
        }
    }

    // Getter pour l'équipe gagnante
    public Equipe getEquipeGagnante() {
        return this.equipeGagnante;
    }
}
