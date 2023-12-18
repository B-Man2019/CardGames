import io.Menu;
import war.War;

public class Main {
    public static void main(String[] args) {
        Menu mainMenu = new Menu("Main Menu");
        mainMenu.addAction(() -> War.main(), "Play War");
        mainMenu.addAction(() -> System.exit(0), "Quit");
        // System.exit terminates the JVM
            System.out.println(mainMenu);
            mainMenu.getInput();


    }
}
