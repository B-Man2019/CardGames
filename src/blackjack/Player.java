package blackjack;

import cards.Card;
import cards.Deck;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Player {
    private double bet = 0;
    private double balance;
    private Deck deck = new Deck();
    private ArrayList<Card> cards = new ArrayList<Card>();




    public Player(double balance) {
        this.balance = balance;
        deck.shuffle();
    }

    // for dealer
    public Player() {
        balance = 0;
        deck.shuffle();
    }

    public double getRawBet() {
        return bet;
    }

    public String getFormattedBet() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(bet);
    }

    public boolean setBet(double num, boolean force) {
        if (force) {
            bet = num;
            return true;
        }

        if (num >= 0 && num <= balance) {
            bet = num; // set bet = num
            return true;
        } else {
            return false; // invalid amount bet - return false
        }
    }

    public double getRawBalance() {
        return balance;
    }

    public String getFormattedBalance() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(balance);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String returnFormattedCards() {
        String str = "";
        for (Card card : cards) {
            str += card + "\n";
        }
        return str;
    }

    public void dealInitialCards() {
        cards.add(deck.getCard(0));
        deck.removeCard(0);

        cards.add(deck.getCard(0));
        deck.removeCard(0);
    }

    public void hit() {
        cards.add(deck.drawCard());
    }

    public void setBalance(double num) {
        balance = num;
    }

    public int numCards() {
        return cards.size();
    }

    private int calcTotal() {
        int total = 0;
        // calculate total of cards
        for (Card card : cards) {
            total += card.getFace().getBjVal();
        }
        return total;
    }

    public void reset() {
        bet = 0;
        deck = new Deck();
        deck.shuffle();
        cards = new ArrayList<Card>();

    }

    public String toString() {
        return "Balance: " + getFormattedBalance()
                + "\nAmount bet: " + getFormattedBet()
                + "\nCards:\n" + returnFormattedCards()
                + "\nTotal: " + calcTotal();

    }
}
