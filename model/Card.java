package model;

import model.common.PocketObject;

public class Card extends PocketObject {
  private final CardType type;

  public Card(int id, CardType type) {
    super(id);
    this.type = type;
  }

  public CardType getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Card{" +
        "type=" + type +
        '}';
  }
}
