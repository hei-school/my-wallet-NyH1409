package model.common;

public class PocketObject {
  private final int id;
  private boolean isLost;

  public PocketObject(int id) {
    this.id = id;
  }

  public boolean isLost() {
    return isLost;
  }

  public void setLost(boolean lost) {
    isLost = lost;
  }

  public int getId() {
    return id;
  }
}
