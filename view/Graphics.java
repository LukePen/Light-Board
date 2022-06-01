package view;

import javax.swing.ImageIcon;
//This enum was created to make accessing the images for the program easier
public enum Graphics {

	ON("litbulb.PNG"), OFF("unlitbulb.PNG"), ONM("IMG_1381.PNG"), OFFM("IMG_1382.PNG"),Drico("drippyRico.PNG"),ric("ric.PNG");
	
	private ImageIcon _img;
	
	public ImageIcon getImage(){ return _img; }
	//This method gets the image based on the value at the enum accessed.
	private Graphics(String fName) {
		_img = new ImageIcon(
				getClass().getResource(fName));
	}
}
