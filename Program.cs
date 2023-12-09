using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


class WalletProgram
{
    public static void Main(string[] args)
    {
        var scanner = new Scanner();
        var myWallet = new Wallet();

        while (true)
        {
            Menu();
            Console.Write("Saisir : ");
            int choice = Convert.ToInt32(Console.ReadLine());
            Redirect(scanner, myWallet, choice);
        }
    }

    public static void Redirect(Scanner scanner, Wallet wallet, int choice)
    {
        var objectId = new Random().Next(1, 100);

        switch (choice)
        {
            case 1:
                Console.WriteLine(objectId);
                Console.Write("Which pocket ? (1 - 5) ");
                int pocketNumber = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("Object type : ");
                Console.WriteLine("1 - Money ");
                Console.WriteLine("2 - Photo");
                Console.WriteLine("3 - Credit Card");
                Console.WriteLine("4 - Visit Card");
                Console.WriteLine("5 - Driving Card");
                Console.WriteLine("6 - National Identity Card");
                Console.Write("Choice : ");
                int type = Convert.ToInt32(Console.ReadLine());
                ObjectTypeMenu(wallet, objectId, pocketNumber, type, scanner);
                break;
            case 2:
                Console.WriteLine("All object you can put out ");
                List<PocketObject> objects = wallet.GetObjects();
                foreach (var obj in objects)
                {
                    Console.WriteLine($"[{obj.Id} - {obj.GetType().Name.Substring(6)}]");
                }
                Console.Write("Choose object identifier : ");
                int objId = Convert.ToInt32(Console.ReadLine());
                wallet.PutObjectOut(objId);
                break;
            case 3:
                Console.WriteLine($"Actual Balance : {wallet.GetBalance()} MGA");
                break;
            case 4:
                Console.Write("Which pocket ? (1 - 5) ");
                int pocket = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine($"All objects in pocket number {pocket}");
                List<PocketObject> objectList = wallet.GetObjectIn(pocket);
                foreach (var obj in objectList)
                {
                    Console.WriteLine($"[{obj.Id} - {obj.GetType().Name.Substring(6)}]");
                }
                break;
            case 5:
                List<PocketObject> walletObjects = wallet.GetObjects();
                foreach (var obj in walletObjects)
                {
                    Console.WriteLine($"[{obj.Id} - {obj.GetType().Name.Substring(6)}]");
                }
                Console.Write("Choose object identifier : ");
                int objIde = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine($"Object found in the pocket number {wallet.GetObjectLocation(objIde).GetNumber()}");
                break;
            case 6:
                Console.WriteLine("Object type : ");
                Console.WriteLine("1 - Credit Card");
                Console.WriteLine("2 - Visit Card");
                Console.WriteLine("3 - Driving Card");
                Console.WriteLine("4 - National Identity Card");
                Console.Write("Choice : ");
                int cardType = Convert.ToInt32(Console.ReadLine());
                ObjectCountMenu(wallet, cardType);
                break;
            default:
                break;
        }
    }

    static void Menu(){
        Console.WriteLine("Menu");
    }

    static void ObjectTypeMenu(Wallet wallet, int objectId, int pocketNumber, int type, Scanner scanner){
        Console.WriteLine("Menu");
    }

    static void ObjectCountMenu(Wallet wallet, int cardType){
        Console.WriteLine("Menu");
    }


    public class Scanner
    {
        public int NextInt()
        {
            return Convert.ToInt32(Console.ReadLine());
        }
    }
}

