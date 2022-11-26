import java.awt.Image;

import javax.swing.ImageIcon;

public class Boom02 {
	public Image image = new ImageIcon("images/bubble-chat.png").getImage();
	public int x;
	public int y;
	public int width = image.getWidth(null);
	public int height = image.getHeight(null);
	public int count = 0;
	
	Boom02(int x, int y) {
		this.x = x;
		this.y = y;
		//this.count = 0;
	}

	public void explosion() {//≈Õ¡˙∂ß 
		count++;
	}
}
