package war;

import cards.Deck;
import io.Menu;

public class War {
    public static void main() {
        Deck deck = new Deck();
        deck.drawCard(5);
        WarManager warManager = new WarManager();

        Menu warMenu = new Menu("Welcome to War!");
        warMenu.addAction(warManager::nextRound, "Next Round");
        warMenu.addAction(() -> System.exit(0), "Quit");

        while (warManager.getPlayerDeckSize() > 0) {
            System.out.println(warMenu);
            warMenu.getInput();
        }

        


    }
}
