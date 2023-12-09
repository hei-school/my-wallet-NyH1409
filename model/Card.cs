using Model.Common;

namespace Model
{
    public class Card : PocketObject
    {
        private readonly CardType _type;

        public Card(int id, CardType type) : base(id)
        {
            _type = type;
        }

        public CardType Type
        {
            get { return _type; }
        }

        public override string ToString()
        {
            return $"Card{{type={_type}}}";
        }
    }
}