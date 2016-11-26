import java.util.Scanner;
import java.io.File;
import java.io.Reader;
import java.io.IOException;
public class AdventOfCode2 {
  public static void main(String[] args){
    /* File file = new File("AdventOfCode2.txt");
    Reader reader;
    String encoding = ""; */
    try {
      File inputFile = new File("AdventOfCode2.txt");
      Scanner fileReader = new Scanner(inputFile);
      String[] allPresents = new String[1000];
      String[] presentAsString = new String[3];
      // making an array for 1000 Presents objects
      Presents[] presents = new Presents[1000];
      
      for(int i = 0; i < allPresents.length; i++) {
        allPresents[i] = fileReader.nextLine();
        for(int j = 0; j < presentAsString.length; j++) {
          presentAsString = allPresents[i].split("x"); 
        }
        int length = Integer.parseInt(presentAsString[0]);
        int width = Integer.parseInt(presentAsString[1]);
        int height = Integer.parseInt(presentAsString[2]);
        presents[i] = new Presents(length, width, height);
        //System.out.println((i+1) + ". " + allPresents[i]);
      }
      /* int totalAreaOfPaper = 0;
      System.out.println(allPresents[999]);
      System.out.println(presentAsString[0] + " " + presentAsString[1] + " " + presentAsString[2]);
      System.out.println(presents[999].surfaceArea() + " " + presents[999].slackPaper());
      for(int k = 0; k < presents.length; k++) {
        totalAreaOfPaper += presents[k].surfaceArea() + presents[k].slackPaper();
      }
      System.out.println(totalAreaOfPaper);*/
      int totalArea = Presents.totalAreaOfPaper(presents);
      System.out.println(totalArea);
      
      int totalRibbon = Presents.ribbonRequired(presents);
      System.out.println(totalRibbon);
    }
    catch(IOException e){
      System.out.println("The file was not able to be read!");
    }
  }
}