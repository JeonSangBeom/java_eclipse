import java.awt.Image;

import javax.swing.ImageIcon;

public class PlayerBullet {
	public Image image = new ImageIcon("images/bullet01.png").getImage();
	public int x;
	public int y;
	public int width = image.getWidth(null);
	public int height = image.getHeight(null);
	public int speedY = 20; // speedx는 필요 없으니 지워둔다
	public int damage = 10; // hp는 필요가 없어 지우고 데미지 재설정
	PlayerBullet(int x, int y, int damage) {
		this.x = x;
		this.y = y;
		this.damage = damage;
	}
	public void shoot() {// 위로만 올라가면 되어 따로 설정 필요 없이 y만 있으면 된다
		y-=speedY;
	}
}
