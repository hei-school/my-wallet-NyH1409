using System;
using Model;
using Model.Common;

namespace Utils
{
    public static class AppUtils
    {
        public static void BeautifulMenu()
        {
            Console.WriteLine("+++++++++++++++++++++++++++++++++++++");
            Console.WriteLine("++wwww+++++++++++++++++++++wwww++++++");
            Console.WriteLine("+++wwww++++++++++++++++++wwww++++++++");
            Console.WriteLine("++++wwww++++wwwwwww++++wwww++++++++++");
            Console.WriteLine("++++++wwww+wwww+wwww+wwww++++++++++++");
            Console.WriteLine("+++++++wwwwww++++wwwwwww+++++++++++++");
            Console.WriteLine("+++++++++++++++++++++++++++++++++++++");
            Console.WriteLine("+++++++++++++++++++++++++++++++++++++");
        }

        public static void Menu()
        {
            Console.WriteLine("Welcome to MyWallet!");
            BeautifulMenu();
            Console.WriteLine("1 - Put object in");
            Console.WriteLine("2 - Put object out");
            Console.WriteLine("3 - Get money balance");
            Console.WriteLine("4 - Get objects in a specific pocket");
            Console.WriteLine("5 - Find object (provide the identifier)");
            Console.WriteLine("6 - Count object [Credit card, visit card, driving card, National Card]");
            Console.WriteLine("7 - Indicate object lost or found");
        }

        public static void ObjectTypeMenu(Wallet wallet, int objectId, int pocketNumber, int type)
        {
            switch (type)
            {
                case 1:
                    Console.Write("Money amount : ");
                    double amount = Convert.ToDouble(Console.ReadLine());
                    wallet.PutObjectIn(pocketNumber, new Money(objectId, amount));
                    break;
                case 2:
                    wallet.PutObjectIn(pocketNumber, new Photo(objectId));
                    break;
                case 3:
                    wallet.PutObjectIn(pocketNumber, new Card(objectId, CardType.CREDIT_CARD));
                    break;
                case 4:
                    wallet.PutObjectIn(pocketNumber, new Card(objectId, CardType.VISIT_CARD));
                    break;
                case 5:
                    wallet.PutObjectIn(pocketNumber, new Card(objectId, CardType.DRIVING_CARD));
                    break;
                case 6:
                    wallet.PutObjectIn(pocketNumber, new Card(objectId, CardType.NI_CARD));
                    break;
                default:
                    Console.WriteLine("Unrecognized object type ");
                    break;
            }
        }

        public static void ObjectCountMenu(Wallet wallet, int type)
        {
            switch (type)
            {
                case 1:
                    Console.WriteLine($"Credit card count : {wallet.CountObject(CardType.CREDIT_CARD)}");
                    break;
                case 2:
                    Console.WriteLine($"Credit card count : {wallet.CountObject(CardType.VISIT_CARD)}");
                    break;
                case 3:
                    Console.WriteLine($"Credit card count : {wallet.CountObject(CardType.DRIVING_CARD)}");
                    break;
                case 4:
                    Console.WriteLine($"Credit card count : {wallet.CountObject(CardType.NI_CARD)}");
                    break;
                default:
                    Console.WriteLine("Unrecognized object type ");
                    break;
            }
        }
    }
}