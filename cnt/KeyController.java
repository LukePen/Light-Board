package cnt;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import view.MazeWindow;

//This class controls all mouse inputs, accessing other methods accordingly to control the program
public class KeyController implements MouseListener {

	
	private MazeWindow _win;
	private LightBoard _lb;
	private int rc;
	private boolean rowChoiceF;
	private boolean rowChoiceT;

	private boolean colChoiceF;
	private boolean colChoiceT;
	private boolean gridChoiceT= false;
	private boolean gridChoiceF;
	private boolean firstClick;
	private boolean firstClick2;

	private double startTime, endTime, holdTime;
	private boolean flag;
	private int grow1 =-1;
	private int gcol1 = -1;
	private int grow2= -1;
	private int gcol2= -1;
	private int xx1;
	private int yy1;
	private int ch1;
	private boolean funkyMode;
	public KeyController(int x, int y, int chance) {
		xx1=x;
		yy1=y;
		ch1=chance;
		_lb = new LightBoard(x,y,chance);
		_win = new MazeWindow(_lb, this);
	}
	


	//These are all the mouse clicked event methods
    @Override
    public void mouseClicked(MouseEvent arg0) { 
  
     }

     @Override
     public void mouseEntered(MouseEvent arg0) { }

     @Override
     public void mouseExited(MouseEvent arg0) { }

     @Override
     //If the mouse is pressed, it takes the time in nanoseconds to figure out how long the button has been held
     public void mousePressed(MouseEvent arg0) {
    	 startTime = System.nanoTime();
    	 flag=true;
     }

     /*
      * Once released it takes the position inside the window in order to figure out which light to switch.
      * It also checks the amount of time passed to check if the setting screen should appear.
      * This method also checks if there is a option choice chosen, dictating whether or not to call 
      * a special on/off method.
      * 
      */
     @Override
     public void mouseReleased(MouseEvent arg0) {
    	 
    	 if(flag) {
    		 endTime = System.nanoTime();
    		 flag = false;
    	 }
    	 holdTime = (endTime - startTime) / Math.pow(10, 9);
    	 if(rowChoiceT) {
 	    	int y = arg0.getY();
 	    	int row = (50*((int)Math.round(y/50)))/50;
 	    	turnRow(row, true);
 	    	rowChoiceT = false;
  	    	_win.reDraw();

 	    	holdTime = -1;
 	    	
    	 }
    	 if(rowChoiceF) {
  	    	int y = arg0.getY();
  	    	int row = (50*((int)Math.round(y/50)))/50;
  	    	turnRow(row, false);
  	    	rowChoiceF = false;
  	    	_win.reDraw();
 	    	holdTime = -1;

     	 }
      	 if(colChoiceT) {
   	    	int x = arg0.getX();
   	    	int col = (50*((int)Math.round(x/50)))/50;
   	    	turnCol(col, true);
   	    	colChoiceT = false;
   	    	_win.reDraw();
  	    	holdTime = -1;

      	 }
    	 if(colChoiceF) {
    	    	int x = arg0.getX();
    	    	int col = (50*((int)Math.round(x/50)))/50;
    	    	turnCol(col, false);
    	    	colChoiceF = false;
    	    	_win.reDraw();
   	    	holdTime = -1;

       	 }
    	 
      	 if(gridChoiceT) {
      
 	    	int x = arg0.getX();
 	    	int y = arg0.getY();
 	     	if(gcol2 == -1 && grow2 == -1 && !firstClick) {
 	    		grow2	= (50*((int)Math.round(y/50)))/50;
 	    		gcol2 = (50*((int)Math.round(x/50)))/50;
 	    	}
 	     	
 	     	if(grow1 != -1 && grow2 !=1) {
 	    		
 	    		turnGrid(grow1,gcol1,grow2,gcol2,true);
 	    	
 	 	  	gcol1 = -1;
 	 	  	gcol2 = -1;
 	 	    	grow1 = -1;
	    		grow2 = -1;
	    	
 	 	    	firstClick = false;
 	 	    	gridChoiceT = false;


 	    	}
 	     	if(grow1 == -1 && gcol1 ==-1) {
 	    		grow1 = (50*((int)Math.round(y/50)))/50;
 	    		gcol1 = (50*((int)Math.round(x/50)))/50;
 	    		System.out.println(grow1);
 		    	firstClick = false;

 	    	}
 	    	
 	   
 	    		
 	    	 _win.unHideFrame();
 	    	 _win.reDraw();
 	    	_win.reDraw();
	    	holdTime = -1;
    	 }
      	 
       	if(gridChoiceF) {
	        
 	    	int x = arg0.getX();
 	    	int y = arg0.getY();
 	     	if(gcol2 == -1 && grow2 == -1 && !firstClick2) {
 	    		grow2	= (50*((int)Math.round(y/50)))/50;
 	    		gcol2 = (50*((int)Math.round(x/50)))/50;
 	    	}
 	     	
 	     	if(grow1 != -1 && grow2 !=1) {
 	    		
 	    		turnGrid(grow1,gcol1,grow2,gcol2,false);
 	    	
 	 	  	gcol1 = -1;
 	 	  	gcol2 = -1;
 	 	    	grow1 = -1;
	    		grow2 = -1;
	    	
 	 	    	firstClick2 = false;
 	 	    	gridChoiceF = false;


 	    	}
 	     	if(grow1 == -1 && gcol1 ==-1) {
 	    		grow1 = (50*((int)Math.round(y/50)))/50;
 	    		gcol1 = (50*((int)Math.round(x/50)))/50;
 	    		System.out.println(grow1);
 		    	firstClick2 = false;

 	    	}
 	   
     	    		
     	    	 _win.unHideFrame();
     	    	 _win.reDraw();
     	    	_win.reDraw();
    	    	holdTime = -1;
        	 }
        	  	if(holdTime < 1 && holdTime != -1) {
        	    	int x = arg0.getX();
        	    	int y = arg0.getY();
        	       findBox(x,y);
        	    	}
        	    	else if(holdTime!=-1){
        	    		_win.hideFrame();
        	    		Settings(0, 0);
        	    	}
         }
   
     
     /*
      * This method takes in the x and y position of the mouse when clicked relative to the screen size, using it to find which light was clicked.
      */
     private void findBox(int x, int y) {
    	 int col = (50*((int)Math.round(x/50)))/50;
    	 int row = (50*((int)Math.round(y/50)))/50;
    	 if(_lb.getLights()[(row)][(col)]) {
    		 _lb.set(row, col, false);
    	 }
    	 else {
    		 _lb.set(row, col, true);
    	 }
    	 _win.reDraw();
    	 
     }
     
