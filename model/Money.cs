using Model.Common;

namespace Model
{

    public class Money : PocketObject
    {
        private double _amount;

        public Money(int id, double amount) : base(id)
        {
            _amount = amount;
        }

        public double Amount
        {
            get { return _amount; }
            set { _amount = value; }
        }

        public override string ToString()
        {
            return $"Money{{amount={_amount}}}";
        }
    }
    
}

