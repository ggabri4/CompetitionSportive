import java.util.Scanner;
import models.*;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Competition competition = new Competition("default");

        Equipe lens = new Equipe("lens");
        Equipe amiens = new Equipe("amiens");
        Equipe lille = new Equipe("lille");
        Equipe paris = new Equipe("paris");
        Equipe marseille = new Equipe("marseille");
        Equipe lyon = new Equipe("lyon");

        competition.ajouterEquipe(lens);
        competition.ajouterEquipe(amiens);
        competition.ajouterEquipe(lille);
        competition.ajouterEquipe(paris);
        competition.ajouterEquipe(marseille);
        competition.ajouterEquipe(lyon);

        competition.ajouterPhase("phase1", "0", 1);
        // competition.afficherMatchs("phase1");
        competition.entrerResultatMatch("phase", "equipe1", "equipe2");


        
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter une équipe");
            System.out.println("2. Créer une phase");
            System.out.println("3. Entrer les résultats des matchs");
            System.out.println("4. Afficher le classement");
            System.out.println("5. Afficher les equipes");
            System.out.println("6. Afficher les phases");

            System.out.println("5. Quitter");
            
            System.out.print("\nVotre choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consomme le '\n' laissé par nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Entrez le nom de l'équipe : ");
                    String equipeNom = scanner.nextLine();
                    Equipe equipe = new Equipe(equipeNom);
                    competition.ajouterEquipe(equipe);
                    break;

                case 2:
                    System.out.print("Entrez le nom de la phase : ");
                    String phaseNom = scanner.nextLine();
                    System.out.print("Entrez le type de la phase (0: Elimination Directe, 1: Round Robin) : ");
                    String typePhase = scanner.nextLine();
                    System.out.print("Entrez le nombre de poules : ");
                    int nbPoules = scanner.nextInt();
                    scanner.nextLine();  // Consomme le '\n' laissé par nextInt()
                    competition.ajouterPhase(phaseNom, typePhase, nbPoules);

                    System.out.println(competition.getPhases().stream().filter(p -> p.getNom().equals(phaseNom)).findFirst());
                    break;

                case 3:
                    System.out.print("Entrez le nom de la phase : ");
                    String phaseMatchNom = scanner.nextLine();
                    System.out.print("Entrez le nom de l'équipe gagnante : ");
                    String equipeGagnante = scanner.nextLine();
                    System.out.print("Entrez le nom de l'équipe perdante : ");
                    String equipePerdante = scanner.nextLine();
                    competition.entrerResultatMatch(phaseMatchNom, equipeGagnante, equipePerdante);
                    break;

                case 4:
                    System.out.print("Entrez le nom de la phase : ");
                    String phaseClassementNom = scanner.nextLine();
                    competition.afficherClassement(phaseClassementNom);
                    break;

                case 5:
                    System.out.print("\nVoici les équipes : \n");

                    for(Equipe e : competition.getEquipes()){
                        System.out.println(e.getNom());
                    }
                    break;
                case 6:
                    System.out.print("\nVoici les phases : \n");

                    for(Phase p : competition.getPhases()){
                        System.out.println(p.getNom());
                    }
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        }
        scanner.close();
    }
}
