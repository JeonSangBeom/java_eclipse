package practice;
//풍선 생성 
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class BalloonPanel extends JPanel {
	public BalloonPanel() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(500, 500));
		//마우스 이벤트
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// System.out.println("aaa");
//				int speedX = (int) (Math.random() * 10 - 5);//-5~5사이
//				int speedY = (int) (Math.random() * 3 + 1);//1~4사이
				BalloonThread bt = new BalloonThread(e.getX() - 32, e.getY() - 32, e.getX()-32);//loadX는 생성 되는 위치 기준 설명
				bt.start();
			}
		});
	}

	class BalloonThread extends Thread {
		private JLabel balloon;
		private int speedX;
		private int speedY;
		private double t = 0;
		private int radius = 10;
		private int loadX;

		public BalloonThread(int x, int y, int loadX) {
			ImageIcon imgBalloon = new ImageIcon("images/balloon.png");//이미지 불러오기
			balloon = new JLabel(imgBalloon);//이미지 넣기
			//레이아웃이 null이기 때문에 넓이 위치를 잡아주기
			balloon.setSize(imgBalloon.getIconWidth(), imgBalloon.getIconHeight());//이미지 크기
			balloon.setLocation(x, y);
			//this.speedX = (int)(Math.random()*10-5);
			this.speedY = (int)(Math.random()*3+1);
			this.radius = (int)(Math.random()*20+10);
			this.loadX = loadX;
			add(balloon);//JPanel에 추가
			repaint();//다시 그림그리기
		}
		//풍선 이동
		public void run() {
			while (true) {
				int currentX = (int)(Math.sin(t)*radius)+loadX;//삼각함수는 -1부터 1까지의 이동을 한다/radius-기본 값(흔들리는 효과를 더 주기 위해) /loadX=생성되는 위치(기준)
				//sin함수의 주기는 2파이(6.28정도)이다 이 값만큼 위치값이 이동하게 될 것 (t += 0.1이기 때문)
				//System.out.println(currentX);
				int currentY = balloon.getY() - speedY;
				balloon.setLocation(currentX, currentY);
				t += 0.1;//흔들림의 속도 - 주기
				repaint();
				if (currentY < -64) {//currentY 64보다작으면(이미지 크기보다) 
					remove(balloon);//사라지게
					repaint();
					return;//함수 빠져나가기 (스레드 종료)
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class Chap1306 extends JFrame {
	public Chap1306() {
		this.setTitle("풍선 만들기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new BalloonPanel());
		this.setSize(500, 500);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Chap1306();
	}
}
