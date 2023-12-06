import java.util.Scanner;
import model.Wallet;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Wallet myWallet = new Wallet();
    while (true) {
      menu();
      System.out.print("Saisir : ");
      int choice = scanner.nextInt();
      redirect(scanner, myWallet, choice);
    }
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
        wallet.putIn(pocketNumber, amount);
        break;
      case 2:
        System.out.print("Dans quelle poche ? (1 - 4) ");
        int pocketNum = scanner.nextInt();
        System.out.printf("Dans la poche %s , vous avez %s (MGA) ", pocketNum, wallet.getAmountInPocket(pocketNum));
        break;
      case 3:
        System.out.printf("Dans la portefeuille , vous avez %s (MGA) ", wallet.getAmountIn());
        break;
      case 4:
        System.out.print("Dans quelle poche ? (1 - 4) ");
        int pocket = scanner.nextInt();
        System.out.print("Le montant a retirer ? (MGA) ");
        double toPull = scanner.nextDouble();
        wallet.retrieveMoney(pocket, toPull);
        break;
      case 5:
        System.out.println("Ajouter un mot de passe : ");
        String pass = scanner.next();
        wallet.secure(pass);
        break;
      case 6:
        System.out.println("Emtrer le mot de passe : ");
        String pwd = scanner.next();
        wallet.authenticate(pwd);
        break;
      default:
        System.out.printf("Vous avez dans votre portefeuille : %s", wallet.getAmountIn());
    }
  }
}
