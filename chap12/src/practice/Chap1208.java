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
		this.setTitle("�׸��׸���");
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
			// x���� radius���� y�� - ���� �߽����� ���� ���� �ǰ� �ϱ� ����
			return new Point(x-radius,y-radius);
		}
		public int getDiameter() {
			return this.radius*2;
		}
	}

	class ImgPanel extends JPanel {
		//��Ŭ ���� ���� ����
		private Vector<Circle> circleVec = new Vector<>();
		private Circle currentCircle;
		//������ ����
		public ImgPanel() {
			//���콺 �̺�Ʈ ���� �� ������ �߰�
			MyMouseListener listener = new MyMouseListener();
			this.addMouseListener(listener);
			this.addMouseMotionListener(listener);
		}
		//�׸� �׸���
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);//���� ����
			for(int i=0;i<circleVec.size();i++) {// ��ø�Ͽ� �׸��� �ְ� ������ �ϳ��� �׷�����(vec�� �ִ°� �׷��ش�
				Circle circle = circleVec.get(i);//��Ŭ ���� ������
				// �� �׸���
				g.drawOval(circle.getTopLeftPoint().x,
						   circle.getTopLeftPoint().y,
						   circle.getDiameter(),circle.getDiameter());
			}
//			g.drawOval(currentCircle.x-currentCircle.radius,
//					   currentCircle.y-currentCircle.radius,
//					   currentCircle.radius*2,currentCircle.radius*2);
			//���� �׷����� �� �׸���
			g.drawOval(currentCircle.getTopLeftPoint().x,
					   currentCircle.getTopLeftPoint().y,
					   currentCircle.getDiameter(),currentCircle.getDiameter());
		}
		//���콺 �̺�Ʈ
		class MyMouseListener extends MouseAdapter {
			private Point pressedPoint;
			private Point releasedPoint;
			
			public void mousePressed(MouseEvent e) {//������
				pressedPoint = e.getPoint();//��ǥ�� �޾ƿ���
			}

			public void mouseReleased(MouseEvent e) {//����
				releasedPoint = e.getPoint();//��ǥ�� �޾ƿ���
				//������ ������ ������ ��ġ
				int garo = releasedPoint.x - pressedPoint.x;
				int sero = releasedPoint.y - pressedPoint.y;
				int dist = garo * garo + sero * sero; //�Ÿ� (������ ���ϸ� �ȴ�)
				int radius = (int)Math.sqrt(dist); // ������ ���ϴ� ��
				Circle circle = new Circle(pressedPoint.x,pressedPoint.y,radius);//���� /�����ڷ� ������ �������� �� ����
				circleVec.add(circle);//�߰�
				//System.out.println(circleVec.size());
				repaint();
			}

			public void mouseDragged(MouseEvent e) {//�̵���
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
