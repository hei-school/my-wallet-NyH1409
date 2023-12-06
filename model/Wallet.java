package model;

import java.util.List;

public class Wallet {
  private final List<Pocket> pockets;

  public Wallet() {
    pockets = List.of(new Pocket(1),
        new Pocket(2), new Pocket(3)
        , new Pocket(4), new Pocket(5));
  }

  public void putIn(int pocketNumber, Double amount) {
    Pocket pocket = pockets.stream()
        .filter(pk -> pk.getNumber() == pocketNumber)
        .toList().get(0);
    pocket.putIn(amount);
  }

  public Double getAmountIn() {
    return pockets.stream()
        .map(Pocket::getAmountIn)
        .reduce(0.0, Double::sum);
  }
}
