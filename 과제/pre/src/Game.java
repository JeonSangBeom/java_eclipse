import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	public int threadDelay = 20; 
	public Player player = new Player(100, 400, 100); 
	public boolean isLeft = false;
	public boolean isRight = false;
	public boolean isUp = false;
	public boolean isDown = false;
	public boolean isShoot = false;

	private int count = 0;
	private int bulletDelay = 2;
	private int enemyDelay = 20;

	public PlayerBullet playerBullet;
	public int playerBulletDamage = 10;

	public Enemy enemy;
	private String enemyImageList[] = { "monster", "monster.02", "monster.03" };
	
	public Boom02 boom;
	private ArrayList<Boom02> boomList = new ArrayList<>();

	public Heart heart;
	private ArrayList<Heart> heartList = new ArrayList<>();
	
	public ArrayList<PlayerBullet> playerBulletList = new ArrayList<>();
	public ArrayList<Enemy> enemyList = new ArrayList<>();

	public boolean isOver = false;

	private Image gameImage = new ImageIcon("images/cloud.jpg").getImage();
	private Image endingImage = new ImageIcon("images/cloud_end.jpg").getImage();


	public Game() {
		isOver = false;
		playerBulletList.clear();
		enemyList.clear();
		count = 0;
		start(); 
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(threadDelay);
			} catch (InterruptedException e) {
				return;
			}
			count++;
			keyProcess(); 
			playerBulletProcess();
			makeEnemy();
			enemyProcess();
			boomProcess();
			
			heartProcess();
			
		}
	}

	
	private void makeHeart02(int x,int y) {
		if (Math.random() < 0.05) {
			heart = new Heart(x, y, 10);
			heartList.add(heart);
		}
	}
	public void heartProcess() {
		for (int i = 0; i < heartList.size(); i++) {
			heart = heartList.get(i);
			heart.moveDown();
			if (hitEnemy(new Rectangle(player.x, player.y, player.width, player.height),
					new Rectangle(heart.x, heart.y, heart.width, heart.height))) {
				heartList.remove(heart);
				player.hp += heart.hp;
				if(player.hp>100) player.hp=100; //100�씠�긽 利앷� 紐삵븯寃�...
			}
			if (heart.y > 1200 + 64) {
				heartList.remove(heart);
			}
		}
	}

	private void makeEnemy() {
		if (count % enemyDelay == 0) {
			String enemyImage = enemyImageList[(int) (Math.random() * 3)];
			int randomY = (int) (Math.random() * 600 + 100);
			enemy = new Enemy(1250, randomY, 30, enemyImage);
			enemyList.add(enemy);
		}
	}

	public void enemyProcess() {
		for (int i = 0; i < enemyList.size(); i++) {
			enemy = enemyList.get(i);
			enemy.moveLeft();

			if (hitEnemy(new Rectangle(player.x, player.y, player.width, player.height),
					new Rectangle(enemy.x, enemy.y, enemy.width, enemy.height))) {
				enemyList.remove(enemy);
				player.hp -= enemy.damage;
				if (player.hp <= 0) {
					isOver= true;
					interrupt(); 
				}
			}
			if (enemy.x < -64) {
				player.hp -= enemy.damage; 
				enemyList.remove(enemy);
				if (player.hp <= 0) {
					isOver= true;
					interrupt(); 
				}
			}
		}
	}

	public void playerBulletProcess() {
		for (int i = 0; i < playerBulletList.size(); i++) {
			playerBullet = playerBulletList.get(i);
			playerBullet.shoot();

			for (int j = 0; j < enemyList.size(); j++) {
				enemy = enemyList.get(j);
				if (hitEnemy(new Rectangle(playerBullet.x, playerBullet.y, playerBullet.width, playerBullet.height),
						new Rectangle(enemy.x, enemy.y, enemy.width, enemy.height))) {
					playerBulletList.remove(playerBullet);
					enemy.hp -= playerBullet.damage;
					
				}
				
				if (enemy.hp <= 0) {
					enemyList.remove(enemy);
					boom = new Boom02(enemy.x,enemy.y);
					boomList.add(boom);
					makeHeart02(enemy.x,enemy.y);
				}
			}

			if (playerBullet.y < -64) {
				playerBulletList.remove(playerBullet);
			}
		}
	}
	public void boomProcess() {
		for(int i=0;i<boomList.size();i++) {
			boom = boomList.get(i);
			boom.explosion();
			if(boom.count>10) {
				boomList.remove(boom);
			}
			
		}
	}
	

	public void keyProcess() {
		if (isLeft)
			player.moveLeft();
			if(player.x<=0) {
				player.x=0;
			}
		if (isRight)
			player.moveRight();
			if(player.x>=1200-64) {
				player.x=1200-64;
			}		
		if (isUp)
			player.moveUp();
			if(player.y<=0) {
				player.y=0;
			}	
		if (isDown)
			player.moveDown();
			if(player.y>=800-64) {
				player.y=800-64;
			}	
		if (isShoot && count % bulletDelay == 0) { 
			playerBullet = new PlayerBullet(player.x + 27, player.y - 17, playerBulletDamage);
			playerBulletList.add(playerBullet);
		}
	}

	public boolean hitEnemy(Rectangle rect01, Rectangle rect02) {
		return rect01.intersects(rect02);
	}

	public void drawPlayer(Graphics g) {
		g.drawImage(player.image, player.x, player.y, null);
	}

	public void drawPlayerBullet(Graphics g) {
		for (int i = 0; i < playerBulletList.size(); i++) {
			playerBullet = playerBulletList.get(i);
			g.drawImage(playerBullet.image, playerBullet.x, playerBullet.y, null);
		}
	}

	public void drawEnemy(Graphics g) {
		for (int i = 0; i < enemyList.size(); i++) {
			enemy = enemyList.get(i);
			g.drawImage(enemy.image, enemy.x, enemy.y, null);
		}
	}
	public void drawHeart(Graphics g) {
		for (int i = 0; i < heartList.size(); i++) {
			heart = heartList.get(i);
			g.drawImage(heart.image, heart.x, heart.y, null);
		}
	}
	

	public void drawInfo(Graphics g) {
		g.setColor(Color.yellow);
		g.setFont(new Font("Arial", Font.BOLD, 24));
		g.drawString("HP : " + player.hp, 30, 30);

		g.setColor(Color.WHITE);
		g.fillRect(130, 17, 300, 5);
		g.setColor(Color.RED);
		g.fillRect(130, 17, 300 * player.hp / 100, 5);

		g.setFont(new Font("Arial", Font.BOLD, 18));
		for (int i = 0; i < enemyList.size(); i++) {
			enemy = enemyList.get(i);
			g.setColor(Color.WHITE);
			g.fillRect(enemy.x, enemy.y - 20, 64, 4);
			g.setColor(Color.RED);
			g.fillRect(enemy.x, enemy.y - 20, enemy.width * enemy.hp / 30, 4);
		}
	}
	public void drawEnding(Graphics g) {
		g.drawImage(endingImage,0,0,null);
	}
	public void drawGaming(Graphics g) {
		g.drawImage(gameImage,0,0,null);
	}
	public void drawBoom(Graphics g) {
		for (int i = 0; i < boomList.size(); i++) {
			boom = boomList.get(i);
			g.drawImage(boom.image, boom.x, boom.y, null);
		}
	}
	public void drawAll(Graphics g) {
		if(isOver) drawEnding(g);
		else {
			drawGaming(g);
			drawPlayer(g);
			drawPlayerBullet(g);
			drawEnemy(g);
			drawInfo(g);
			drawBoom(g);
			drawHeart(g);
		}
	}
}
