package utils;

import java.util.Scanner;
import model.Card;
import model.Money;
import model.Photo;
import model.Wallet;

import static model.CardType.CREDIT_CARD;
import static model.CardType.DRIVING_CARD;
import static model.CardType.NI_CARD;
import static model.CardType.VISIT_CARD;

public class AppUtils {

  public static void beautifulMenu(){
    System.out.println("+++++++++++++++++++++++++++++++++++++");
    System.out.println("++wwww+++++++++++++++++++++wwww++++++");
    System.out.println("+++wwww++++++++++++++++++wwww++++++++");
    System.out.println("++++wwww++++wwwwwww++++wwww++++++++++");
    System.out.println("++++++wwww+wwww+wwww+wwww++++++++++++");
    System.out.println("+++++++wwwwww++++wwwwwww+++++++++++++");
    System.out.println("+++++++++++++++++++++++++++++++++++++");
    System.out.println("+++++++++++++++++++++++++++++++++++++");
  }

  public static void menu() {
    System.out.println("Welcome to MyWallet!");
    beautifulMenu();
    System.out.println("1 - Put object in");
    System.out.println("2 - Put object out");
    System.out.println("3 - Get money balance");
    System.out.println("4 - Get objects in a specific pocket");
    System.out.println("5 - Find object (provide the identifier)");
    System.out.println("6 - Count object [Credit card, visit card, driving card, National Card]");
    System.out.println("7 - Indicate object lost or found");
  }

  public static void objectTypeMenu(Wallet wallet,
                                    int objectId,
                                    int pocketNumber,
                                    int type, Scanner scanner) {
    switch (type) {
      case 1:
        System.out.print("Money amount : ");
        double amount = scanner.nextDouble();
        wallet.putObjectIn(pocketNumber, new Money(objectId, amount));
        break;
      case 2:
        wallet.putObjectIn(pocketNumber, new Photo(objectId));
        break;
      case 3:
        wallet.putObjectIn(pocketNumber, new Card(objectId, CREDIT_CARD));
        break;
      case 4:
        wallet.putObjectIn(pocketNumber, new Card(objectId, VISIT_CARD));
        break;
      case 5:
        wallet.putObjectIn(pocketNumber, new Card(objectId, DRIVING_CARD));
        break;
      case 6:
        wallet.putObjectIn(pocketNumber, new Card(objectId, NI_CARD));
        break;
      default:
        System.out.println("Unrecognized object type ");
    }
  }

  public static void objectCountMenu(Wallet wallet,
                                    int type) {
    switch (type) {
      case 1:
        System.out.printf("Credit card count : %s %n", wallet.countObject(CREDIT_CARD));
        break;
      case 2:
        System.out.printf("Credit card count : %s %n", wallet.countObject(VISIT_CARD));
        break;
      case 3:
        System.out.printf("Credit card count : %s %n", wallet.countObject(DRIVING_CARD));
        break;
      case 4:
        System.out.printf("Credit card count : %s %n", wallet.countObject(NI_CARD));
        break;
      default:
        System.out.println("Unrecognized object type ");
    }
  }
}
