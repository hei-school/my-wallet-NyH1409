using System;
using System.Collections.Generic;
using System.Linq;

public class Wallet
{
    private bool isSecured;
    private string password;
    private List<Pocket> pockets;

    public Wallet()
    {
        isSecured = false;
        password = "";
        pockets = new List<Pocket> { new Pocket(1), new Pocket(2), new Pocket(3), new Pocket(4), new Pocket(5) };
    }

    public void PutIn(int pocketNumber, float amount)
    {
        if (isSecured)
        {
            Console.WriteLine("La portefeuille est en mode sécurisé. Veuillez vous authentifier svp (6)");
        }
        else
        {
            Pocket pocket = pockets.First(pk => pk.Number == pocketNumber);
            pocket.PutIn(amount);
        }
    }

    public float GetAmountIn()
    {
        if (isSecured)
        {
            Console.WriteLine("La portefeuille est en mode sécurisé. Veuillez vous authentifier svp (6)!");
            return 0; // You may want to handle this differently based on your application's logic.
        }
        else
        {
            return pockets.Sum(pk => pk.GetAmountIn());
        }
    }

    public float GetAmountInPocket(int pocketNumber)
    {
        if (isSecured)
        {
            Console.WriteLine("La portefeuille est en mode sécurisé. Veuillez vous authentifier svp (6)!");
            return 0; // You may want to handle this differently based on your application's logic.
        }
        else
        {
            Pocket pocket = pockets.First(pk => pk.Number == pocketNumber);
            return pocket.GetAmountIn();
        }
    }

    public void Secure(string password)
    {
        isSecured = true;
        this.password = password;
    }

    public void Authenticate(string password)
    {
        if (this.password == password)
        {
            isSecured = false;
        }
        else
        {
            Console.WriteLine("Mot de passe incorrect");
        }
    }

    public void RetrieveMoney(int pocketNumber, float amount)
    {
        Pocket pocket = pockets.First(pk => pocketNumber == pk.Number);

        if (isSecured)
        {
            Console.WriteLine("La portefeuille est en mode sécurisé. Veuillez vous authentifier svp (6)!");
        }
        else
        {
            if (pocket.GetAmountIn() < amount)
            {
                Console.WriteLine($"Les billets dans la poche {pocketNumber} sont insuffisants pour le retrait.");
                float remain = amount - pocket.GetAmountIn();
                pocket.Empty();
                var random = pockets.FirstOrDefault(pk => pk.GetAmountIn() >= remain);

                if (random == null)
                {
                    Console.WriteLine("Vous n'avez pas assez d'argent.");
                }
                else
                {
                    float remainInRandom = random.GetAmountIn() - remain;
                    random.Empty();
                    random.PutIn(remainInRandom);
                }
            }
            else
            {
                float remain = pocket.GetAmountIn() - amount;
                pocket.Empty();
                pocket.PutIn(remain);
            }
        }
    }
}
