package war;

import io.Menu;
import cards.DeckOfCards;

public class War {
    public static void main() {
        WarManager warManager = new WarManager();

        Menu warMenu = new Menu("Welcome to War!");
        warMenu.addAction(() -> WarManager.nextRound(), "Next Round");
    }
}
