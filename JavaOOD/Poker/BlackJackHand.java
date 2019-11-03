package JavaOOD.Poker;

import java.util.List;

public class BlackJackHand extends Hand{
    /**
     * call the constructor in hand parent class
     * @param id
     */
    public BlackJackHand(int id){
        super(id);

    }

    public int score(){
        if(this.handcards.size() == 0){
            return 0;
        }
        int sum = 0;
        for(Card card: handcards){
            int value = card.getValue();
            if(value > 1 && value <=10){
                sum+=value;
            } else if(value == 11 || value == 12 || value == 13){
                sum+= 10;
            } else {
                //A is either 1 or 11
                if(sum > 10) sum += 1;
                else sum += 11;
            }
        }
        return sum;
    }



    public boolean isBursted(){
        return score() > 21;

    }

    public boolean is21(){
        return score() == 21;
    }

    public boolean isBJ(){
        return score() == 21 && handcards.size() == 2;
    }
}
