import java.awt.Image;

import javax.swing.ImageIcon;

public class PlayerBullet {
	public Image image = new ImageIcon("images/fire02.png").getImage();
	public int x;
	public int y;
	public int width = image.getWidth(null);
	public int height = image.getHeight(null);
	public int speedX = 30;
	public int damage = 10;
	PlayerBullet(int x, int y, int damage) {
		this.x = x;
		this.y = y;
		this.damage = damage;
	}
	public void shoot() {
		x+=speedX;
	}
}
