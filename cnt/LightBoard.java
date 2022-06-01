package cnt;
//This class handles the light board itself via boolean values

public class LightBoard {
	
	private boolean[][] lights;
	private double chance;
	private int xxsize;
	private int yysize;
	
	/*This is the constructor for the class, taking in the x and y size as paramaters, along with 
	 * the chance for each light to be on. From this, an array of randomly (based on the chance for each light to be on) switched
	 * booleans is created to represent the light board.
	 * 
	 */
	public LightBoard(int xSize, int ySize, int chanceOn) 
			{
				xxsize = xSize;
				yysize = ySize;
			  lights = new boolean[xSize][ySize];
			  chance = chanceOn * 0.01;
			  for(int r = 0; r < lights.length; r++)
			    for(int c = 0; c < lights[0].length; c++)
			      if(Math.random() <= chance)
			        lights[r][c] = true;
			}
	
	/*This method randomizes whether or not the lights/booleans are flipped (on/off, true/false)
	 * throughout the light board/array
	 */
	public void randomize() {
		boolean[][] lights2 = new boolean[xxsize][yysize];
		  for(int r = 0; r < lights.length; r++) {
			    for(int c = 0; c < lights[0].length; c++) {
			      if(Math.random() <= chance) {
			        lights2[r][c] = true;
			      }
			    }
		  }
		lights = lights2;
	}
	public boolean[][] getLights(){
		return lights;
	}
	//This method sets the light at a certain x and y coordinate to the boolean passed through the parameter
	public void set(int x, int y,boolean b){
		lights[x][y] = b;
	}
}
