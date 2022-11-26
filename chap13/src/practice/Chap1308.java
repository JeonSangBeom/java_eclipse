package practice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowPanel extends JPanel {
	private ImageIcon bg = new ImageIcon("images/winter.png");
	private Image img = bg.getImage();// �̹��� �ҷ��� �� �־�α�
	private Vector<Point> snowVec = new Vector<>();//�� ���� ����
	private final int SNOW_AMOUNT = 50;//���(������ �ʴ°�)�� �빮�ڷ� ���� ���� �����̴� / ���� ��
	private final int SNOW_RADIUS = 20;
	
	//�г� ����
	public SnowPanel() {
		this.setPreferredSize(new Dimension(1280, 905));
		SnowThread snowTh = new SnowThread();
		addSnow();//�� �߰�
		repaint();//�ٽ� �׸� �׸���(��ġ ���� ����ɶ� ���)
		snowTh.start();
	}
	//�̹��� �׸���
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);//�̹��� �׸���
		//�� ���� �� �׸���
		for (int i = 0; i < snowVec.size(); i++) {
			g.setColor(Color.WHITE);
			Point point = snowVec.get(i);
			//int radius = (int)(Math.random()*10+10);
			g.fillOval(point.x, point.y, SNOW_RADIUS, SNOW_RADIUS);
		}
	}
	
	//�� ���� ��ġ �� 50�� ����
	private void addSnow() {
		for (int i = 0; i < SNOW_AMOUNT; i++) {
			//��ġ ����
			int loadX = (int) (Math.random() * 1280);
			int loadY = (int) (Math.random() * 905);
			Point point = new Point(loadX, loadY);
//			System.out.println(this.getWidth());
			snowVec.add(point);//vectero
		}
	}
	//�� �̵� ������
	class SnowThread extends Thread {
		public void run() {
			while(true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(int i=0;i<snowVec.size();i++) {
					int speedX = (int)(Math.random()*6-3);
					Point point = snowVec.get(i);
					point.y+=(int)(Math.random()*5+1);
					point.x+=speedX;
					if(point.y>925) {//point�� ��ġ�� 925���� ũ��(�г��� �Ѿ��)
						point.x = (int) (Math.random() * 1280);
						point.y = -20;
					}
				}
				repaint();
			}
		}
	}
}

public class Chap1308 extends JFrame {
	public Chap1308() {
		this.setTitle("�������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new SnowPanel());
		this.setSize(500, 500);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Chap1308();
	}
}
