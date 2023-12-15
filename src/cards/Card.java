package cards;

import cards.enums.Faces;
import cards.enums.Suits;


public class Card {
    Suits suit;
    Faces face;

    // ****************************
    // Stores a single playing card
    // ****************************
    public Card(Suits suit, Faces face) {
        this.suit = suit;
        this.face = face;
    }

    public Faces getFace() {
        return face;
    }

    public Suits getSuit() {
        return suit;
    }

    public String toString() {
        return suit + "\t" + face;
    }
}
