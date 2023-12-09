package model;

import model.common.PocketObject;

public class Money extends PocketObject {
  private double amount;

  public Money(int id, double amount) {
    super(id);
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Money{" +
        "amount=" + amount +
        '}';
  }
}
