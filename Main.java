import java.util.Scanner;
import model.Wallet;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Wallet myWallet = new Wallet();
    menu();
    System.out.print("Saisir : ");
    int choice = scanner.nextInt();
    redirect(scanner, myWallet, choice);
  }

  public static void menu() {
    System.out.println("Bienvenue sur MyWallet!");
    System.out.println("1 - Placer de l'argent dans une poche");
    System.out.println("2 - Consulter le montant total dans une poche");
    System.out.println("3 - Consulter le montant total dans la portefeuille");
    System.out.println("4 - Retirer de l'argent");
    System.out.println("5 - Compter les billets");
  }

  public static void redirect(Scanner scanner, Wallet wallet, int choice){
    switch (choice){
      case 1 :
        System.out.print("Dans quelle poche ? (1 - 4) ");
        int pocketNumeber = scanner.nextInt();
        System.out.print("Le momtant a placer ? (MGA) ");
        double amount = scanner.nextDouble();
        wallet.putIn(pocketNumeber, amount);
        menu();
      case 2 :
        System.out.println("Not implemented");
        break;
      case 3 :
        System.out.println("Not implemented");
        break;
      case 4 :
        System.out.println("Not implemented");
        break;
      case 5 :
        System.out.println("Not implemented");
        break;
      default:
        System.out.printf("Vous avez dans votre portefeuille : %s", wallet.getAmountIn());
    }
  }
}