     /*
      * This method displays different settings, using JButtons as input. After a choice is made,
      * either the change is made or the program will wait for choices in row/column/grid selection
      */
     public void Settings(int a, int b) {
    	 	int oc;
    	 	String[] buttons = { "Turn all lights on", "Turn all lights off", "Turn on an entire row", "Turn off an entire row", "Next...", "Cancel"};
    	 	String[] buttons2 = { "Turn on an entire column", "Turn off an entire column", "Turn on a grid", "Turn off a grid", "Randomize", "Funky mode", "Rico mode", "Back"};
		    rc = JOptionPane.showOptionDialog(null, "Choose a function", "Settings", JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[5]);
		    if(rc == 0) {
		    	for(int r =0; r < _lb.getLights().length; r++) {
		    		for(int c = 0; c < _lb.getLights()[0].length; c++) {
		    			
			    		_lb.set(r, c, true);
			     		_win.unHideFrame();
			       	 _win.reDraw();

		    		}
		    	}
		    }
		    if(rc == 1) {
		    	for(int r =0; r < _lb.getLights().length; r++) {
		    		for(int c = 0; c < _lb.getLights()[0].length; c++) {
			    		_lb.set(r, c, false);
			     		_win.unHideFrame();
			       	 _win.reDraw();

		    		}
		    	}
		    }
		    if(rc == 2) {
		    	rowChoiceT = true;
		    	JOptionPane.showMessageDialog(null, "Choose which row you'd like to turn on");
		    	
		    	_win.reDraw();
		    }
		    if(rc == 3) {
		    	rowChoiceF = true;
		    	JOptionPane.showMessageDialog(null, "Choose which row you'd like to turn off");
		    	
		    	_win.reDraw();
		    }
		    if(rc==4) {
			    oc = JOptionPane.showOptionDialog(null, "Choose a function", "Settings", JOptionPane.WARNING_MESSAGE, 0, null, buttons2, buttons2[7]);
			    if(oc == 0) {
			    	colChoiceT = true;
			    	JOptionPane.showMessageDialog(null, "Choose which column you'd like to turn on");
			    	
			    	_win.reDraw();
			    }
			    if(oc == 1) {
			    	colChoiceF = true;
			    	JOptionPane.showMessageDialog(null, "Choose which column you'd like to turn off");
			    	
			    	_win.reDraw();
			    }
			    if(oc==2) {
			    	gridChoiceT = true;
			    	JOptionPane.showMessageDialog(null, "Press the start and ending lightbulbs for your grid");
			    	firstClick = true;
				 	grow1 = -1;
		 			grow2 = -1;
		 			gcol1 = -1;
		 			gcol2 = -1;
			    	_win.reDraw();
			    }
			    if(oc==3) {
			    	gridChoiceF = true;
			    	JOptionPane.showMessageDialog(null, "Press the start and ending lightbulbs for your grid");
			    	firstClick2 = true;
				 	grow1 = -1;
		 			grow2 = -1;
		 			gcol1 = -1;
		 			gcol2 = -1;
			    	_win.reDraw();
			    }
			    if(oc==4) {
			    	randomize();
			    }
			    if(oc==5) {
			    	_win.FUNK();
			    	_win.reDraw();

			    }
			    if(oc==6) {
			    	_win.RICO();
			    	_win.reDraw();
			    }
			    if(oc==7) {
			    	Settings(0,0);
			    }
		    }
		    if(rc==5) {
		    	_win.reDraw();
		    }
     }



	//This method turns an entire row on/off depending on the row choice and boolean parameters
     public void turnRow(int row, boolean b) {
    	 for(int c = 0; c < _lb.getLights()[0].length; c++) {
 			
	    		_lb.set(row, c, b);

 		}
 		_win.unHideFrame();
      	 _win.reDraw();
     }
     
     
     //This method turns on/off an entire grid of lights between two points.
     public void turnGrid(int row1, int col1, int row2, int col2, boolean b) {
    	 System.out.println(""+ row1+"" +col1 +""+ row2 +"" +col2 +""+ b);
    	 for(int r = row1; r <= row2; r++ ) {
    		 for(int c = col1; c <= col2; c++ ) {
        		 _lb.set(r, c, b);
        	 }
    	 }
    	 	grow1 = -1;
 			grow2 = -1;
 			gcol1 = -1;
 			gcol2 = -1;

     }
     
     //This method randomizes which lights are on/off, effectively resetting the board
     public void randomize() {
    	 _lb.randomize();
    	 _win.reDraw();
     }
     
 	//This method turns an entire column on/off depending on the column choice and boolean parameters

     public void turnCol(int col, boolean b) {
    	 for(int r = 0; r < _lb.getLights().length; r++) {
 			
	    		_lb.set(r, col, b);

 		}
 		_win.unHideFrame();
      	 _win.reDraw();
     }


	}


