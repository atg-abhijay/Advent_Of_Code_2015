import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class AdventOfCode6 {
  public static void main(String[] args) {
    // will store the values 0 or 1 for off or on
    int[][] lightsOnOff = new int[1000][1000];
    // will store the commands from the file for changing the lights 
    String[] lightAsString = new String[300];
    /* making an array of LightsCommands objects which will
     * make it easier to access the commands (toggle, turn off,
     * turn on) and also access the range of coordinates over
     * which these changes are to be made */
    LightsCommands[] lights = new LightsCommands[300];
    // assigning the 1000x1000 grid of lights the value 0 for every light
    for(int i = 0; i < lightsOnOff.length; i++) {
      for(int j = 0; j < lightsOnOff[i].length; j++) {
        lightsOnOff[i][j] = 0;
      }
    }
    /* creating another array lightsBrightness which 
     * will store the same values as lightsOnOff. It 
     * will be used for Part 2 (Brightness calculation) */
    int[][] lightsBrightness = new int[1000][1000];
    for(int k = 0; k < lightsBrightness.length; k++) {
      for(int p = 0; p < lightsBrightness[k].length; p++) {
        lightsBrightness[k][p] = lightsOnOff[k][p];
      }
    }
    try {
      File inputFile = new File("AdventOfCode6.txt");
      Scanner reader = new Scanner(inputFile);
      for(int i = 0; i < lightAsString.length; i++) {
        lightAsString[i] = reader.nextLine();
        //System.out.println((i+1) + ". " + lightCommands[i]);
        
        // creation of LightsCommands objects
        lights[i] = new LightsCommands(lightAsString[i]);
      }
      // loop wherein the lights are changed 
      for(int j = 0; j < lights.length; j++) {
        lights[j].changingLights(lightsOnOff);
      }
      
      // counting the number of lights that are on finally
      int numLightsOn = 0; 
      for(int k = 0; k < lightsOnOff.length; k++) {
        for(int p = 0; p < lightsOnOff[k].length; p++) {
          if(lightsOnOff[k][p] == 1) {
            numLightsOn++;
          }
        }
      }
      System.out.println(numLightsOn);
      
      
      // Part 2
      // adding up brightnesses of all the lights
      int totalBrightness = 0;
      for(int q = 0; q < lights.length; q++) {
        totalBrightness += lights[q].changingBrightness(lightsBrightness);
      }
      System.out.println(totalBrightness);
    }
    catch(IOException e) {
      System.out.println("The file could not be read!");
    }
  }
}