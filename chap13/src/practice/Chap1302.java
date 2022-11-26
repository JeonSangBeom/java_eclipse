package practice;
//마우스 클릭시 생성된 원이 위치 랜덤하게 이동
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class CirclePanel extends JPanel implements Runnable {
	private int x =	100;
	private int y =	100;
	private Thread th; // Runnable을 구현한거라 바로 사용할 수 없어 이렇게 사용
	public CirclePanel() {
		th = new Thread(this);
		//th.start();
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				th.start();
			}
		});
	}
	//계속 그리게 반복해주기
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(300);
				x = (int)(Math.random()*getWidth()); 
				y = (int)(Math.random()*getHeight());
				repaint();//새로 그려주기
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//그림 그리기 (원)
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//JPanel 초기화
		g.setColor(Color.MAGENTA);
		g.fillOval(x, y, 100, 100);
	}
}

public class Chap1302 extends JFrame {
	public Chap1302() {
		this.setTitle("Thread 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new CirclePanel());
		
		this.setSize(500,500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Chap1302();
	}
}
