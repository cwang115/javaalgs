package JavaOOD.Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
        private List<Card> cards;
        Random random = new Random();
        //create 13 cards for each suit
        public Deck(){
            this.cards = new ArrayList<>();
            for(Suit suit : Suit.values()){
                for(int i = 1; i <= 13; i++){
                    cards.add(new Card(i, suit));
                }
            }
        }

        public void shuffle(){
            for(int i = 0; i < cards.size(); i++){
                int j = random.nextInt(cards.size() - i) + i;
                Card card1 = cards.get(i);
                Card card2 = cards.get(j);
                cards.set(i, card2);
                cards.set(j, card1);
            }
        }

    /**
     *
     * @return the remaining deck after dealing one card
     */
    public Card deal(){
            return this.cards.remove(cards.size() -1);
        }

    /**
     *
     * @param num
     * @return the remaining deck after dealing a number of card
     */
    public List<Card> deal(int num){
            for(int i = 0; i < num; i++){
                deal();
            }
            return this.cards;
    }




}
