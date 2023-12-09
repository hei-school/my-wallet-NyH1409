using System;
using System.Collections.Generic;
using System.Linq;
using Model.Common;

namespace Model
{
    public class Wallet
    {
        private readonly List<Pocket> _pockets;

        public Wallet()
        {
            _pockets = Enumerable.Range(1, 5).Select(i => new Pocket(i)).ToList();
        }

        public List<Pocket> PutObjectIn(int pocketNumber, PocketObject obj)
        {
            var matchingPockets = _pockets.Where(pocket => pocket.Number == pocketNumber).ToList();
            if (matchingPockets.Any())
            {
                matchingPockets[0].PutObject(obj);
            }
            return matchingPockets;
        }

        public List<Pocket> PutObjectOut(int objectId)
        {
            var obj = GetObjects().FirstOrDefault(o => o.Id == objectId);
            if (obj != null)
            {
                foreach (var pocket in _pockets)
                {
                    pocket.RetrieveObject(obj);
                }
            }
            return _pockets;
        }

        public Pocket GetObjectLocation(int objectId)
        {
            var obj = GetObjects().FirstOrDefault(o => o.Id == objectId);
            return obj != null ? _pockets.FirstOrDefault(pocket => pocket.Objects.Contains(obj)) : null;
        }

        public List<PocketObject> GetObjects()
        {
            return _pockets.SelectMany(pocket => pocket.Objects).ToList();
        }

        public List<PocketObject> GetObjectIn(int pocketNumber)
        {
            var matchingPocket = _pockets.FirstOrDefault(pocket => pocket.Number == pocketNumber);
            return matchingPocket?.Objects ?? new List<PocketObject>();
        }

        public double GetBalance()
        {
            var money = GetObjects().OfType<Money>().ToList();
            return money.Sum(m => m.Amount);
        }

        public int CountObject(CardType objectType)
        {
            var cards = GetObjects().OfType<Card>().ToList();
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
}

