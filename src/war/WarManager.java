package war;

import cards.Card;
import cards.DeckOfCards;
import io.Menu;
import war.enums.States;

public class WarManager {
    private DeckOfCards computerDeck;
    private DeckOfCards playerDeck;

    private final Player player = new Player();
    private final Computer computer = new Computer();


    public WarManager() {
        playerDeck = new DeckOfCards(26);
        computerDeck = new DeckOfCards(26);
        playerDeck.shuffle();
        computerDeck.shuffle();
    }

    public void nextRound() {
        States state;

        Card computerCard = drawCard(computerDeck);
        Card playerCard = drawCard(playerDeck);
//      startCountdown();

        System.out.print(playerCard + "\nPlayer\n" + computerCard + "\nComputer\n");


        // get num values of cards
        int computerValue = computerCard.getFace().getValue();
        int playerValue = playerCard.getFace().getValue();

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
        // TODO: Finish War action
        return States.WAR;

    }

    public void startCountdown() {
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

    public Card drawCard(DeckOfCards deck) {
        Card card = deck.getCard(0);
        deck.removeCard(0);
        return card;
    }
}
