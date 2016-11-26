import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class AdventOfCode5 {
  /* nice string - 
   *   at least 3 vowels
   *   at least one letter that appears twice in a row
   *   does not contain the strings ab, cd, pq, or xy */
  public static void main(String[] args) {
    try{
      File inputFile = new File("AdventOfCode5.txt");
      Scanner reader = new Scanner(inputFile);
      String[] stringsToCheck = new String[1000];
      for(int i = 0; i < stringsToCheck.length; i++) {
        stringsToCheck[i] = reader.nextLine();
        //System.out.println((i+1) + ". " + stringsToCheck[i]);
      }
      
      // using the 3 methods below to see how many strings are nice strings
      int numNiceStrings = 0;
      for(int j = 0; j < stringsToCheck.length; j++) {
        if(threeVowelsOrNot(stringsToCheck[j]) && letterTwiceInRow(stringsToCheck[j]) && onlyAllowedStrings(stringsToCheck[j])){
          numNiceStrings++;
        }
      }
      System.out.println(numNiceStrings);
    }
    catch(IOException e) {
      System.out.println("The file could not be read!");
    }
  }
  
  // Part 1 - checking if the string has at least 3 vowels or not
  public static int vowelPresentOrNot(String input, char c) {
    int count = 0;
    for(int i = 0; i < input.length(); i++) {
      if(input.charAt(i) == c){
        count++;
      }
    }
    return count;
  }
  
  public static boolean threeVowelsOrNot(String input) {
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    int numVowels = 0;
    for(int i = 0; i < vowels.length; i++) {
      numVowels += vowelPresentOrNot(input, vowels[i]);
      if(numVowels >= 3) {
        return true;
      }
    }
    return false;
  }
  
  // Part 2 - checking if at least one letter appears twice in a row
  public static boolean letterTwiceInRow(String input) {
    for(int i = 0; i < input.length() - 1; i++) {
      if(input.charAt(i) == input.charAt(i+1)){
        return true;
      }
    }
    return false;
  }
  
  // Part 3 - checking if the string does not contain ab, cd, pq or xy
  public static boolean onlyAllowedStrings(String input) {
    char[][] forbiddenStrings = {{'a','b'}, {'c','d'}, {'p','q'}, {'x','y'}};
    for(int i = 0; i < input.length() - 1; i++) {
      for(int j = 0; j < forbiddenStrings.length; j++) {
        for(int k = 0; k < forbiddenStrings[0].length - 1; k++) {
          if(input.charAt(i) == forbiddenStrings[j][k] && input.charAt(i+1) == forbiddenStrings[j][k+1]){
            return false;
          }
        } 
      }
    }
    return true;
  }
}