using System;
using Utils;
using Model;

class MainClass
{
    public static void Main(string[] args)
    {
        var myWallet = new Wallet();

        while (true)
        {
            AppUtils.Menu();
            Console.Write("Saisir : ");
            var choice = int.Parse(Console.ReadLine());
            Redirect(myWallet, choice);
        }
    }

    public static void Redirect(Wallet wallet, int choice)
    {
        var objectId = new Random().Next(1, 100);

        switch (choice)
        {
            case 1:
                Console.Write("Which pocket ? (1 - 5) ");
                var pocketNumber = int.Parse(Console.ReadLine());
                Console.WriteLine("Object type : ");
                Console.WriteLine("1 - Money ");
                Console.WriteLine("2 - Photo");
                Console.WriteLine("3 - Credit Card");
                Console.WriteLine("4 - Visit Card");
                Console.WriteLine("5 - Driving Card");
                Console.WriteLine("6 - National Identity Card");
                Console.Write("Choice : ");
                var type = int.Parse(Console.ReadLine());
                AppUtils.ObjectTypeMenu(wallet, objectId, pocketNumber, type);
                break;
            case 2:
                Console.WriteLine("All object you can put out ");
                var objects = wallet.GetObjects();
                foreach (var obj in objects)
                {
                    Console.WriteLine($"[{obj.Id} - {obj.GetType().Name}] ");
                }
                Console.Write("Choose object identifier : ");
                var objId = int.Parse(Console.ReadLine());
                wallet.PutObjectOut(objId);
                break;
            case 3:
                Console.WriteLine($"Actual Balance : {wallet.GetBalance()} MGA ");
                break;
            case 4:
                Console.Write("Which pocket ? (1 - 5) ");
                var pocket = int.Parse(Console.ReadLine());
                Console.WriteLine($"All objects in pocket number {pocket} ");
                var objectList = wallet.GetObjectIn(pocket);
                foreach (var obj in objectList)
                {
                    Console.WriteLine($"[{obj.Id} - {obj.GetType().Name}] ");
                }
                break;
            case 5:
                var walletObjects = wallet.GetObjects();
                foreach (var obj in walletObjects)
                {
                    Console.WriteLine($"[{obj.Id} - {obj.GetType().Name}] ");
                }
                Console.Write("Choose object identifier : ");
                var objIde = int.Parse(Console.ReadLine());
                Console.WriteLine($"Object found in the pocket number {wallet.GetObjectLocation(objIde).Number} ");
                break;
            case 6:
                Console.WriteLine("Object type : ");
                Console.WriteLine("1 - Credit Card");
                Console.WriteLine("2 - Visit Card");
                Console.WriteLine("3 - Driving Card");
                Console.WriteLine("4 - National Identity Card");
                Console.Write("Choice : ");
                var cardType = int.Parse(Console.ReadLine());
                AppUtils.ObjectCountMenu(wallet, cardType);
                break;
            default:
                break;
        }
    }
}

