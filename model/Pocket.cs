using System;
using System.Collections.Generic;


public class Pocket
{
    private readonly List<PocketObject> objects;
    private readonly int number;

    public Pocket(int number)
    {
        this.objects = new List<PocketObject>();
        this.number = number;
    }

    public List<PocketObject> GetObjects()
    {
        return objects;
    }

    public int GetNumber()
    {
        return number;
    }

    public void Empty()
    {
        objects.Clear();
    }

    public void PutObject(PocketObject obj)
    {
        objects.Add(obj);
    }

    public void RetrieveObject(PocketObject obj)
    {
        objects.Remove(obj);
    }
}
