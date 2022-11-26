import java.awt.Image;

import javax.swing.ImageIcon;

public class Boom {
	public Image image = new ImageIcon("images/burn.png").getImage();
	public int x;
	public int y;
	public int width;
	public int height;
	public int count = 0;
	Boom(int x, int y) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
	}
	public void effect() {
		count++;
	}
}
