using System;
using System.Collections.Generic;

public class Pocket
{
    private List<float> amounts;
    public int Number { get; private set; }

    public Pocket(int number)
    {
        amounts = new List<float>();
        Number = number;
    }

    public float GetAmountIn()
    {
        return amounts.Sum();
    }

    public void PutIn(float amount)
    {
        amounts.Add(amount);
    }

    public void Empty()
    {
        amounts.Clear();
    }
}