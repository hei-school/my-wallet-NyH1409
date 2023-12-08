package model;

import java.util.List;
import java.util.stream.Collectors;
import model.common.PocketObject;

public class Wallet {
  private List<Pocket> pockets;
  private final boolean isSecured;
  private String password;

  public Wallet() {
    isSecured = false;
    pockets = List.of(new Pocket(1), new Pocket(2), new Pocket(3), new Pocket(4), new Pocket(5));
  }

  public void putObjectIn(int pocketNumber, PocketObject object) {
    pockets.stream().filter(pk -> pk.getNumber() == pocketNumber)
        .peek(pocket -> pocket.putObject(object)).collect(Collectors.toList());
  }

  public void putObjectOut(int pocketNumber, int objectId) {
    List<Pocket> pocket = pockets.stream().filter(pk -> pk.getNumber() == pocketNumber)
        .toList();
    PocketObject object = pocket.get(0).getObjects().stream().filter(obj -> obj.getId() == objectId)
        .toList().get(0);
    pocket.stream()
        .peek(pk -> pk.retrieveObject(object)).collect(Collectors.toList());
  }


  public List<Pocket> getPockets() {
    return pockets;
  }
}
