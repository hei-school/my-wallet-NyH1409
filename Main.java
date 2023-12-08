import java.util.Scanner;
import model.Money;
import model.Wallet;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Wallet myWallet = new Wallet();
    Money money = new Money(1);
    myWallet.putObjectIn(1, money);
    myWallet.putObjectIn(2, money);
    myWallet.putObjectOut(1, 1);
    myWallet.putObjectOut(2, 1);
    System.out.println(myWallet.getPockets());
    /**while (true) {
      menu();
      System.out.print("Saisir : ");
      int choice = scanner.nextInt();
      redirect(scanner, myWallet, choice);
    }**/
  }

  public static void menu() {
    System.out.println("Bienvenue sur MyWallet!");
    System.out.println("1 - Placer de l'argent dans une poche");
    System.out.println("2 - Consulter le montant total dans une poche");
    System.out.println("3 - Consulter le montant total dans la portefeuille");
    System.out.println("4 - Retirer de l'argent");
    System.out.println("5 - Securiser la portefeuille");
    System.out.println("6 - S'identifier");
  }

  public static void redirect(Scanner scanner, Wallet wallet, int choice) {
    switch (choice) {
      case 1:
        System.out.print("Dans quelle poche ? (1 - 4) ");
        int pocketNumber = scanner.nextInt();
        System.out.print("Le montant a placer ? (MGA) ");
        double amount = scanner.nextDouble();

        break;
      case 2:
        System.out.print("Dans quelle poche ? (1 - 4) ");
        int pocketNum = scanner.nextInt();
        break;
      case 3:
        break;
      case 4:
        System.out.print("Dans quelle poche ? (1 - 4) ");
        int pocket = scanner.nextInt();
        System.out.print("Le montant a retirer ? (MGA) ");
        double toPull = scanner.nextDouble();
        break;
      case 5:
        System.out.println("Ajouter un mot de passe : ");
        String pass = scanner.next();
        break;
      case 6:
        System.out.println("Emtrer le mot de passe : ");
        String pwd = scanner.next();
        break;
      default:
        break;
    }
  }
}
