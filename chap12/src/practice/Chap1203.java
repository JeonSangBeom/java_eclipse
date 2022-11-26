package practice;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chap1203 extends JFrame {
	//private ImgPanel imgPanel;

	public Chap1203() {
		this.setTitle("사과 이미지 드래그로 이동");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		// this.setContentPane(imgPanel);
		contentPane.setLayout(null);
		
		ImageIcon imgIcon = new ImageIcon("images/apple.png");
		JLabel imgLabel = new JLabel(imgIcon);
		imgLabel.setSize(imgIcon.getIconWidth(), imgIcon.getIconHeight());// 크기 넓이 높이 잡는 법
		imgLabel.setLocation(100, 100);

		//클릭을 하고 드래그를 해야하므로 두개를 달아야 한다
		MyMouseListener listener = new MyMouseListener();
		imgLabel.addMouseListener(listener);
		imgLabel.addMouseMotionListener(listener);

		contentPane.add(imgLabel);
		this.setSize(300, 300);
		this.setVisible(true);
	}

	class MyMouseListener extends MouseAdapter {
		Point pressedPoint;

		public void mousePressed(MouseEvent e) {// 클릭했을때
			JLabel label = (JLabel) e.getSource();//JLabel로 필요하기 때문에 그걸로 형변환
			// System.out.println(label.getLocation());// 해당 이미지 클릭시 좌표 출력
			//System.out.println(e.getPoint().x + "===" + e.getPoint().y);
			pressedPoint = e.getPoint();// 클릭시 point 정보
		}

		public void mouseReleased(MouseEvent e) {//드래그를 놓는 순간
			JLabel label = (JLabel) e.getSource();
			Point mousePoint = e.getPoint();
			Point labelPoint = label.getLocation();

			int posX = labelPoint.x + mousePoint.x;
			int posY = labelPoint.y + mousePoint.y;
			label.setLocation(posX - pressedPoint.x, posY - pressedPoint.y);// 클릭시 point의 값을 빼줘야 이질감이 사라진다
			label.getParent().repaint();//label의 부모(container/이렇게 접근할 수 밖에 없다)를 repaint
										//움직일때마다 위치 값이 바뀌면 repaint를 해주는 것이 좋다
		}

		public void mouseDragged(MouseEvent e) {//드래그 시
			JLabel label = (JLabel) e.getSource();//JLabel 정보 얻어오고
			Point mousePoint = e.getPoint();// 마우스 이동 포인트 좌표 얻어오고
			Point labelPoint = label.getLocation(); // label값을(좌표) 받아오기 (위치)

			int posX = labelPoint.x + mousePoint.x;//setLocation때문에 label의 값은 그 뒤에 바뀐다 그 바뀐 것을 mousePoint와 더해주고 그것을 setLocation에 다시 넣어주는 형식
			int posY = labelPoint.y + mousePoint.y;
			label.setLocation(posX - pressedPoint.x, posY - pressedPoint.y); //pressedPoint 대신 -16을 쓸 경우 가운데를 잡고 움직여진다(무조건)
			label.getParent().repaint();
			System.out.println("mm"+mousePoint);
			System.out.println("ll"+labelPoint);
			// System.out.println(label.getLocation()); // 이동을해도 계속 같은 좌표만 출력이 된다 그래서 Point이용
		}

	}

	//class ImgPanel extends JPanel {
	//}

	public static void main(String[] args) {
		new Chap1203();
	}
}
