package com.company;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class CountriesApp {
    static int userNum;

    public static void displayMenu() {
        System.out.println("1: Display list of countries");
        System.out.println("2: Add country to list");
        System.out.println("3: Delete country from list");
        System.out.println("4: Exit");
        userNum = Validate.validateInt("Please select (1-4): ", 1, 4);
    }


    public static void main(String[] args) {
        boolean continueLoop = true;
        String userString;
        String file = "countries.txt";

        while (continueLoop) {
            displayMenu();
            if (userNum == 1) {
                CountriesTextFile.readText(file);
            } else if (userNum == 2) {
                userString = Validate.getString("Please enter a country: ");
                if (CountriesTextFile.isDuplicate(file, userString)) {
                    System.out.println("Country already exist in list!");
                } else {
                    CountriesTextFile.writeTextToFile(file, userString);
                }
            } else if (userNum == 3) {
                userString = Validate.getString("Please enter country to delete: ");
                if (CountriesTextFile.isDuplicate(file, userString)) {
                    CountriesTextFile.deleteText(file, userString);
                } else {
                    System.out.println("Country does not exist in list to delete!");
                }
            } else {
                continueLoop = false;
            }
            userString = Validate.validateString("Would you like to return to main menu? (Y/N)", "y", "n");
            if (userString.equalsIgnoreCase("n")) {
                continueLoop = false;
            }
        }
        System.out.println("Goodbye!");
    }
}
