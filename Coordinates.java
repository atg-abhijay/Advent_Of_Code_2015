public class Coordinates{
  private int xcoordinate;
  private int ycoordinate;
  
  public Coordinates(int x, int y){
    this.xcoordinate = x;
    this.ycoordinate = y;
  }
  
  public int getX() {
    return this.xcoordinate;
  }
  
  public int getY() {
    return this.ycoordinate;
  }
  /* public static int duplicateCoordinates(Coordinates[] c) {
    int duplicate = 0;
    int i = 0;
    int j = 1;
    while(i < c.length - 1) {
      while(j < c.length) {
        if(c[i].xcoordinate == c[j].xcoordinate && c[i].ycoordinate == c[j].ycoordinate) {
          duplicate++;
          i++;
          j = i+2;
        }
        else{
        j++;
       }
     }
    } 
    return duplicate;
  } */
  
  public double numTimesCoord(Coordinates[] c) {
    double numTimes = 0;
    for(int i = 0; i < c.length; i++) {
      if(this.xcoordinate == c[i].xcoordinate && this.ycoordinate == c[i].ycoordinate){
        numTimes++;
      }
    }
    return 1/numTimes;
  }
    
    
  /* public static int duplicateCoordinates(Coordinates[] c) {
    int duplicate = 0;
    for(int i = 0; i < c.length - 1; i+=0) {
      for(int j = 1; j < c.length; j+=0) {
        if(c[i].xcoordinate == c[j].xcoordinate && c[i].ycoordinate == c[j].ycoordinate) {
          duplicate++;
          i = i + 1;
          j = i + 1;
        }
      }
    }
    return duplicate;
  } */
} 