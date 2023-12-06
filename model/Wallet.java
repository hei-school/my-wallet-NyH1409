package model;

import java.util.List;

public class Wallet {
  private final List<Pocket> pockets;
  private boolean isSecured;
  private String password;

  public Wallet() {
    isSecured = false;
    pockets = List.of(new Pocket(1), new Pocket(2), new Pocket(3), new Pocket(4), new Pocket(5));
  }

  public void putIn(int pocketNumber, Double amount) {
    if (isSecured) {
      System.out.println("La portefeuille est mon mode securise. Veuillez vous authentifier svp (6)!");
    } else {
      Pocket pocket = pockets.stream().filter(pk -> pk.getNumber() == pocketNumber).toList().get(0);
      pocket.putIn(amount);
    }
  }

  public Double getAmountIn() {
    if (isSecured) {
      System.out.println("La portefeuille est mon mode securise. Veuillez vous authentifier svp (6)!");
    }
    return isSecured ? 0.0 : pockets.stream().map(Pocket::getAmountIn).reduce(0.0, Double::sum);
  }

  public Double getAmountInPocket(int pocketNum) {
    if (isSecured) {
      System.out.println("La portefeuille est mon mode securise. Veuillez vous authentifier svp (6)!");
    }
    Pocket pocket = pockets.stream().filter(pk -> pk.getNumber() == pocketNum).toList().get(0);
    return isSecured ? 0.0 : pocket.getAmountIn();
  }

  public void secure(String pass){
    isSecured = true;
    password = pass;
  }

  public void authenticate(String pass){
    if (pass.equals(password)){
      isSecured = false;
    }else {
      System.out.println("Mot de passe incorrect");
    }
  }

  public void retrieveMoney(int pocketNum, Double amount) {
    Pocket pocket = pockets.stream().filter(pk -> pk.getNumber() == pocketNum).toList().get(0);
    if (isSecured) {
      System.out.println("La portefeuille est mon mode securise. Veuillez vous authentifier svp (6)!");
    } else {
      if (pocket.getAmountIn() < amount) {
        System.out.printf("Les billets dans la poche %s est insuffisant pour le retrait. ", pocketNum);
        double remain = amount - pocket.getAmountIn();
        pocket.empty();
        List<Pocket> random = pockets.stream().filter(pk -> pk.getAmountIn() >= remain).toList();
        if (random.isEmpty()) {
          System.out.println("Vous n'avez pas suffisant d'argent.");
        } else {
          Pocket randomPk = random.get(0);
          double remainInRandom = randomPk.getAmountIn() - remain;
          randomPk.empty();
          randomPk.putIn(remainInRandom);
          System.out.printf("La transaction s'est poursuivi dans la poche %s et votre nouveau solde est %s MGA", randomPk.getNumber(), getAmountIn());
        }
      } else {
        double remain = pocket.getAmountIn() - amount;
        pocket.empty();
        pocket.putIn(remain);
      }
    }
  }
}
