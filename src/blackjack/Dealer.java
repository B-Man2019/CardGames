package blackjack;

import cards.Card;
import cards.Deck;

import java.util.ArrayList;

public class Dealer extends Player {
    private Deck deck = new Deck();
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Dealer() {
        deck.shuffle();
        dealInitialCards();
    }

    public States doTurn() {
        int total = calcTotal();
        while (total <= 16) {
            hit();

            if (checkBust()) {
                return States.BUST;
            }

            total = calcTotal();
        }
        return States.STAND;
    }

    private int calcTotal() {
        int total = 0;
        // calculate total of cards
        for (Card card : cards) {
            total += card.getFace().getBjVal();
        }
        return total;
    }

    public int getTotal() {
        return calcTotal();
    }

    public void hit() {
        cards.add(deck.drawCard());
    }

    private boolean checkBust() {
        return calcTotal() > 21;
    }
}
