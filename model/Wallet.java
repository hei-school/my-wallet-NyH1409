package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.common.PocketObject;

public class Wallet {
  private final List<Pocket> pockets;

  public Wallet() {
    pockets = List.of(new Pocket(1),
        new Pocket(2), new Pocket(3),
        new Pocket(4), new Pocket(5));
  }

  public List<Pocket> putObjectIn(int pocketNumber, PocketObject object) {
    return pockets.stream().filter(pk -> pk.getNumber() == pocketNumber)
        .peek(pocket -> pocket.putObject(object)).collect(Collectors.toList());
  }

  public List<Pocket> putObjectOut(int objectId) {
    PocketObject object = getObjects().stream().filter(obj -> obj.getId() == objectId)
        .toList().get(0);
    return pockets.stream()
        .peek(pk -> pk.retrieveObject(object)).collect(Collectors.toList());
  }

  public Pocket getObjectLocation(int objectId) {
    PocketObject object = getObjects().stream().filter(obj -> obj.getId() == objectId)
        .toList().get(0);
    return pockets.stream().filter(pk -> pk.getObjects().contains(object))
        .toList().get(0);
  }

  public List<PocketObject> getObjects() {
    List<PocketObject> objects = new ArrayList<>();
    pockets.stream().map(Pocket::getObjects)
        .forEach(objects::addAll);
    return objects;
  }

  public List<PocketObject> getObjectIn(int pocketNumber) {
    return pockets.stream().filter(pk -> pk.getNumber() == pocketNumber).toList().get(0).getObjects();
  }

  public Double getBalance() {
    List<Money> money = new ArrayList<>();
    pockets.stream().map(Pocket::getObjects)
        .forEach(objectList -> {
          for (PocketObject obj : objectList) {
            if (obj.getClass().equals(Money.class)) {
              money.add((Money) obj);
            }
          }
        });

    return money.stream().map(Money::getAmount).reduce(0.0, Double::sum);
  }

  public int countObject(CardType objectType) {
    List<Card> cards = new ArrayList<>();
    getObjects().forEach(obj -> {
      if (obj.getClass().equals(Card.class)) {
        cards.add((Card) obj);
      }
    });

    switch (objectType) {
      case NI_CARD -> {
        return cards.stream()
            .filter(cd -> cd.getType().equals(CardType.NI_CARD))
            .toList().size();
      }
      case CREDIT_CARD -> {
        return cards.stream()
            .filter(cd -> cd.getType().equals(CardType.CREDIT_CARD))
            .toList().size();
      }
      case DRIVING_CARD -> {
        return cards.stream()
            .filter(cd -> cd.getType().equals(CardType.DRIVING_CARD))
            .toList().size();
      }
      case VISIT_CARD -> {
        return cards.stream()
            .filter(cd -> cd.getType().equals(CardType.VISIT_CARD))
            .toList().size();
      }
    }
    return 0;
  }

}
