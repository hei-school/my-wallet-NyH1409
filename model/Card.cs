public class Card : PocketObject {
    private CardType cardType { get ; set ; }

    public Card(int id, CardType type): base (id){
        this.cardType = type;
    }
   
}