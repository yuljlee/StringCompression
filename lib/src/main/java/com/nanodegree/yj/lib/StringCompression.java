package com.nanodegree.yj.lib;

import java.util.Scanner;

public class StringCompression {

    public static void main(String[] args) {
        System.out.print("Input string: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        System.out.format("Output string: %s", compress(inputString));
        scanner.close();
    }

    public static String compress(String input) {
        // First prepare the string variables and a integer for current char, previous char
        // and count of each compressed character
        String currentChar = "";
        String compressedString = "";
        int countChar = 1;
        // Add first character of the input string into previous string variable
        String previousChar = input.substring(0, 1);

        // Iterate through all of the characters from index position 1
        // because we have already included the character at position 0
        for (int i = 1; i < input.length(); i++) {
            // Compare current character to the character in previous string variable
            currentChar = input.substring(i, i+1);
            // If current character is equal to the character before it,
            // increase value of countChar variable
            if (currentChar.equals(previousChar)) {
                countChar++;
            } else {
                // Otherwise add the previous letter to compressedString variable followed by count of characters
                compressedString = compressedString.concat(previousChar);
                compressedString = compressedString.concat(Integer.toString(countChar));
                // Then set the character counter variable to 1
                // and the previous item to current character
                countChar = 1;
                previousChar = currentChar;
            }
        }

        // Add final character and count to the string to be returned
        compressedString = compressedString.concat(previousChar);
        compressedString = compressedString.concat(Integer.toString(countChar));

        // Check if compressedString is smaller than the input string
        // if compressedString is smaller than the input string then
        // return it otherwise return the input string itself
        if (compressedString.length() < input.length()) {
            return compressedString;
        } else {
            return input;
        }
    }
}