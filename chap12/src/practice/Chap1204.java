package practice;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chap1204 extends JFrame {
	private ImgPanel imgPanel= new ImgPanel();

	public Chap1204() {
		this.setTitle("그래픽이용");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(imgPanel);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}

	

	class ImgPanel extends JPanel {
		private ImageIcon imgIcon = new ImageIcon("images/apple.png");// 이미지 불러오기
		private Image img = imgIcon.getImage();//이미지만 뽑기
		private int w;
		private int h;
		private int posX = 100;
		private int posY = 100;
		public ImgPanel() {
			w = img.getWidth(this);// 본인 넓이 높이 넣어주기 변수에
			h = img.getHeight(this);
			//System.out.println(w+"==="+h); //32 === 32 출력
			
			//이벤트 걸기
			MyMouseListener listener = new MyMouseListener();
			this.addMouseListener(listener);
			this.addMouseMotionListener(listener);
		}
		//그림 그리기
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,posX,posY,w,h,this);// 이미지 그리기(이미지 , 좌표, 크기, 여기에스캔표시)
		}
		class MyMouseListener extends MouseAdapter { // private의 접근을 위해 inner클래스로 화룡ㅇ
			private Point pressedPoint;
			private boolean isDrag = false;			
			
			public void mousePressed(MouseEvent e) {//누르는 순간
				pressedPoint = e.getPoint();//좌표 가져오고
				//그림 사각형 좌표 안 조건에 만족되는 코드
				if(posX  <= pressedPoint.x && posX+w  >= pressedPoint.x &&  
				   posY  <= pressedPoint.y && posY+h  >= pressedPoint.y) {
					isDrag= true;// 사각형 안에 있을 경우 조건 참이 된다
				}
			}

			public void mouseReleased(MouseEvent e) {
				JPanel panel = (JPanel) e.getSource();
				Point mousePoint = e.getPoint();
				repaint();
				isDrag=false;// 마우스를 때면 false로 해두기 / 그래야 이동이 안된다
			
			}

			public void mouseDragged(MouseEvent e) {
				if(isDrag==false) return;// false라면 리턴(사각형 안이 아니면)
				Point mousePoint  = e.getPoint(); // 마우스 좌표 값 얻어오기
				posX = posX+mousePoint.x - pressedPoint.x;
				posY = posY+mousePoint.y - pressedPoint.y;
				pressedPoint = mousePoint; // 아니면 값이 계속 증폭이 되어 문제가 생김
				repaint();
			}
		}
	}

	public static void main(String[] args) {
		new Chap1204();
	}
}
