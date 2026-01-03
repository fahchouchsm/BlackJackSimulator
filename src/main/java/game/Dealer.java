package game;

import cards.Shoe;

public class Dealer {

    private final Hand hand = new Hand();

    public Hand getHand() {
        return hand;
    }

    public void play(Shoe shoe) {
        while (hand.getValue() < 17) {
            hand.add(shoe.draw());
        }
    }
}
