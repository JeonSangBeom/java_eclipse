package practice;
//���콺 Ŭ���� ������ ���� ��ġ �����ϰ� �̵�
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class CirclePanel extends JPanel implements Runnable {
	private int x =	100;
	private int y =	100;
	private Thread th; // Runnable�� �����ѰŶ� �ٷ� ����� �� ���� �̷��� ���
	public CirclePanel() {
		th = new Thread(this);
		//th.start();
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				th.start();
			}
		});
	}
	//��� �׸��� �ݺ����ֱ�
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(300);
				x = (int)(Math.random()*getWidth()); 
				y = (int)(Math.random()*getHeight());
				repaint();//���� �׷��ֱ�
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//�׸� �׸��� (��)
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//JPanel �ʱ�ȭ
		g.setColor(Color.MAGENTA);
		g.fillOval(x, y, 100, 100);
	}
}

public class Chap1302 extends JFrame {
	public Chap1302() {
		this.setTitle("Thread ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new CirclePanel());
		
		this.setSize(500,500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Chap1302();
	}
}
