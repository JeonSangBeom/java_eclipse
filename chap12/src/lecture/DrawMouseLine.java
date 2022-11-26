package lecture;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawMouseLine extends JFrame {
	private DrawPanel drawPanel= new DrawPanel();
	public DrawMouseLine() {
		this.setTitle("그림그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(drawPanel); 

		this.setSize(300,300);
		this.setVisible(true);
	}
	
	class DrawPanel extends JPanel {
		//만들 좌표 변수에 넣기  - Point=좌표를 잡아주는 객체(자바 기본 제공)
		private Vector<Point> startVec = new Vector<>();
		private Vector<Point> endVec = new Vector<>();
		public DrawPanel() {// 생성자 생성 후 이벤트 붙이기
			//마우스 이벤트를 이용하여 라인 그리기
			this.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					//이곳을 두번째 좌표로 잡기.
					Point endPoint = e.getPoint();
					endVec.add(endPoint);
					repaint();// 값을 다시 호출해준다 / 재시작 (동적으로 만들어줌)
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					//이곳을 첫번째 좌표로 잡기.
					Point startPoint = e.getPoint();// 내가 잡아둔 포인트 넣어두기
					startVec.add(startPoint);
				}
				
				@Override
				public void mouseExited(MouseEvent e) {}				
				@Override
				public void mouseEntered(MouseEvent e) {}				
				@Override
				public void mouseClicked(MouseEvent e) {}
			});
		}
		//그림그리기 메서드
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			for(int i=0;i<startVec.size();i++) {
				Point startPoint = startVec.elementAt(i); //포인트 얻어와 변수에 넣기
				Point endPoint = endVec.elementAt(i);
				//System.out.println(startPoint.getX());
				//System.out.println(startPoint.getY());
				//Point리턴 타입 때문에 정수로 형봔환 필요
				g.drawLine((int)startPoint.getX(),(int)startPoint.getY(),
						   (int)endPoint.getX(),(int)endPoint.getY());
			}
		}
	}
	public static void main(String[] args) {
		new DrawMouseLine();
	}
}



