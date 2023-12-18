import io.Menu;

public class Blackjack {
    public static void main() {
        BlackjackActions actions = new BlackjackActions();
        
        Menu blackjackMenu = new Menu("Welcome to Blackjack");
        blackjackMenu.addAction(() -> actions.main(), "Play Blackjack");
    }
}