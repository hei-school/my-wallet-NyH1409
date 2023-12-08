package model;

import java.util.ArrayList;
import java.util.List;
import model.common.PocketObject;

public class Pocket {
  private final List<PocketObject> objects;
  private final int number;

  public Pocket(int number) {
    this.objects = new ArrayList<>();
    this.number = number;
  }

  public List<PocketObject> getObjects() {
    return objects;
  }

  public int getNumber() {
    return number;
  }

  public void empty() {
    objects.clear();
  }

  public void putObject(PocketObject object){
    objects.add(object);
  }

  public void retrieveObject(PocketObject object){
    objects.remove(object);
  }


  @Override
  public String toString() {
    return "Pocket{" +
        "objects=" + objects +
        ", number=" + number +
        '}';
  }
}
