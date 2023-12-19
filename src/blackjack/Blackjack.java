package blackjack;

import io.Menu;

public class Blackjack {
    public static void main() {
        BlackjackManager manager = new BlackjackManager();
        while (true) {
            Menu blackjackMenu = new Menu("Welcome to Blackjack");
            blackjackMenu.addAction(() -> manager.main(), "Start Blackjack");
            System.out.println("Your current balance is " + manager.getFormattetedPlayerBalance());
            System.out.println(blackjackMenu);

            blackjackMenu.getInput();
        }

    }
}