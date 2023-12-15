package war;

import cards.Card;
import cards.DeckOfCards;
import war.enums.States;

public class WarManager {
    public static States nextRound(DeckOfCards deck) {
        Card computerCard = WarComputer.drawCard(deck);
        Card playerCard = Player.drawCard(deck);

        int computerValue = computerCard.getFace().getValue();
        int playerValue = playerCard.getFace().getValue();

        if (computerValue > playerValue) {
            WarComputer.incrementCards(2);
        }
    }
}
