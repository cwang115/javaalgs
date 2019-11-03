package JavaOOD.Poker;

public class Card{
    //fields
    private final int value;
    private final Suit suit;

    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }


    //methods
    //getter
    public int getValue(){
        return this.value;
    }

    public Suit getSuit(){
        return this.suit;
    }

}
