import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
//GamePanel - 게임 화면 그리기 / 이벤트
public class GamePanel extends JPanel { //setContentPane을 상속 받으려면 JPanel을 상속 받아야만 가능하다
	// 그림 그리는 역할
	private Image bufferImage; // 버퍼 이미지 만들고 임폴트
	private Graphics screenGraphics;// screenGraphics 임폴트
	
	//배경 이미지 불러오기
	private Image loadingImage = new ImageIcon("images/loading_page.jpg").getImage();
	private Image startImage = new ImageIcon("images/start_page.jpg").getImage();
	
	private Game game;// 게임을 정의하고(Game클래스 이용을 하기 위해) 
	
	//상태를 나타내는 변수 생성(시작이미지로 넘어가게)
	private String isState = "start";
	private int num=0;
	GamePanel() { //생성자 하나 생성 - 기본 크기 및 색상 설정을 하면 GameMain에서 설정한 pack이 상속 받아 나타낸다
		this.setPreferredSize(new Dimension(1200, 800));//기본 설정 크기 설정 /Dimension(치수)-라고 써야만 먹는다
		this.setOpaque(true);//불투명 설정
		this.setBackground(Color.BLACK);//배경 설정
		gameInit();//아래 생성시킨 gameInit()를 불러 오면 GamePanel에서 실행
	}

	public void gameInit() { // 게임 생성을 하나 해둔다 (내용이 많아 따로 메서드 생성)
		game = new Game(); // 게임으로 생성해둔 것 선언
		
		//키 이벤트 사용시 기본 옵션
		this.setFocusable(true);//키 이벤트 값을 받을 수 있게 해준다(초점 설정)		
		this.requestFocus();//키 이벤트 값을 받을 수 있게 해준다(초점의 값 요청)
		
		// 키로 이벤트를 받게(키보드로 이미지 이동시키게 만드는 이벤트) / KeyListener(눌렀을때 땠을때 사용) -오버라이드 자동 생성
		this.addKeyListener(new KeyListener() { 
			@Override//사용안할경우 그냥 둬야 한다
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {//keyReleased - 키를 때는 순간
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT: // 누르고 가다가 때면 false를 줘서 멈춰 준다
					game.isLeft = false;
					break;
				case KeyEvent.VK_RIGHT:
					game.isRight = false;
					break;
				case KeyEvent.VK_UP:
					game.isUp = false;
					break;
				case KeyEvent.VK_DOWN:
					game.isDown = false;
					break;
				case KeyEvent.VK_SPACE:
					game.isShoot = false;
					break;
				}
			}
			@Override
			public void keyPressed(KeyEvent e) { // keyPressed - 키를 눌렀을때
				// System.out.println(e.getKeyCode());
				switch (e.getKeyCode()) {// 키 값을 얻어 오고
				case KeyEvent.VK_LEFT:// 조건1 버츄얼 키보드가 왼쪽이 눌리면
					game.isLeft = true;//game에 있는 false 값을 true로 변경 
					break;
				case KeyEvent.VK_RIGHT:
					game.isRight = true;
					break;
				case KeyEvent.VK_UP:
					game.isUp = true;
					break;
				case KeyEvent.VK_DOWN:
					game.isDown = true;
					break;
					
				case KeyEvent.VK_SPACE: // 총알 나가는 것
					game.isShoot = true;
					break;		
					
				case KeyEvent.VK_R:
					//game = new Game();
					//game.isOver= false; 게임 리스타트 하게 하는 방법 - 게임 도중에도 R을 누르면 다시 시작하는 문제 발생
					if(game.isOver) isState="start";//game에 있는 isOver가 참일때만 R을 누를 수 있게 - 눌리면 isState를 start로 바꿔준다
					break;
				case KeyEvent.VK_ENTER:
					if(isState=="start") { //위에 지정한 변수 isState가 start라면
						startGame();// 메서드 불러와서 isState가 loading가 된다
					}
					break;
				case KeyEvent.VK_ESCAPE: // 키보드 esc를 누르면 닫아지는 역할을 해준다
					System.exit(0);
					break;
				}
			}
		});
	}
	private void startGame() {// 게임이 시작되면
		isState="loading"; // 상태 isstate 변수는 loading으로 설정
		//시간 설정 - 시간 지나면 게임 시작하게
		Timer loadingTimer = new Timer();// Timer 임폴트 - 하나의 스레드 
		TimerTask loadingTimerTask = new TimerTask() { //위와 같이 다니며 setTimeout과 같다
			@Override
			public void run() {// 3초 뒤면 바뀐다 (아래 설정된 값)
				isState = "gaming"; 
				game = new Game();
			}
		};
		loadingTimer.schedule(loadingTimerTask, 3000); // 3초뒤 시작하겠다(스케줄)
	}
	
	
	
	
	
	// double buffering 기법 ( 하나씩 플레이어를 생성하는 것이 아닌 화면캡처처럼 생각하면 된다)
	public void paintComponent(Graphics g) {//그림 그리기		
		// 1. 버퍼 이미지 생성
		// 2. 메모리 상에 올리기
		// 3. graphics 가 그리기
		num++;
		bufferImage = this.createImage(1200, 800); // 버퍼 이미지로 이미지를 하나 생성해두고(패널 크기) - Image 클래스
		screenGraphics = bufferImage.getGraphics();//screenGraphics에 이미지 넣기 - Graphics 클래스에
		screenCapture(screenGraphics);// screenGraphics의 이미지 안에 만들어둔 그림 넣기
		g.drawImage(bufferImage, 0, 0, null); // 그림이 담긴 이미지 를 마지막에 전체적으로 한번 그려주기(이게 반복이 된다(버퍼 이미지를 좌표 크기 null로))
	}	

	public void screenCapture(Graphics g) {// 계속 호출 되는 곳
		if(isState.equals("start")) {// 문자로 equals 사용
			g.drawImage(startImage,0,0,null);//시작 이미지
		} else if(isState.equals("loading")) {
			g.drawImage(loadingImage,0,0,null);
		} else {
			game.drawAll(g); // 캠쳐한 이미지를 게임에서 나오게 설정(그리는 것 총알, 비행기 등 전부/ Game클래스에 public로 메서드 생성한 상태)
		}
		repaint(); // 짤리는 현상 발생을 막기 위해 사용(다시 그려준다)
	}
}
