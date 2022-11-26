import java.awt.Image;

import javax.swing.ImageIcon;

public class Player { // �÷��̾� ����(���� ����)
	// ����ڰ� ����� �����
	// x,y (��ǥ ������) - ��ǥ�� �ް� �ǽð����� �����̷��� ������ �ʿ�
	// width,height(���� ����)
	// speedX,speedY(���ǵ� (�ӵ�))
	// hp(ü��)
	// score(���� ǥ��)
	// shootDelay(�Ѿ� �߻�(�ӵ�))
	// image(����� �ҷ�����)
	
	//�켱 ���ϰ� public�� ����
	public Image image = new ImageIcon("images/space-ship.png").getImage();
	// �̹��� �ҷ����� getImage()�� �Է��ϸ� �̹��� �����ܿ��� �̹����� �ҷ��� �� �ִ�
	public int x; // ��ǥ 
	public int y;
	public int width = image.getWidth(null);//�̹����� ���� ���̸� ���ؿ��� ��
	public int height = image.getHeight(null);
	public int speedX = 20;//�ӵ�
	public int speedY = 20;
	public int hp = 100;//ü��
	public int score = 0; // ����
	public int shootDelay = 5; // �Ѿ� �ӵ�
	Player(int x, int y, int hp) {//������ ���� int x, int y, int hp - �Ű����� - ������ �⺻ x,y,hp�� ������ �¾�� ����� �д�
		this.x = x;
		this.y = y;
		this.hp = hp;
	}
	//�޼��� 4�� ����(�̵� ��)
	public void moveLeft() {
		x -= speedX; // 600���� ������ x�� speedX10�� ���ָ� 590�� �ȴ�(10�� ����ŭ �̵��Ѵٴ� ��)
	}

	public void moveRight() {
		x += speedX;
	}
	public void moveUp() {
		y -= speedY;
	}

	public void moveDown() {
		y += speedY;
	}
}