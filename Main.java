import java.util.Scanner;
import model.Card;
import model.Money;
import model.Wallet;

import static model.CardType.CREDIT_CARD;
import static model.CardType.VISIT_CARD;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Wallet myWallet = new Wallet();

    System.out.println(myWallet.countObject(VISIT_CARD));
    /**while (true) {
      menu();
      System.out.print("Saisir : ");
      int choice = scanner.nextInt();
      redirect(scanner, myWallet, choice);
    }**/
  }

  public static void menu() {
    System.out.println("Welcome to MyWallet!");
    System.out.println("1 - Put object in");
    System.out.println("2 - Put object out");
    System.out.println("3 - Get money balance");
    System.out.println("4 - Get object in a specific pocket");
    System.out.println("5 - Find object (provide the identifier)");
    System.out.println("6 - Count object [Credit card, visit card, driving card, National Card]");
    System.out.println("7 - Indicate object lost or found");
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
