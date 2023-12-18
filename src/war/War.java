package war;

import io.Menu;
import cards.DeckOfCards;

public class War {
    public static void main() {
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
