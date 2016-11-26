public class Presents{
  private int length;
  private int width;
  private int height;
  
  public Presents(int l, int w, int h) {
    /* using a constructor to set the
     * properties length, width and height
     * of the Presents object */
    this.length = l;
    this.width = w;
    this.height = h;
  }
  
  public int getLength() {
    return this.length;
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  /* this method returns the surface area of
   * the object that this method was called on */
  public int surfaceArea() {
    //Surface Area = 2*l*w + 2*l*h + 2*w*h
    int surfaceArea = 2*length*width + 2*width*height + 2*height*length;
    return surfaceArea;
  }
  
  public int slackPaper() {
    /* we calculate all the possible areas
     * for the different sides of the present
     * and compare them to find the side with
     * the least area. that area becomes the
     * area of the slack paper required */
    int slack1 = this.length*this.width;
    int slack2 = this.width*this.height;
    int slack3 = this.height*this.length;
    int[] slacks = {slack1, slack2, slack3};
    /* we assume that the first slack value is 
     * the least value and compare it to the other
     * values. if at any time, this assumed least
     * slack value is greater than the other value,
     * we update the variable to store this new and
     * lower value. in this way, by the end of the
     * loop, we get the least slack value */
    int leastSlack = slack1;
    for(int i = 1; i < slacks.length; i++) {
      if(leastSlack > slacks[i]) {
        leastSlack = slacks[i];
      }
    }
    return leastSlack;
  }
  
  public static int totalAreaOfPaper(Presents[] presents) {
    int totalAreaOfPaper = 0;
    /* we calculate the surface area and area of slack
     * paper for each of the presents and keep on
     * adding these values to a single variable which is
     * keeping track of the total amount of paper required */
    for(int i = 0; i < presents.length; i++) {
      totalAreaOfPaper += presents[i].surfaceArea() + presents[i].slackPaper();
    }
    return totalAreaOfPaper;
  }
  
  // ******** Methods for Part 2 (Ribbons)***********
  
  
  public int ribbonWrap() {
    /* we again find the different semiperimeters
     * and compare them to get the least semiperimeter.
     * we then return 2 times that smallest semiperimeter
     * to get the value for amount of ribbon for wrapping required */
    int sp1 = this.length + this.width;
    int sp2 = this.width + this.height;
    int sp3 = this.height + this.length;
    int[] semiperimeters = {sp1, sp2, sp3};
    int smallestperi = sp1;
    for(int i = 1; i < semiperimeters.length; i++) {
      if(smallestperi > semiperimeters[i]){
        smallestperi = semiperimeters[i];
      }
    }
    return 2*smallestperi;
  }
  
  public int ribbonBow() {
    /* amount of ribbon required to make
     * a bow for a present is equal to the
     * volume of that present */
    int ribbonBow = this.length * this.width * this.height;
    return ribbonBow;
  }
  
  public static int ribbonRequired(Presents[] presents) {
    int totalRibbon = 0;
    /* we calculate the amount of ribbon required to
     * wrap and make a bow for each of the presents
     * and sum that value to get total amount of ribbon required */
    for(int i = 0; i < presents.length; i++) {
      totalRibbon += presents[i].ribbonWrap() + presents[i].ribbonBow();
    }
    return totalRibbon;
  }
}