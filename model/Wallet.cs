using System;
using System.Collections.Generic;
using System.Linq;


public class Wallet
{
    private List<Pocket> pockets;

    public Wallet()
    {
        pockets = new List<Pocket>
        {
            new Pocket(1),
            new Pocket(2),
            new Pocket(3),
            new Pocket(4),
            new Pocket(5)
        };
    }

    public List<Pocket> PutObjectIn(int pocketNumber, PocketObject obj)
    {
        return pockets
            .Where(pk => pk.number == pocketNumber)
            .Peek(pocket => pocket.PutObject(obj))
            .ToList();
    }

    public List<Pocket> PutObjectOut(int objectId)
    {
        PocketObject obj = GetObjects().First(o => o.id == objectId);
        return pockets
            .Peek(pk => pk.RetrieveObject(obj))
            .ToList();
    }

    public Pocket GetObjectLocation(int objectId)
    {
        PocketObject obj = GetObjects().First(o => o.Id == objectId);
        return pockets.First(pk => pk.objects.Contains(obj));
    }

    public List<PocketObject> GetObjects()
    {
        List<PocketObject> objects = new List<PocketObject>();
        pockets.SelectMany(pk => pk.objects).ToList().ForEach(objects.Add);
        return objects;
    }

    public List<PocketObject> GetObjectIn(int pocketNumber)
    {
        return pockets.First(pk => pk.number == pocketNumber).objects;
    }

    public double GetBalance()
    {
        List<Money> money = new List<Money>();
        pockets.SelectMany(pk => pk.objects)
            .OfType<Money>()
            .ToList()
            .ForEach(obj => money.Add(obj));

        return money.Select(m => m.amount).Sum();
    }

    public int CountObject(CardType objectType)
    {
        List<Card> cards = GetObjects().OfType<Card>().ToList();

        return objectType switch
        {
            CardType.NI_CARD => cards.Count(cd => cd.Type == CardType.NI_CARD),
            CardType.CREDIT_CARD => cards.Count(cd => cd.Type == CardType.CREDIT_CARD),
            CardType.DRIVING_CARD => cards.Count(cd => cd.Type == CardType.DRIVING_CARD),
            CardType.VISIT_CARD => cards.Count(cd => cd.Type == CardType.VISIT_CARD),
            _ => 0
        };
    }
}