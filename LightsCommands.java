public class LightsCommands {
  private String command;
  private int[] startCoord;
  private int[] endCoord;
  
  public LightsCommands(String valsAndCommand) {
    /* if(start.length != 2 || end.length != 2) {
      throw new IllegalArgumentException("There are only 2 coordinates each for start and end!");
    } */
    startCoord = new int[2];
    endCoord = new int[2];
    String[] light = valsAndCommand.split(" ");
    this.command = light[0] + " " + light[1];
    String[] start = light[2].split(",");
    String[] end = light[4].split(",");
    this.startCoord[0] = Integer.parseInt(start[0]);
    this.startCoord[1] = Integer.parseInt(start[1]);
    this.endCoord[0] = Integer.parseInt(end[0]);
    this.endCoord[1] = Integer.parseInt(end[1]);
  }
  
  public void changingLights(int[][] lightsOnOff) {
    /* if the command is "turn on", the range of
     * lights are made to have value of 1 */
    if(this.command.equals("turn on")) {
      for(int i = this.startCoord[0]; i <= this.endCoord[0]; i++) {
        for(int j = this.startCoord[1]; j <= this.endCoord[1]; j++) {
          lightsOnOff[i][j] = 1;
        }
      }
    }
    /* if the command is "turn off", the range of
     * lights are made to have value of 0 */
    if(this.command.equals("turn off")) {
      for(int i = this.startCoord[0]; i <= this.endCoord[0]; i++) {
        for(int j = this.startCoord[1]; j <= this.endCoord[1]; j++) {
          lightsOnOff[i][j] = 0;
        }
      }
    }
    /* if the command is "toggle all", the range of
     * lights are made to have value of 1 if they
     * were 0 before and 0 if they were 1 before */
    if(this.command.equals("toggle all")) {
      for(int i = this.startCoord[0]; i <= this.endCoord[0]; i++) {
        for(int j = this.startCoord[1]; j <= this.endCoord[1]; j++) {
          lightsOnOff[i][j] = 1 - lightsOnOff[i][j];
        }
      }
    }
  }
  
  // method for Part 2
  public int changingBrightness(int[][] lightsBrightness){
    int brightness = 0;
    /* if the command is "turn on", the brightness for the
     * range of coordinates should be increased by 1 */
    if(this.command.equals("turn on")) {
      for(int i = this.startCoord[0]; i <= this.endCoord[0]; i++) {
        for(int j = this.startCoord[1]; j <= this.endCoord[1]; j++) {
          lightsBrightness[i][j] += 1;
          brightness++;
        }
      }
    }
    /* if the command is "turn off", the brightness for the
     * range of coordinates should be decreased by 1 (to a
     * minimum of 0) */
    if(this.command.equals("turn off")) {
      for(int i = this.startCoord[0]; i <= this.endCoord[0]; i++) {
        for(int j = this.startCoord[1]; j <= this.endCoord[1]; j++) {
          if(lightsBrightness[i][j] != 0){
            lightsBrightness[i][j] -= 1;
            brightness--;
          }
        }
      }
    }
    /* if the command is "turn on", the brightness for the
     * range of coordinates should be increased by 2 */
    if(this.command.equals("toggle all")) {
      for(int i = this.startCoord[0]; i <= this.endCoord[0]; i++) {
        for(int j = this.startCoord[1]; j <= this.endCoord[1]; j++) {
          lightsBrightness[i][j] += 2;
          brightness += 2;
        }
      }
    }
    return brightness;
  }
}