package com.company;

import java.util.Arrays; //imports array library
import java.util.Random; //imports random library

public class Password {
    public static String passValidator(String valPassword) {
        //Password validator method with return type of string. This returns the category the password matches.

        boolean lowerC = false; //Declares: a boolean variable to store whether there are lower case letters in the password.
        boolean upperC = false; //Declares: a boolean variable to store whether there are upper case letters in the password.
        boolean mixOfCases = false; //Declares: a boolean variable to store whether there are a mix of upper/lower case letters in the password.

        int digitsCount = valPassword.replaceAll("\\D", "").length();
        /* Regular expression which checks the string "valPassword" and replaces anything inside of it that is not a
        digit with nothing. This way i can tell how many digits are in valPassword. I am then storing this number as an
        int in the variable "digitsCount". ( \\D in regex means any non digit) */

        int lowerCaseLetters = valPassword.replaceAll("[^a-z]*", "").length();
        /* Regular expression which checks the string "valPassword" and replaces anything inside of it that is not a
        lower case letter with an empty string (""). The asterisk means that it finds zero or more occurrences matching
        the expression. This way i can tell how many lower case letters are in valPassword even if there are duplicate
        letters. I am then storing this number as an int in the variable "lowerCaseLetters". */

        int upperCaseLetters = valPassword.replaceAll("[^A-Z]*", "").length();
        /* Regular expression which checks the string "valPassword" and replaces anything inside of it that is not a
        upper case letter with an empty string (""). The asterisk means that it finds zero or more occurrences matching
        the expression. This way i can tell how many upper case letters are in valPassword even if there are duplicate
        letters. I am then storing this number as an int in the variable "upperCaseLetters".
        (The carrot represents NOT in regex). */

        int symbols = valPassword.replaceAll("\\w", "").length();
        /* Regular expression which checks the string "valPassword" and replaces anything inside of it that is a
        word character (a-z || A-Z || 0-9) with an empty string (""). This way i can tell how many symbols are in
        valPassword. I am then storing this number as an int in the variable "symbols". */

        if (lowerCaseLetters > 0) {
            lowerC = true;
            //If there are lower case letters in the password then make the lowerC variable true.
        }
        if (upperCaseLetters > 0) {
            upperC = true;
            //If there are upper case letters in the password then make the upperC variable true.
        }
        if (upperC && lowerC) {
            //If there are a mix of cases signified by the two booleans then mix of cases is true.
            // (Used this just to simplify the conditional expression in the if statements for the validator category's)
            mixOfCases = true;
        }

        if (valPassword.length() <= 8 && symbols == 0 && digitsCount == 0 && !mixOfCases) {
            /* Poor
            Checks the conditions for a poor password and returns the string "POOR" if all conditions are true. */
            return "POOR";
        } else if (valPassword.length() >= 16 && symbols > 4 && digitsCount > 4 && mixOfCases) {
            /* Excellent
            Checks the conditions for a excellent password and returns the string "EXCELLENT" if all conditions are true. */
            return "EXCELLENT";
        } else if (valPassword.length() > 12 && symbols > 3 && digitsCount > 2 && mixOfCases) {
            /* Good
            Checks the conditions for a good password and returns the string "GOOD" if all conditions are true. */
            return "GOOD";
        } else if (valPassword.length() > 8 && symbols > 1 && digitsCount > 2 && !mixOfCases) {
            /* Ok
            Checks the conditions for a ok password and returns the string "OK" if all conditions are true. */
            return "OK";
        } else {
            return ("NO CATEGORY." + "\n" + "This means that your password does not fit into any of the category's specified by the validator.");
            /* No Category
            Message returned when no category is assigned to a password after validation. */
        }
    }

    public static String passGenerator(int length, int symbols, int digits) {
        //Password generator method with a return type of string.
        String password; //Declares: 'password' variable of type string to store the final randomly generated and jumbled up password.
        int charactersLeft; /*Declares: 'characterLeft' variable of type int to store the left over characters of
        the password which are not symbols or digits.*/
        charactersLeft = length - (symbols + digits);   /*Stores the result of the password length being taken away
        from the sum of symbols and digits. */
        int jumbler; /* Declares: a integer variable called jumbler to be assigned a random value from 0-2 to randomize
        the order that the arrays are appended to the string "password". */

        Random random = new Random(); //Creates random object
        int[] digitsArr = new int[digits]; /* Creates a fixed array of type Int, using the number of digits picked by
        the user to determine the arrays size.*/
        char[] symbolsArr = new char[symbols]; /* Creates a fixed array of type char, using the number of symbols picked by
        the user to determine the arrays size.*/
        char[] lettersArr = new char[charactersLeft]; /* Creates a fixed array of type char, using the number of
        characters left in the password to determine the arrays size.*/

        String allLetters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        //Stores all the possible letters for when generating a random letter which is randomized to be lower or upper case.
        String allSymbols = "@!#$%&'()*+,-./|:<=>;?[]{}^_`~¬€„›©®÷";
        //Stores all the possible characters for when generating a random character for the password.

        for (int i = 0; i < digitsArr.length; i++) {
            //Iterates through the array from 0
            digitsArr[i] = random.nextInt(10);
            /*Stores the random integer generated with the lower bound of 0 (inclusive), and upper bound of 10 (exclusive)
            in the array index of "i" which changes with each iteration of the for loop. */
        }

        for (int j = 0; j < symbolsArr.length; j++) {
            //Iterates through the array from 0
            symbolsArr[j] = allSymbols.charAt(random.nextInt(allSymbols.length()));
            //Stores the random integer generated in the array index of "i" which changes with each iteration of the for loop.
        }

        for (int k = 0; k < lettersArr.length; k++) {
            //Iterates through the array from 0
            lettersArr[k] = allLetters.charAt(random.nextInt(allLetters.length()));
            //Stores the random integer generated in the array index of "i" which changes with each iteration of the for loop.
        }

        jumbler = random.nextInt(3);
        /* Generates a random integer to be stored in the variable m with a lower bound of 0 (inclusive), and a upper
        bound of 3 (exclusive). */
        if (jumbler == 0) {
            /*These statements add the array to the variable password using the toString() method and uses the
            replaceAll() method with regular expression to remove unwanted characters that are returned when printing
            the three arrays through using the toString() method. */
            password = Arrays.toString(digitsArr).replaceAll("^\\[|\\]$| |,", "") + Arrays.toString(symbolsArr).replaceAll("^\\[|\\]$| |,", "") + Arrays.toString(lettersArr).replaceAll("^\\[|\\]$| |,", "");
        } else if (jumbler == 1) {
            password = Arrays.toString(symbolsArr).replaceAll("^\\[|\\]$| |,", "") + Arrays.toString(lettersArr).replaceAll("^\\[|\\]$| |,", "") + Arrays.toString(digitsArr).replaceAll("^\\[|\\]$| |,", "");
        } else {
            password = Arrays.toString(lettersArr).replaceAll("^\\[|\\]$| |,", "") + Arrays.toString(digitsArr).replaceAll("^\\[|\\]$| |,", "") + Arrays.toString(symbolsArr).replaceAll("^\\[|\\]$| |,", "");
        }
        /*Randomizes the order in which the 3 parts of the password (stored in separate arrays) are appended to the
        variable "password". This makes the password more secure as the order of the symbols, letters and numbers in the
        password cannot be predicted as they are random for every time a new password is generated. */

        return password; //Returns the variable password which stores the jumbled up randomly generated password.
    }
}