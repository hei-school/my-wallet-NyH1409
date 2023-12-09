public class Money : PocketObject {
  private double amount { get ; set ;}

  public Money(int id, double amount) : base(id) {
    this.amount = amount;
  }

}