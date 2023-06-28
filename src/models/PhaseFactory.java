package models;

import java.util.List;

public class PhaseFactory {
    private String nom;

    public PhaseFactory(String nom){
        this.nom = nom;
    }

    public Phase createPhase(String type, int nbPoules, List<Equipe> equipes){
        int equipesParPoule = equipes.size() / nbPoules;
        Phase phase = null;
        
        for (int i = 0; i < nbPoules; i++) {
            List<Equipe> equipesPourCettePoule = equipes.subList(i * equipesParPoule, (i + 1) * equipesParPoule);
            FormuleBuilder builder;

            if(type.equals("0")){
                builder = new BuilderEliminationDirect(equipesPourCettePoule);
            }
            else if(type.equals("1")){
                builder = new BuilderRoundRobin(equipesPourCettePoule);
            }
            else {
                throw new IllegalArgumentException("Type non reconnu: " + type);
            }

            FormuleChampionnat formule = builder.construireFormule();
            phase = new Phase(nom, formule);
            Poule poule = new Poule(nom, formule);
            phase.ajouterPoule(poule);
        }
        return phase;
    }
}