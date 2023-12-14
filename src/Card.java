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

    public String toString() {
        return suit + "\t" + face;
    }
}
