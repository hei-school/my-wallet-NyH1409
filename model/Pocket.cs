using System.Collections.Generic;
using Model.Common;

namespace Model
{
    public class Pocket
    {
        private readonly List<PocketObject> _objects;
        private readonly int _number;

        public Pocket(int number)
        {
            _objects = new List<PocketObject>();
            _number = number;
        }

        public List<PocketObject> Objects
        {
            get { return _objects; }
        }

        public int Number
        {
            get { return _number; }
        }

        public void Empty()
        {
            _objects.Clear();
        }

        public void PutObject(PocketObject obj)
        {
            _objects.Add(obj);
        }

        public void RetrieveObject(PocketObject obj)
        {
            _objects.Remove(obj);
        }

        public override string ToString()
        {
            return $"Pocket{{objects={_objects}, number={_number}}}";
        }
    }
}
