package view;

import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cnt.LightBoard;

//This class handles the JFrame which displays the light board, along with the window it sits in.
public class MazeWindow {
	
	private JFrame _frame;
	private LightPanel _pan;
	private LightBoard _maze;
	

	private MouseListener _kcnt;
	private static final int X_POS = 700;
	private static final int Y_POS = 300;

	public JFrame getFrame() { return _frame; }
	
	//This is the constructor for this class, taking in the light board and mouse listener as parameters
	public MazeWindow(LightBoard m,  MouseListener k) {
		_maze = m;

		_pan = new LightPanel(_maze);
		_kcnt = k;
		setupFrame();
	}
	
	//This is an accessor method to flip the FUNK boolean inside lightPanel.
	public void FUNK() {
		_pan.FUNK();
	}
	
	//This is an accessor method to flip the RICO boolean inside lightPanel.
	public void RICO() {
		_pan.RICO();
	}
	
	//This method hides the frame by setting its visibility to false.
	public void hideFrame() {
		_frame.setVisible(false);
	}
	
	//This method shows (unhides) the frame by setting its visibility to true.
	public void unHideFrame() {
		_frame.setVisible(true);
	}
	
	//This method starts the display, declaring and instantiating it, setting itself up to preferred options using JFrame methods
	private void setupFrame() {
		JPanel pan = _pan.getPanel();
		pan.addMouseListener(_kcnt);
		_frame = new JFrame("LightBoard - By Eden & co.");
		_frame.setLayout(new GridLayout(1,1));
		_frame.setLocation(X_POS, Y_POS);
		_frame.setSize(pan.getWidth(), pan.getHeight());
		_frame.add(pan);
		_frame.setResizable(false);
		_frame.setAlwaysOnTop(true);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setVisible(true);
	}
	
	//This method removes the array of JPanels shown from the JFrame, then displays the new, updated array of JPanels, redrawing the screen.
	public void reDraw() {
		_frame.remove(_pan.getPanel());
		_frame.add(_pan.getPanel());
		_frame.repaint();
		_frame.setVisible(true);
	
	}
}
