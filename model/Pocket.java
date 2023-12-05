package model;

import java.util.ArrayList;
import java.util.List;

public class Pocket {
  private final List<Double> amountIn;
  private final int number;

  public Pocket(int number) {
    this.amountIn = new ArrayList<>();
    this.number = number;
  }

  public Double getAmountIn() {
    return amountIn.stream()
        .reduce(0.0, Double::sum);
  }

  public int getNumber() {
    return number;
  }

  public void putIn(double amount) {
    amountIn.add(amount);
  }

}
