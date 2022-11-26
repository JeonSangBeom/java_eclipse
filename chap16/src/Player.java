import java.awt.Image;

import javax.swing.ImageIcon;

public class Player { // 플레이어 생성(변수 설정)
	// 사용자가 사용할 비행기
	// x,y (좌표 설정용) - 좌표를 받고 실시간으로 움직이려면 스레드 필요
	// width,height(넓이 높이)
	// speedX,speedY(스피드 (속도))
	// hp(체력)
	// score(점수 표시)
	// shootDelay(총알 발사(속도))
	// image(비행기 불러오기)
	
	//우선 편하게 public로 생성
	public Image image = new ImageIcon("images/space-ship.png").getImage();
	// 이미지 불러오기 getImage()를 입력하면 이미지 아이콘에서 이미지를 불러올 수 있다
	public int x; // 좌표 
	public int y;
	public int width = image.getWidth(null);//이미지의 넓이 높이를 구해오는 식
	public int height = image.getHeight(null);
	public int speedX = 20;//속도
	public int speedY = 20;
	public int hp = 100;//체력
	public int score = 0; // 점수
	public int shootDelay = 5; // 총알 속도
	Player(int x, int y, int hp) {//생성자 생성 int x, int y, int hp - 매개변수 - 생성시 기본 x,y,hp를 가지고 태어나게 만들어 둔다
		this.x = x;
		this.y = y;
		this.hp = hp;
	}
	//메서드 4개 설정(이동 시)
	public void moveLeft() {
		x -= speedX; // 600으로 생성된 x를 speedX10을 뺴주면 590이 된다(10의 값만큼 이동한다는 뜻)
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