package war;

import cards.Card;
import cards.Deck;
import io.Menu;
import war.enums.States;

public class WarManager {
    private Deck computerDeck;
    private Deck playerDeck;

    private final Player player = new Player();
    private final Computer computer = new Computer();


    public WarManager() {
        playerDeck = new Deck(26);
        computerDeck = new Deck(26);
        playerDeck.shuffle();
        computerDeck.shuffle();
        
    }

    public void nextRound() {
        States state;

        Card computerCard = computerDeck.drawCard();
        Card playerCard = playerDeck.drawCard();
        startCountdown();

        System.out.print("\nPlayer: " +  playerCard + "\nComputer: " + computerCard + "\n");


        // get num values of cards
        int computerValue = computerCard.getFace().getWarVal();
        int playerValue = playerCard.getFace().getWarVal();

        state = getState(computerValue, playerValue);

        System.out.println(state.getFormat()); // print out if they won or lost

        System.out.println("You have " + player.getNumCards() + " cards. The computer has " + computer.getNumCards() + " cards.");
    }

    private States getState(int computerValue, int playerValue) {
        States state;
        if (computerValue > playerValue) {
            computer.incrementCards(2);
            state = States.LOSE;
        } else if (playerValue > computerValue) {
            player.incrementCards(2);
            state = States.WIN;
        } else {
            state = startWar();
        }
        return state;
    }

    private States startWar() {
        Menu warActionMenu = new Menu("WAR!");

        warActionMenu.addAction(() -> System.out.println(), "Engage war");

        System.out.println(warActionMenu);
        warActionMenu.getInput();
        startCountdown();
        // simulate drawing 3 cards
        playerDeck.drawCard(3);
        computerDeck.drawCard(3);

        Card computerCard = computerDeck.drawCard();
        Card playerCard = playerDeck.drawCard();

        System.out.print("\nPlayer: " +  playerCard + "\nComputer: " + computerCard );

        int playerValue = playerCard.getFace().getWarVal();
        int computerValue = computerCard.getFace().getWarVal();

        if (playerValue > computerValue) {
            // 2 cards drawn before + 6 cards drawn for war + 2 more drawn for war
            player.incrementCards(10);
            return States.WIN;
        } else if (playerValue < computerValue) {
            computer.incrementCards(10);
            return States.LOSE;
        } else {
            startWar();
            return States.WAR;
        }

    }

    private void startCountdown() {
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("An error occurred while making the countdown.");
            }
        }
    }

    public int getPlayerDeckSize() {
        return playerDeck.deckSize();
    }
}
