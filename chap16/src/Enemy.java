import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	public Image image;// 크기가 달라서 결정은 다른 곳에서 하고 정의만 해둔다
	public int x;
	public int y;
	public int width;
	public int height;
	public int speedX = 10;
	public int speedY = 10;
	public int hp =30;
	public int score = 0;
	public int shootDelay = 5;
	public int loadX; // 생성되는 위치
	public int radius;// 흔들리는 반경
	public double t = 0;  //t(주기로 사용)=2파이 = 6.28 - 움직임을 주기 위해 생성
	public double speedT = 0;
	public int damage = 5;
	
	Enemy(int x, int y, int hp, String enemyImage) {
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.loadX = x; // 처음 생성되는 좌표를 받아 올 것 
		
		this.radius = (int)(Math.random()*50+50); //정수니 int로 변환 //회전 반경 50~100 
		this.speedT = Math.random()*0.05 + 0.01; // 회전 주기 (크면 클수록 빨리 돌아옴)
		this.image = new ImageIcon("images/"+enemyImage+".png").getImage();
		//그림 그릴때 image를 받기 위해 
		this.width = image.getWidth(null);// 이미지는 이미지에서 얻어온 값으로
		this.height = image.getHeight(null);
		this.speedY=(int)(Math.random()*5+5); //enmey 속도 (내려오는)
	}
	public void moveDown() {
		y += speedY;
		x = (int)(Math.cos(t)*radius)+loadX;//삼각함수 사용
		t+=speedT;
	}
}
