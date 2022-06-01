package main;



import javax.swing.JOptionPane;


import cnt.KeyController;

/*This is the main class, controlling the start of the program.
 * The point of this programming assignment was to simulate a grid light board,
 * With each light being able to be on or off (I added some more flair via in jokes).
 * 
 */

public class Main{
	
	KeyController k;
	
	
	//This is the main method, asking for the width, height, and chance for each light to be on.
	public static void main(String[] args0) {
		
		try{
			System.out.println(1%4);
		int x = Integer.valueOf(JOptionPane.showInputDialog(null, "What width lightboard would you like?"));
		System.out.println(x);
		int y = Integer.valueOf(JOptionPane.showInputDialog(null, "What height lightboard would you like?"));
		int c = Integer.valueOf(JOptionPane.showInputDialog(null, "What chance for each light to be on?"));
		JOptionPane.showMessageDialog(null, "Welcome to the LightBoard!" + "\n" + "Controls: Click near the bottom of each lightbulb to turn it on or off" + "\n" + "Hold and release the mouse for a few seconds to open the settings/features tab" );
		KeyController k = new KeyController(x,y,c);

		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Only input integers!");
			main(null);
		}
	}
}
