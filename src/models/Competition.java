package models;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    private String nom;
    private List<Phase> phases;
    private List<Equipe> equipes;
    private PhaseFactory phaseFactory;

    // Constructeur
    public Competition(String nom) {
        this.nom = nom;
        this.phases = new ArrayList<>();        
        this.equipes = new ArrayList<>();
        this.phaseFactory = new PhaseFactory();
    }

    // Getter pour le nom
    public String getNom() {
        return this.nom;
    }

    // Getter pour les phases
    public List<Phase> getPhases() {
        return this.phases;
    }

    public void ajouterPhase(String phaseNom, String type, int nbPoules) {
        Phase phase = phaseFactory.createPhase(phaseNom, type, nbPoules, equipes);
        this.phases.add(phase);
    }

    public void supprimerPhase(Phase phase) {
        this.phases.remove(phase);
    }

    // Getter pour les equipes
    public List<Equipe> getEquipes() {
        return this.equipes;
    }
 
    public void ajouterEquipe(Equipe equipe){
        this.equipes.add(equipe);
    }

    public void supprimerEquipe(Equipe equipe){
        this.equipes.remove(equipe);
    }

    public void entrerResultatMatch(String phaseNom, String equipeGagnante, String equipePerdante) {
        System.out.println();
        // Cherche la phase par son nom
        Phase phase = phases.stream()
                            .filter(p -> p.getNom().equals(phaseNom))
                            .findFirst()
                            .orElse(null);

        if (phase == null) {
            System.out.println("Phase non trouvée : "+ phaseNom);
            return;
        }

        // Cherche la poule qui contient les deux équipes
        Poule poule = phase.getPoules().stream()
                            .filter(p -> p.getEquipes().stream()
                                        .anyMatch(e -> e.getNom().equals(equipeGagnante)) &&
                                        p.getEquipes().stream()
                                        .anyMatch(e -> e.getNom().equals(equipePerdante)))
                            .findFirst()
                            .orElse(null);

        if (poule == null) {
            System.out.println("Poule non trouvée.");
            return;
        }

        // Cherche le match qui concerne les deux équipes
        Match match = poule.getFormule().getMatchs().stream()
                            .filter(m -> (m.getEquipe1() != null && m.getEquipe1().getNom().equals(equipeGagnante) &&
                                        m.getEquipe2() != null && m.getEquipe2().getNom().equals(equipePerdante)) ||
                                        (m.getEquipe1() != null && m.getEquipe1().getNom().equals(equipePerdante) &&
                                       m.getEquipe2() != null &&  m.getEquipe2().getNom().equals(equipeGagnante)))
                            .findFirst()
                            .orElse(null);

        if (match == null) {
            System.out.println("Match non trouvé.");
            return;
        }

        // Définit l'équipe gagnante du match
        if (match.getEquipe1().getNom().equals(equipeGagnante)) {
            match.setScore(1, 0);  // Score arbitraire, à adapter selon vos besoins
        } else {
            match.setScore(0, 1);  // Score arbitraire, à adapter selon vos besoins
        }
    }

    public void afficherClassement() {
        for(Phase phase : phases) {
            System.out.println(phase.getNom() + " : ");
            for(Poule poule : phase.getPoules()) {
                System.out.println("\t" + poule.getNom() + " : ");
                List<Equipe> classement = poule.getFormule().genererClassement();
                if(classement == null || classement.size() != poule.getEquipes().size()){
                    System.out.println("\nLe classement n'est pas encore défini");
                    return;
                }
                for(int i = 0; i < classement.size(); i++) {
                    System.out.println("\t\t"+(i+1) + ". " + classement.get(i).getNom() + "  \t- " + classement.get(i).getPoints() + " points");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void afficherClassement(String nomPhase) {
        boolean found = false;
        for(Phase phase : phases) {
            if(phase.getNom().equals(nomPhase)) {
                found = true;
                System.out.println(phase.getNom() + " : ");
                for(Poule poule : phase.getPoules()) {
                    System.out.println("\t" + poule.getNom() + " : ");
                    List<Equipe> classement = poule.getFormule().genererClassement();
                    if(classement == null){
                        System.out.println("Il n'y a pas encore de poules");
                        return;
                    }
                    for(int i = 0; i < classement.size(); i++) {
                        if(classement.get(i) != null)
                            System.out.println((i+1) + ". " + classement.get(i).getNom() + "  \t- " + classement.get(i).getPoints() + " points");
                    }
                    System.out.println();
                }
                System.out.println();
                break;
            }
        }
        if(!found)
            System.out.println("Phase '"+nomPhase+"' non trouvée");
    }

    public void afficherMatchs(String nomPhase) {
        boolean found = false;
        for(Phase phase : phases) {
            if(phase.getNom().equals(nomPhase)) {
                found = true;

                System.out.println(phase.getNom() + " : ");
                for(Poule poule : phase.getPoules()) {
                    System.out.println("\t" + poule.getNom() + " : ");
                    List<Match> matchs = poule.getFormule().getMatchs();
                    for(Match match : matchs) {
                        if(match.getEquipe1() != null)//les équipes sont null pour les matchs futurs
                        {
                            if(match.getResultat() != -1)
                                System.out.println("\t\t"+match.getEquipe1().getNom() + " vs " + match.getEquipe2().getNom() + " ("+match.getScoreEquipe1()+"-"+match.getScoreEquipe2()+")");
                            else
                                System.out.println("\t\t"+match.getEquipe1().getNom() + " vs " + match.getEquipe2().getNom());
                        }
                    }
                    System.out.println();
                }
                System.out.println();
                break;
            }
        }
        if(!found)
            System.out.println("\nPhase non trouvée");
    }
}
