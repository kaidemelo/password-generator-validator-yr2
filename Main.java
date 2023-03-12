package com.company;

import java.util.Scanner; //imports scanner library

public class Main {

    public static void main(String[] args) {

        Scanner scanChoice = new Scanner(System.in);
        //Makes new object of the scanner class and stores it in the variable scanChoice
        int menuChoice;     //Declares: menuChoice as an variable of type integer in the main method of the main class.

        do {
            System.out.println("\n" + "1: Generate A Password");
            System.out.println("2: Validate A Password");
            System.out.println("3: Quit Program" + "\n");
            System.out.println("Enter Option:  \"1\", \"2\" or \"3\"");
            //Password generator/validator menu
            menuChoice = scanChoice.nextInt();
            //The menuChoice variable stores the next integer entered by the user and uses it for the switch statement

            //Switch statement for the password generator/validator menu
            switch (menuChoice) {
                case 1:
                    // Option 1
                    //Asks the user for details about the password they desire to generate, and returns the generated password.
                    System.out.println("---------------------------------" + "\n");
                    System.out.println("Enter How Long You Want The Password To Be: ");
                    int length = scanChoice.nextInt();
                    System.out.println("..." + "\n");
                    System.out.println("Enter How Many Symbols You Want The Password To Have: " + "\n");
                    int symbols = scanChoice.nextInt();
                    System.out.println("..." + "\n");
                    System.out.println("Enter How Many Digits You Want The Password To Have: " + "\n");
                    int digits = scanChoice.nextInt();
                    System.out.println(Password.passGenerator(length, symbols, digits));
                    break;
                case 2:
                    // Option 2
                    /*Asks the user the password they require to validate then returns the result of the
                    passValidator() method in the Password class. */
                    System.out.println("---------------------------------" + "\n");
                    System.out.println("Enter The Password You Want To Validate: ");
                    String valPassword = scanChoice.next();
                    System.out.println("---------------------------------");
                    System.out.println("\n" + Password.passValidator(valPassword) + "\n");
                    System.out.println("---------------------------------");
                    break;
                case 3:
                    // Option 3
                    //Quit option for the program.
                    System.out.println("Bye...");
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 3.");
                    //Message output if the user input is not in the specified range or of the correct type.
            }
        } while (menuChoice != 3);
        /*This "Do While" loop means that when the variable menuChoice is not equal to 3 it will remain in the
        switch statement (3 is the option in the menu to quit)*/
    }
}
