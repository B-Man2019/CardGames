import io.Menu;
import war.War;
import blackjack.Blackjack;

public class Main {
    public static void main(String[] args) {
        Menu mainMenu = new Menu("Main Menu");
        mainMenu.addAction(() -> War.main(), "Play War");
        mainMenu.addAction(() -> Blackjack.main(), "Play Blackjack");
        mainMenu.addAction(() -> System.exit(0), "Quit");

        // System.exit terminates the JVM
        System.out.println(mainMenu);
        mainMenu.getInput();
    }
}
