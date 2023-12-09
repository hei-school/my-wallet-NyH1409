import java.util.List;
import java.util.Scanner;
import java.util.random.RandomGenerator;
import model.Wallet;
import model.common.PocketObject;

import static utils.AppUtils.menu;
import static utils.AppUtils.objectCountMenu;
import static utils.AppUtils.objectTypeMenu;

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


  public static void redirect(Scanner scanner, Wallet wallet, int choice) {
    int objectId = RandomGenerator.getDefault().nextInt(1, 100);
    switch (choice) {
      case 1:
        System.out.println(objectId);
        System.out.print("Which pocket ? (1 - 5) ");
        int pocketNumber = scanner.nextInt();
        System.out.println("Object type : ");
        System.out.println("1 - Money ");
        System.out.println("2 - Photo");
        System.out.println("3 - Credit Card");
        System.out.println("4 - Visit Card");
        System.out.println("5 - Driving Card");
        System.out.println("6 - National Identity Card");
        System.out.print("Choice : ");
        int type = scanner.nextInt();
        objectTypeMenu(wallet, objectId, pocketNumber, type, scanner);
        break;
      case 2:
        System.out.println("All object you can put out ");
        List<PocketObject> objects = wallet.getObjects();
        for (PocketObject obj : objects) {
          System.out.printf("[%s - %s] %n", obj.getId(), obj.getClass().getName().substring(6));
        }
        System.out.print("Choose object identifier : ");
        int objId = scanner.nextInt();
        wallet.putObjectOut(objId);
        break;
      case 3:
        System.out.printf("Actual Balance : %s MGA %n", wallet.getBalance());
        break;
      case 4:
        System.out.print("Which pocket ? (1 - 5) ");
        int pocket = scanner.nextInt();
        System.out.printf("All objects in pocket number %s %n", pocket);
        List<PocketObject> objectList = wallet.getObjectIn(pocket);
        for (PocketObject obj : objectList) {
          System.out.printf("[%s - %s] %n", obj.getId(), obj.getClass().getName().substring(6));
        }
        break;
      case 5:
        List<PocketObject> walletObjects = wallet.getObjects();
        for (PocketObject obj : walletObjects) {
          System.out.printf("[%s - %s] %n", obj.getId(), obj.getClass().getName().substring(6));
        }
        System.out.print("Choose object identifier : ");
        int objIde = scanner.nextInt();
        System.out.printf("Object found in the pocket number %s %n", wallet.getObjectLocation(objIde).getNumber());
        break;
      case 6:
        System.out.println("Object type : ");
        System.out.println("1 - Credit Card");
        System.out.println("2 - Visit Card");
        System.out.println("3 - Driving Card");
        System.out.println("4 - National Identity Card");
        System.out.print("Choice : ");
        int cardType = scanner.nextInt();
        objectCountMenu(wallet, cardType);
        break;
      default:
        break;
    }
  }
}
