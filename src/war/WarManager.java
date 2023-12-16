package war;

import cards.Card;
import cards.DeckOfCards;
import war.enums.States;

public class WarManager {
    public WarManager() {
        DeckOfCards playerDeck = new DeckOfCards(26);
        DeckOfCards computerDeck = new DeckOfCards(26);
        playerDeck.shuffle();
        computerDeck.shuffle();
    }

    public static States nextRound() {
        States state = null;

        Card computerCard = WarComputer.drawCard(computerDeck);
        Card playerCard = Player.drawCard(playerDeck);

        int computerValue = computerCard.getFace().getValue();
        int playerValue = playerCard.getFace().getValue();

        if (computerValue > playerValue) {
            WarComputer.incrementCards(2);
            state = States.LOSE;
        } else if (playerValue > computerValue) {
            Player.incrementCards(2);
            state = States.WIN;
        } else {
            state = States.WAR;
        }   
        return state;
    }
    
    public static States initalizeWar() {
        return States.WAR;
    } 
}
