package blackjack;

import cards.Card;
import cards.enums.Faces;
import io.Menu;
import io.SimpleInput;

import java.util.ArrayList;


/*
    class for controlling blackjack
    takes input, prints to terminal, etc.
*/
class BlackjackManager {
    Player player = new Player(5000);
    int cardTotal = 0;
    boolean exitTurn = false;
    States state;

    public void main() {
        exitTurn = false;
        cardTotal = 0;
        state = States.STAND; // no default lol
        player.reset();


        startBet(); // start betting process
        player.dealInitialCards(); // deal 2 cards

        Dealer dealer = new Dealer();

        cardTotal = calcTotal();

        while (!exitTurn) {
            if (checkBust()) {
                System.out.println("You busted! It's the dealers turn now.");
                state = States.BUST;
                exitTurn = true;
                break;
            }

            calcAce();

            System.out.println(player); // display info

            Menu turnMenu = new Menu("What do you want to do?");

            turnMenu.addAction(() -> exitTurn = true, "Stand");
            turnMenu.addAction(() -> player.hit(), "Hit");
            turnMenu.addAction(() -> System.exit(0), "Quit");
          if (player.numCards() == 2) {
              turnMenu.addAction(() -> doubleDown(), "Double Down");
              turnMenu.addAction(() -> surrender(), "Surrender");
          }

            System.out.println(turnMenu);
            turnMenu.getInput();


        }

        States dealerState = dealer.doTurn();

        if (state == States.BUST && dealerState == States.BUST) {
            System.out.println("You tied, since the dealer and you busted.");
        } else if (state == States.BUST) {
            System.out.println("You busted. The dealer got " + dealer.getTotal());
            player.setBalance(player.getRawBalance() - player.getRawBet());

        } else if (dealerState == States.BUST) {
            System.out.println("The dealer busted, so you win!");
            player.setBalance(player.getRawBalance() + player.getRawBet());

        } else {
            if (dealer.getTotal() > calcTotal()) {
                System.out.println("The dealer won with a total of " + dealer.getTotal());
                player.setBalance(player.getRawBalance() - player.getRawBet());
            } else {
                System.out.println("You won! The dealer had a total of " + dealer.getTotal());
                player.setBalance(player.getRawBalance() + player.getRawBet());
            }
        }
    }

    private void startBet() {
        Menu bettingMenu = new Menu("Bet");
        bettingMenu.addAction(() -> setBet(), "Set bet");
        bettingMenu.addAction(() -> System.exit(0), "Quit");

        System.out.println(bettingMenu);

        bettingMenu.getInput();
    }

    private void setBet() {
        boolean valid = false;
        while (!valid) {
            System.out.println("You have " + player.getFormattedBalance());

            SimpleInput setBet = new SimpleInput("How much would you like to bet?");
            double amt = setBet.getDoubleInput();
            valid = player.setBet(amt, false);

            if (!valid) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }

    private void calcAce() {
        if (cardTotal + 11 > 21) {
            Faces.setAceVal(1);
        } else {
            Faces.setAceVal(11);
        }
    }

    private int calcTotal() {
        int total = 0;
        // calculate total of cards
        ArrayList<Card> cards = player.getCards();
        for (Card card : cards) {
            total += card.getFace().getBjVal();
        }
        return total;
    }

    private boolean checkBust() {
        return calcTotal() > 21;
    }

    private void doubleDown() {
        if (player.getRawBet() * 2 > player.getRawBalance()) {
            System.out.println("You can't double down, as you don't have enough money.");
            return;
        }

        player.setBet(player.getRawBet() * 2, false);
        player.hit();
    }

    public States getState() {
        return state;
    }

    private void surrender() {
        exitTurn = true;
        player.setBet(player.getRawBet() / 2, true);
        state = States.BUST;
    }

    public String getFormattetedPlayerBalance() {
        return player.getFormattedBalance();
    }
}