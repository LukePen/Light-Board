package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import cnt.LightBoard;

//This class was created to control the different outer aspects of the JPanel which displays the light board
public class LightPanel {

	private JPanel _pan;
	private JLabel[][] _labs;
	private LightBoard _maze;
	private static final int PIXELS = 51;
	private boolean funkyMode = false;
	private boolean ricoMode = false;
	
//This is the constructor for this class, taking in the light board as a parameter to display
	public LightPanel(LightBoard m) {
		_maze = m;
	
		setupLabs();
		setupJPanel();
	}
//This method gets and draws the jpanel
	public JPanel getPanel() {
		drawPanel();
		return _pan;
	}
//This method turns on funky mode, switching the images for the lights to monkeys.
	public void FUNK() {
		funkyMode = !funkyMode;
		ricoMode = false;
	}
	//This method turns on rico mode, switching the images for the lights to the teacher which taught me how to code.
	public void RICO() {
		ricoMode = !ricoMode;
		funkyMode = false;
	}

	//This method instantiates and sets up the Jpanel based on teh amount of rows and columns dictated earlier.
	private void setupJPanel() {
		int numRows = _labs.length;
		int numCols = _labs[0].length;
		_pan = new JPanel(new GridLayout(numRows, numCols));
		int rowSize = _maze.getLights().length * PIXELS;
		int colSize = _maze.getLights()[0].length * PIXELS;
		_pan.setSize(rowSize, colSize);
	}

	//This method draws the panel, clearing it and redrawing it with updated values
	private void drawPanel() {
		_pan.removeAll();
		drawLights();
		for (JLabel[] arr : _labs) {
			for (JLabel lab : arr) {
				_pan.add(lab);
				_pan.repaint();
			}
		}
	}
	
	//This method sets up and instantiates the JPanel array used to contain the images displayed in the program.
	private void setupLabs() {
		int row = _maze.getLights().length;
		int col = _maze.getLights()[0].length;
		_labs = new JLabel[row][col];
	}

	
	//This method draws the grid of lights by filling out an array with JLabel Images to display.
	private void drawLights() {

		
		boolean[][] map = _maze.getLights();
		int row = _labs.length;
		int col = _labs[0].length;
		if(!funkyMode&&ricoMode) {
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (map[r][c]) {
						_labs[r][c] = new JLabel(Graphics.Drico.getImage());
					} else {
						_labs[r][c] = new JLabel(Graphics.ric.getImage());
					}
				}
			}
		}
			else if(funkyMode && !ricoMode) {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (map[r][c]) {
					_labs[r][c] = new JLabel(Graphics.ONM.getImage());
				} else {
					_labs[r][c] = new JLabel(Graphics.OFFM.getImage());
				}
			}
		}
		}
		else {
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (map[r][c]) {
						_labs[r][c] = new JLabel(Graphics.ON.getImage());
					} else {
						_labs[r][c] = new JLabel(Graphics.OFF.getImage());
					}
				}
			} 
		}
	}
}
	


