package practice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chap1208 extends JFrame {
	private ImgPanel imgPanel = new ImgPanel();

	public Chap1208() {
		this.setTitle("그림그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(imgPanel);

		this.setSize(600, 600);
		this.setVisible(true);
	}

	class Circle {
		public int x;
		public int y;
		public int radius;
		
		public Circle() {

		}
		public Circle(int x, int y, int radius) {
			this.x = x;
			this.y = y;
			this.radius = radius;
		}
		public Point getTopLeftPoint() {
			// x에서 radius빼기 y도 - 원의 중심으로 가서 생성 되게 하기 위해
			return new Point(x-radius,y-radius);
		}
		public int getDiameter() {
			return this.radius*2;
		}
	}

	class ImgPanel extends JPanel {
		//서클 담을 백터 생성
		private Vector<Circle> circleVec = new Vector<>();
		private Circle currentCircle;
		//생성자 생성
		public ImgPanel() {
			//마우스 이벤트 선언 및 리스너 추가
			MyMouseListener listener = new MyMouseListener();
			this.addMouseListener(listener);
			this.addMouseMotionListener(listener);
		}
		//그림 그리기
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);//색상 설정
			for(int i=0;i<circleVec.size();i++) {// 중첩하여 그릴수 있게 없으면 하나만 그려진다(vec에 있는걸 그려준다
				Circle circle = circleVec.get(i);//서클 정보 얻어오고
				// 원 그리기
				g.drawOval(circle.getTopLeftPoint().x,
						   circle.getTopLeftPoint().y,
						   circle.getDiameter(),circle.getDiameter());
			}
//			g.drawOval(currentCircle.x-currentCircle.radius,
//					   currentCircle.y-currentCircle.radius,
//					   currentCircle.radius*2,currentCircle.radius*2);
			//새로 그려지는 것 그리기
			g.drawOval(currentCircle.getTopLeftPoint().x,
					   currentCircle.getTopLeftPoint().y,
					   currentCircle.getDiameter(),currentCircle.getDiameter());
		}
		//마우스 이벤트
		class MyMouseListener extends MouseAdapter {
			private Point pressedPoint;
			private Point releasedPoint;
			
			public void mousePressed(MouseEvent e) {//누를때
				pressedPoint = e.getPoint();//좌표값 받아오기
			}

			public void mouseReleased(MouseEvent e) {//떌떄
				releasedPoint = e.getPoint();//좌표값 받아오기
				//누르고 땠을때 까지의 위치
				int garo = releasedPoint.x - pressedPoint.x;
				int sero = releasedPoint.y - pressedPoint.y;
				int dist = garo * garo + sero * sero; //거리 (제곱을 구하면 된다)
				int radius = (int)Math.sqrt(dist); // 반지름 구하는 식
				Circle circle = new Circle(pressedPoint.x,pressedPoint.y,radius);//선언 /생성자로 지정한 공식으로 원 생성
				circleVec.add(circle);//추가
				//System.out.println(circleVec.size());
				repaint();
			}

			public void mouseDragged(MouseEvent e) {//이동시
				releasedPoint = e.getPoint();
				int garo = releasedPoint.x - pressedPoint.x;
				int sero = releasedPoint.y - pressedPoint.y;
				int dist = garo * garo + sero * sero;
				int radius = (int)Math.sqrt(dist);
				currentCircle = new Circle(pressedPoint.x,pressedPoint.y,radius);
				repaint();
			}
		}
	}

	public static void main(String[] args) {
		new Chap1208();
	}
}
