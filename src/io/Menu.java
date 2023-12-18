package io;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String title;
    private ArrayList<MenuAction> actions = new ArrayList<>();
    private ArrayList<String> actionContents = new ArrayList<>();

    private Scanner scan = new Scanner(System.in);

    public Menu(String title) {
        this.title = title;
    }

    public void addAction(MenuAction action, String content) {
        actions.add(action);
        actionContents.add(content);
    }

    public String getTitle() {
        return title;
    }

    public void getInput() {

        int choice;
        boolean isValid = false;

        do {
            try {
                System.out.print("\n> ");
                choice = scan.nextInt();

                if (choice >= 1 && choice <= actions.size()) {
                    isValid = true;
                } else {
                    System.out.println("Please enter a valid number.");
                    isValid = false;
                }

            } catch (java.util.InputMismatchException e) {
                choice = 0;
                System.out.println("Please enter a valid number.");
                scan.nextLine();  // Consume the invalid input
                isValid = false;
            }

        } while (!isValid);

        actions.get(choice - 1).execute();
    }

    public String toString() {
        String str = "";
        System.out.println(title);
        
        for (int i = 0; i < actionContents.size(); i++) {
            str += ((i + 1) + ". " + actionContents.get(i) + "\n");
        }
        return str;
    }
}
