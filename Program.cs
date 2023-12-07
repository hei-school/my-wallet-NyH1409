using System;

class WalletProgram
{
    static void Main()
    {
        Wallet myWallet = new Wallet();

        while (true)
        {
            Menu();
            int choice = GetIntInput("Saisir : ");
            Redirect(myWallet, choice);
        }
    }

    static void Menu()
    {
        Console.WriteLine("Bienvenue sur MyWallet!");
        Console.WriteLine("1 - Placer de l'argent dans une poche");
        Console.WriteLine("2 - Consulter le montant total dans une poche");
        Console.WriteLine("3 - Consulter le montant total dans la portefeuille");
        Console.WriteLine("4 - Retirer de l'argent");
        Console.WriteLine("5 - Securiser la portefeuille");
        Console.WriteLine("6 - S'identifier");
    }

    static void Redirect(Wallet wallet, int choice)
    {
        if (choice == 1)
        {
            int pocketNumber = GetIntInput("Dans quelle poche ? (1 - 4) ");
            float amount = GetFloatInput("Le montant a placer ? (MGA) ");
            wallet.PutIn(pocketNumber, amount);
        }
        else if (choice == 2)
        {
            int pocketNumber = GetIntInput("Dans quelle poche ? (1 - 4) ");
            Console.WriteLine($"Dans la poche {pocketNumber}, vous avez {wallet.GetAmountInPocket(pocketNumber)} (MGA)");
        }
        else if (choice == 3)
        {
            Console.WriteLine($"Dans la portefeuille, vous avez {wallet.GetAmountIn()} (MGA)");
        }
        else if (choice == 4)
        {
            int pocketNumber = GetIntInput("Dans quelle poche ? (1 - 4) ");
            float toPull = GetFloatInput("Le montant a retirer ? (MGA) ");
            wallet.RetrieveMoney(pocketNumber, toPull);
        }
        else if (choice == 5)
        {
            string password = GetStringInput("Ajouter un mot de passe : ");
            wallet.Secure(password);
        }
        else if (choice == 6)
        {
            string password = GetStringInput("Entrer le mot de passe : ");
            wallet.Authenticate(password);
        }
        else
        {
            Console.WriteLine($"Vous avez dans votre portefeuille : {wallet.GetAmountIn()}");
        }
    }

    static int GetIntInput(string message)
    {
        Console.Write(message);
        return int.Parse(Console.ReadLine());
    }

    static float GetFloatInput(string message)
    {
        Console.Write(message);
        return float.Parse(Console.ReadLine());
    }

    static string GetStringInput(string message)
    {
        Console.Write(message);
        return Console.ReadLine();
    }
}
