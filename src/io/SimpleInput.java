package io;

import java.util.Scanner;

public class SimpleInput {
    private Scanner scan = new Scanner(System.in);
    private String message;

    public SimpleInput(String message) {
        this.message = message;
    }

    public int getIntInput() {
        int value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(message + "\n> ");
                value = Integer.parseInt(scan.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer value.");
            }
        }

        return value;
    }

    public double getDoubleInput() {
        double value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(message + "\n> ");
                value = Double.parseDouble(scan.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal value.");
            }
        }
        return value;
    }

    public String getStringInput() {
        String value = "";
        boolean valid = false;

        while (!valid) {
            System.out.print(message + "\n> ");
            value = scan.nextLine();
            if (value.isBlank()) {
                System.out.println("Please enter a value.");
            } else {
                valid = true;
            }
        }
        return value;
    }
}
