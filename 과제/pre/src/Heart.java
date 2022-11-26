import java.awt.Image;

import javax.swing.ImageIcon;

public class Heart {
	public Image image = new ImageIcon("images/medicine.png").getImage();
	public int x;
	public int y;
	public int width = image.getWidth(null);
	public int height = image.getHeight(null);
	public int speedX = 10;
	public int hp = 10;
	public int loadY;
	public int radius;
	public double t = 0;  
	public double speedT = 0;
	public int damage = 5;
	Heart(int x, int y, int hp) {
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.loadY = y;
		this.radius = (int)(Math.random()*100+100); 
		this.speedT = Math.random()*0.05 + 0.01; 
		this.speedX=(int)(Math.random()*5+10);
	}
	public void moveDown() {
		x -= speedX;
		y = (int)(Math.cos(t)*radius)+loadY;
		t+=speedT;
	}
}
