package war;

import cards.Card;
import cards.DeckOfCards;

public class Player {
    private static int numCards;

    public static void incrementCards() {
        numCards++;
    }

    public static void incrementCards(int num) {
        numCards += num;
    }

    public static int getNumCards() {
        return numCards;
    }

    
    public static Card drawCard(DeckOfCards deck) {
        return deck.getCard(0);
    }
}
