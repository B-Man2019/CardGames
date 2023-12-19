package cards;

import java.security.SecureRandom;
import java.util.ArrayList;

import cards.enums.Faces;
import cards.enums.Suits;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        for (Suits suit: Suits.values()) { // .values creates an array of the enums
            for (Faces face: Faces.values()) {
                deck.add(new Card(suit, face));
            }
        }
    }

    public Deck(int num) {
        Suits[] suits = Suits.values();
        Faces[] faces = Faces.values();

        int count = 0;

        for (int r = 0; r < suits.length; r++) {
            for (int c = 0; c < faces.length; c++) {
                deck.add(new Card(suits[r], faces[c]));
                count++;

                if (count == num) {
                    break;
                }
            }

            if (count == num) {
                break;
            }
        }
    }

    // *****************************
    // I improved the algorithm to
    // use secure random - more secure
    // *****************************
    public void shuffle() {
        SecureRandom secureRandom = new SecureRandom();

        for (int i = deck.size() - 1; i > 0; i--) {
            int randIndex = secureRandom.nextInt(i + 1);

            Card temp = deck.get(i);
            deck.set(i, deck.get(randIndex));
            deck.set(randIndex, temp);
        }
    }

    public int deckSize() {
        int len = 0;

        for (int i = 0; i < deck.size(); i++) {
            len++;
        }
        return len;
    }

    public void addCard(Suits suit, Faces face) {
        deck.add(new Card(suit, face));
    }

    public Card getCard(int index) {
        return deck.get(index);
    }

    public void removeCard(int index) {
        deck.remove(index);
    }

    public Card drawCard() {
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public Card[] drawCard(int num) {
        int count = 0; 

        Card[] cards = new Card[num];
        while (deck.size() > 0 && count < num) {
            cards[count] = deck.get(0);
            deck.remove(0);
            count++;
        }

        return cards;
    }


    public String toString() {
        String str = "";
        for (Card card : deck) {
            str += card + "\n";
        }
        return str;
    }
}
