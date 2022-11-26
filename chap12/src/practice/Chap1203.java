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
		this.setTitle("��� �̹��� �巡�׷� �̵�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		// this.setContentPane(imgPanel);
		contentPane.setLayout(null);
		
		ImageIcon imgIcon = new ImageIcon("images/apple.png");
		JLabel imgLabel = new JLabel(imgIcon);
		imgLabel.setSize(imgIcon.getIconWidth(), imgIcon.getIconHeight());// ũ�� ���� ���� ��� ��
		imgLabel.setLocation(100, 100);

		//Ŭ���� �ϰ� �巡�׸� �ؾ��ϹǷ� �ΰ��� �޾ƾ� �Ѵ�
		MyMouseListener listener = new MyMouseListener();
		imgLabel.addMouseListener(listener);
		imgLabel.addMouseMotionListener(listener);

		contentPane.add(imgLabel);
		this.setSize(300, 300);
		this.setVisible(true);
	}

	class MyMouseListener extends MouseAdapter {
		Point pressedPoint;

		public void mousePressed(MouseEvent e) {// Ŭ��������
			JLabel label = (JLabel) e.getSource();//JLabel�� �ʿ��ϱ� ������ �װɷ� ����ȯ
			// System.out.println(label.getLocation());// �ش� �̹��� Ŭ���� ��ǥ ���
			//System.out.println(e.getPoint().x + "===" + e.getPoint().y);
			pressedPoint = e.getPoint();// Ŭ���� point ����
		}

		public void mouseReleased(MouseEvent e) {//�巡�׸� ���� ����
			JLabel label = (JLabel) e.getSource();
			Point mousePoint = e.getPoint();
			Point labelPoint = label.getLocation();

			int posX = labelPoint.x + mousePoint.x;
			int posY = labelPoint.y + mousePoint.y;
			label.setLocation(posX - pressedPoint.x, posY - pressedPoint.y);// Ŭ���� point�� ���� ����� �������� �������
			label.getParent().repaint();//label�� �θ�(container/�̷��� ������ �� �ۿ� ����)�� repaint
										//�����϶����� ��ġ ���� �ٲ�� repaint�� ���ִ� ���� ����
		}

		public void mouseDragged(MouseEvent e) {//�巡�� ��
			JLabel label = (JLabel) e.getSource();//JLabel ���� ������
			Point mousePoint = e.getPoint();// ���콺 �̵� ����Ʈ ��ǥ ������
			Point labelPoint = label.getLocation(); // label����(��ǥ) �޾ƿ��� (��ġ)

			int posX = labelPoint.x + mousePoint.x;//setLocation������ label�� ���� �� �ڿ� �ٲ�� �� �ٲ� ���� mousePoint�� �����ְ� �װ��� setLocation�� �ٽ� �־��ִ� ����
			int posY = labelPoint.y + mousePoint.y;
			label.setLocation(posX - pressedPoint.x, posY - pressedPoint.y); //pressedPoint ��� -16�� �� ��� ����� ��� ����������(������)
			label.getParent().repaint();
			System.out.println("mm"+mousePoint);
			System.out.println("ll"+labelPoint);
			// System.out.println(label.getLocation()); // �̵����ص� ��� ���� ��ǥ�� ����� �ȴ� �׷��� Point�̿�
		}

	}

	//class ImgPanel extends JPanel {
	//}

	public static void main(String[] args) {
		new Chap1203();
	}
}
