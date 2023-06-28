import java.util.Scanner;
import models.*;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Competition competition = new Competition("default");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter une équipe");
            System.out.println("2. Créer une phase");
            System.out.println("3. Entrer les résultats des matchs");
            System.out.println("4. Afficher le classement");
            System.out.println("5. Quitter");
            
            System.out.print("\nVotre choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consomme le '\n' laissé par nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Entrez le nom de l'équipe : ");
                    String equipeNom = scanner.nextLine();
                    Equipe equipe = new Equipe(equipeNom, "");
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
