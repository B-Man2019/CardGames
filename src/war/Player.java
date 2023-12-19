package war;

public class Player {
    public Player() {
        // leave empty
    }
    private int numCards;

    public void incrementCards() {
        numCards++;
    }

    public void incrementCards(int num) {
        numCards += num;
    }

    public int getNumCards() {
        return numCards;
    }
}
