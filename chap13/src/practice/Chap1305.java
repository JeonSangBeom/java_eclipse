package practice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.css.Rect;
//치킨 스레드
class ChickenThread extends Thread {
	private JLabel target;
	public ChickenThread(JLabel target) {
		this.target = target;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				try {
					Thread.sleep(1000);// 0.02초마다 움직이는데 안움직이게 될 경우 1초정도 멈추어라
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				//e.printStackTrace();
			}
			int x = target.getX() - 5;//좌로 5씩 이동
			int y = target.getY();
			if(x<-64) target.setLocation(500,y);//x가 -64보다 작아지면 다시 500의 위치로 이동
			else target.setLocation(x,y);
			target.getParent().repaint();//다시 그리기(다시 그리는 것으 본인이 아닌 부모가 그리면 된다)
										//치킨의 부모
		}
	}
}
////////////////////////////////
//총알 스레드
class BulletThread extends Thread {
	private JLabel target;
	private JLabel chicken; //치킨 받아오기(클래스로 나뉘어져 있기 때문에 따로 불러와야 한다)
	private Thread chickenTh;
	public BulletThread(JLabel target, JLabel chicken, Thread chickenTh ) {
		this.target = target;
		this.chicken= chicken;
		this.chickenTh = chickenTh;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//충돌시 조건걸기
			if(hitChicken()) {//충돌을 할 경우 총알 원 위치 이동
				target.setLocation(250 - 5, 500 - 64 - 20);
				chickenTh.interrupt();//방해 일으키기
				return;//총알 원 위치 이동
			} else {
				int x = target.getX();//총은 위로만 가서 여긴 고정
				int y = target.getY() - 5;//위로 이동시 -5씩(현재 위치에서 -5를 뺴줘야 -5되는 위치인 위에서 다시 생성)
				if(y < -10) {// 총알 크기가 10이기 때문에 -10은 완전히 사라질떄를 가리킨다
					target.setLocation(250 - 5, 500 - 64 - 20);
					target.getParent().repaint();
					return;//멈추게 return 값 주기
				} else {
					target.setLocation(x,y);
				}
				target.getParent().repaint();
			}
		}
	}
	// 충돌되는 부분
	//Rectangle rect = new Rectangle(); -> 이런 객체를 나중엔 사용하게 된다(충돌방지시 사용하게 된다(intersects(교집합))
	private boolean hitChicken() {
		if(targetContains( target.getX(),target.getY() ) ) {
			return true;
		} else {
			return false;
		}
	}
	private boolean targetContains(int x, int y) {
		if( 
			(( chicken.getX() <= x ) && ( chicken.getX()+ chicken.getWidth()  >= x )) &&//x의 위치 값(치킨의 x값 안에 있을때 작동)
			(( chicken.getY() <= y ) && ( chicken.getY()+ chicken.getHeight() >= y )) //y의 위치
		  ) return true;//가 같으면 참 아닐 경우 false
		else return false;
	}
}

////////////////////////////////
//게임 패널
class GamePanel extends JPanel {
	private JLabel chicken;//JLabel에 닭 이미지 넣기
	private JLabel spaceShip;//
	private JLabel bullet;//총알
	//위에 class로 만든 스레드 변수에 담기
	private ChickenThread chickenTh;
	private BulletThread bulletTh;
	public GamePanel() {
		this.setLayout(null);//마음대로 움직여야 하기떄문에 null로
		this.setPreferredSize(new Dimension(500, 500));//크기 정하기
		
		//이미지 불러온 후 레이블에 넣기
		ImageIcon imgChicken = new ImageIcon("images/hen02.png");
		ImageIcon imgSpaceShip = new ImageIcon("images/spaceship.png");
		//선언 및 이미지 넣기
		chicken = new JLabel(imgChicken);
		chicken.setSize(imgChicken.getIconWidth(), imgChicken.getIconHeight());//이미지 본연의 크기
		chicken.setLocation(500 - 64, 0);//일단 패널 끝으로 이동
		spaceShip = new JLabel(imgSpaceShip);
		spaceShip.setSize(imgSpaceShip.getIconWidth(), imgSpaceShip.getIconHeight());
		spaceShip.setLocation(250 - 32, 500 - 64);//가장 하단 정중앙에 생성
		//총알은 직접 그려 사용
		bullet = new JLabel();
		bullet.setOpaque(true);
		bullet.setBackground(Color.RED);//색상
		bullet.setSize(10, 10);//크기
		bullet.setLocation(250 - 5, 500 - 64 - 20);
		
		//패널에 넣기
		this.add(chicken);
		this.add(spaceShip);
		this.add(bullet);
		
		//선언 및 타겟 생성자 넣어주기
		chickenTh = new ChickenThread(chicken);
		chickenTh.start();
		//키이벤트를 사용할시 포커스 동반 필수
		this.setFocusable(true);
		this.requestFocus();
		
		//엔터키를 눌렀을떄 작동
		this.addKeyListener(new KeyAdapter() {
			BulletThread bulletTh = null; //참이 한번만 생성되기 때문에 Alive를 사용하지 않으면 작동 불가
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(bulletTh == null || !bulletTh.isAlive()) {//값이 null일때만 작동하게 만들기
						//!bulletTh.isAlive() - 살아있지 않다면의 뜻
						bulletTh = new BulletThread(bullet,chicken,chickenTh);
						bulletTh.start();
						//System.out.println("Enter");
					}
				}
			}
		});
//		bulletTh = new BulletThread(bullet,chicken);
//		bulletTh.start();
	}
}

////////////////////
//메인 실행 함수
public class Chap1305 extends JFrame {
	public Chap1305() {
		this.setTitle("닭을 잡아라");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(new GamePanel());
		
		this.setSize(500, 500);
		this.setResizable(false);//크기 조정 못하게 막기		
		this.pack();//Dimension 와 함께 사용 크기를 맞춰주기 위해서
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Chap1305();
	}
}
