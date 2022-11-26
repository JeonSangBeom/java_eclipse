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
	private Image img = bg.getImage();// 이미지 불러온 것 넣어두기
	private Vector<Point> snowVec = new Vector<>();//눈 넣을 공간
	private final int SNOW_AMOUNT = 50;//상수(변하지 않는값)는 대문자로 쓰는 것이 관례이다 / 눈의 양
	private final int SNOW_RADIUS = 20;
	
	//패널 시작
	public SnowPanel() {
		this.setPreferredSize(new Dimension(1280, 905));
		SnowThread snowTh = new SnowThread();
		addSnow();//눈 추가
		repaint();//다시 그림 그리기(위치 값이 변경될때 사용)
		snowTh.start();
	}
	//이미지 그리기
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);//이미지 그리기
		//눈 설정 및 그리기
		for (int i = 0; i < snowVec.size(); i++) {
			g.setColor(Color.WHITE);
			Point point = snowVec.get(i);
			//int radius = (int)(Math.random()*10+10);
			g.fillOval(point.x, point.y, SNOW_RADIUS, SNOW_RADIUS);
		}
	}
	
	//눈 생성 위치 및 50개 생성
	private void addSnow() {
		for (int i = 0; i < SNOW_AMOUNT; i++) {
			//위치 랜덤
			int loadX = (int) (Math.random() * 1280);
			int loadY = (int) (Math.random() * 905);
			Point point = new Point(loadX, loadY);
//			System.out.println(this.getWidth());
			snowVec.add(point);//vectero
		}
	}
	//눈 이동 스레드
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
					if(point.y>925) {//point의 위치가 925보다 크면(패널을 넘어가면)
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
		this.setTitle("눈만들기");
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
