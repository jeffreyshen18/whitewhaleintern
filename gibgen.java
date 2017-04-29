import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Character;

public class gibgen {
  private int frontOffSet;
  private int backOffSet;

  public static void main(String[] args) {
    gibgen obj1 = new gibgen();
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter text-string input: ");
    String words = keyboard.nextLine();
    System.out.println("Scrambled text-string output: ");
    obj1.gibberish(words);
    System.out.println();

  }

  public void gibberish(String words) {
    String[] parts = words.split(" ");
    for (int index = 0; index < parts.length; index++) {
      String word = parts[index];
      char[] charArray = word.toCharArray();
      // This if-statement checks if the element has 4 characters without punctuations at the beginning or end of the element
      if (charArray.length == 4 && Character.isLetter(charArray[0]) && Character.isLetter(charArray[charArray.length-1])) {
        char temp  = charArray[1];
        charArray[1] = charArray[2];
        charArray[2] = temp;
        String mixedString = new String(charArray);
        System.out.print(mixedString + " ");
      // This else-if statement checks if the element is a number
      }
      else if (Character.isDigit(charArray[0])) {
        String mixedString = new String(charArray);
        System.out.print(mixedString + " ");
      }
      // This else-if statement checks if the element is greater than 4 characters and then calibrates the appropriate offset values and then calls the shuffle method to implement the Fisher-Yates shuffle algorithm
      else if (charArray.length > 4) {
        getOffset(charArray);
        shuffle(charArray, frontOffSet, backOffSet);
      }
      // The else statement returns the element unscrambled if it does not satisfy any of the previous if-else statements
      else {
        String mixedString = new String(charArray);
        System.out.print(mixedString + " ");
      }
    }
  }

  public void getOffset(char[] charArray) {
    if (!Character.isLetter(charArray[charArray.length-2])) {
      backOffSet = 4;
    } else if (!Character.isLetter(charArray[charArray.length-1])) {
      backOffSet = 3;
    }
    else {
      backOffSet = 2;
    }
    if (!Character.isLetter(charArray[1])) {
      frontOffSet = 3;
    }
    else if (!Character.isLetter(charArray[0])) {
      frontOffSet = 2;
    }
    else {
      frontOffSet = 1;
    }
  }

  public void shuffle(char[] charArray, int frontOffSet, int backOffSet) {
    Random r = new Random();
    String beforeString = new String(charArray);
    String mixedString = null;
    boolean identical = true;
    while (identical) {
    for (int i = charArray.length - backOffSet; i > frontOffSet; i --) {
      int j = r.nextInt(i) + frontOffSet;
      if (Character.isLowerCase(charArray[i]) && Character.isLowerCase(charArray[j])) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
      }
    }
    mixedString = new String(charArray);
    if (!mixedString.equals(beforeString) || Character.isUpperCase(charArray[charArray.length - backOffSet])) {
      identical = false;
    }
  }
    System.out.print(mixedString + " ");
  }
}
