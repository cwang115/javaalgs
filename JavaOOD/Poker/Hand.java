package JavaOOD.Poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    protected final int id;
    protected List<Card> handcards;
    //constructor

    public Hand(int id) {
        this.id = id;
        this.handcards = new ArrayList<Card>();
    }

    //method
    public void addCard(Card card){
        if(card == null){
            return;
        }
        this.handcards.add(card);
    }

    //
    public void addCard(List<Card> cards){
        //card
        for(Card card : cards){
            this.handcards.add(card);
        }
    }

    /**
     * Return the removed card at index i
     * @param i
     * @return
     */
    public Card removeCard(int i){
        //cc
        if(this.handcards == null || handcards.size() <= i){
            return null;
        }

        return this.handcards.remove(i);
    }


}
