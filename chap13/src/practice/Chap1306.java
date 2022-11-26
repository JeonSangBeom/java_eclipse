package practice;
//ǳ�� ���� 
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
		//���콺 �̺�Ʈ
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// System.out.println("aaa");
//				int speedX = (int) (Math.random() * 10 - 5);//-5~5����
//				int speedY = (int) (Math.random() * 3 + 1);//1~4����
				BalloonThread bt = new BalloonThread(e.getX() - 32, e.getY() - 32, e.getX()-32);//loadX�� ���� �Ǵ� ��ġ ���� ����
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
			ImageIcon imgBalloon = new ImageIcon("images/balloon.png");//�̹��� �ҷ�����
			balloon = new JLabel(imgBalloon);//�̹��� �ֱ�
			//���̾ƿ��� null�̱� ������ ���� ��ġ�� ����ֱ�
			balloon.setSize(imgBalloon.getIconWidth(), imgBalloon.getIconHeight());//�̹��� ũ��
			balloon.setLocation(x, y);
			//this.speedX = (int)(Math.random()*10-5);
			this.speedY = (int)(Math.random()*3+1);
			this.radius = (int)(Math.random()*20+10);
			this.loadX = loadX;
			add(balloon);//JPanel�� �߰�
			repaint();//�ٽ� �׸��׸���
		}
		//ǳ�� �̵�
		public void run() {
			while (true) {
				int currentX = (int)(Math.sin(t)*radius)+loadX;//�ﰢ�Լ��� -1���� 1������ �̵��� �Ѵ�/radius-�⺻ ��(��鸮�� ȿ���� �� �ֱ� ����) /loadX=�����Ǵ� ��ġ(����)
				//sin�Լ��� �ֱ�� 2����(6.28����)�̴� �� ����ŭ ��ġ���� �̵��ϰ� �� �� (t += 0.1�̱� ����)
				//System.out.println(currentX);
				int currentY = balloon.getY() - speedY;
				balloon.setLocation(currentX, currentY);
				t += 0.1;//��鸲�� �ӵ� - �ֱ�
				repaint();
				if (currentY < -64) {//currentY 64����������(�̹��� ũ�⺸��) 
					remove(balloon);//�������
					repaint();
					return;//�Լ� ���������� (������ ����)
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
		this.setTitle("ǳ�� �����");
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
