package war;

import io.Menu;
import io.MenuAction;
import cards.DeckOfCards;
import war.WarComputer;

public class War {
    public static void main() {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        Menu warMenu = new Menu("Welcome to War!");
        warMenu.addAction(() -> WarManager.nextRound(deck), "Next Round");
    }
}
