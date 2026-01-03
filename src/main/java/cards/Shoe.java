package cards;

import enums.Rank;
import enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe {

    private final List<Card> cards = new ArrayList<>();
    private final int numberOfDecks;

    public Shoe(int numberOfDecks) {
        if (numberOfDecks <= 0) {
            throw new IllegalArgumentException("Number of decks must be > 0. Use your brain.");
        }
        this.numberOfDecks = numberOfDecks;
        initialize();
        shuffle();
    }

    private void initialize() {
        for (int i = 0; i < numberOfDecks; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    cards.add(new Card(suit, rank));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Shoe is empty. Reshuffle, genius.");
        }
        return cards.remove(cards.size() - 1);
    }

    public int size() {
        return cards.size();
    }
}
