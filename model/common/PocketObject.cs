namespace Model.Common
{
    public class PocketObject
    {
        private readonly int _id;
        private bool _isLost;

        public PocketObject(int id)
        {
            _id = id;
        }

        public bool IsLost
        {
            get { return _isLost; }
            set { _isLost = value; }
        }

        public int Id
        {
            get { return _id; }
        }
    }
}
