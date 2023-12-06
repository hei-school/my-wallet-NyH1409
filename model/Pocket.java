package model;

import java.util.ArrayList;
import java.util.List;

public class Pocket {
  private final List<Double> amounts;
  private final int number;

  public Pocket(int number) {
    this.amounts = new ArrayList<>();
    this.number = number;
  }

  public List<Double> getAmounts() {
    return amounts;
  }

  public Double getAmountIn() {
    return amounts.stream()
        .reduce(0.0, Double::sum);
  }

  public int getNumber() {
    return number;
  }

  public void putIn(double amount) {
    amounts.add(amount);
  }

  public void empty(){
    amounts.clear();
  }

}
