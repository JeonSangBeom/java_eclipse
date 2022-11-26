import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	public Image image;
	public int x;
	public int y;
	public int width;
	public int height;
	public int speedX = 10;
	public int speedY = 10;
	public int hp = 30;
	public int score = 0;
	public int shootDelay = 5;
	public int loadY;
	public int radius;
	public double t = 0;  
	public double speedT = 0;
	public int damage = 5;
	Enemy(int x, int y, int hp,String enemyImage) {
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.loadY = y;
		this.radius = (int)(Math.random()*50+50); 
		this.speedT = Math.random()*0.05 + 0.01; 
		this.image = new ImageIcon("images/"+enemyImage+".png").getImage();
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		this.speedX=(int)(Math.random()*5+5);
	}
	public void moveLeft() {
		x -= speedX;
		y = (int)(Math.cos(t)*radius)+loadY;
		t+=speedT;
	}
}
