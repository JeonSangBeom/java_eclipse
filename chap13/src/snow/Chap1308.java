package snow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

////////////
class Snow extends JLabel {
	private final int SNOW_RADIUS = 20;
	private int x;
	private int y;
	private int radius;
	private Color color;
	
	Snow(int x,int y, int radius,Color color) {
		this.x=x;
		this.y=y;
		this.radius=radius;
		this.color = color;
		repaint();
	}
	//이미지 그리기
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.drawOval(x, y, radius, radius);
	}
}
///////////////////
class SnowPanel extends JPanel {
	private ImageIcon bg = new ImageIcon("images/winter.png");
	private Image img = bg.getImage();//이미지 불러서 넣어두기(이미지만 가져올수 있게)
	private Vector<Snow> snowVec = new Vector<>();// 눈 담을 vector 만들기
	private final int SNOW_AMOUNT = 50; //상수(변하지 않는 값)는 대문자 쓰는게 관례
	
	//실행 되는 곳
	public SnowPanel() {
		this.setPreferredSize(new Dimension(1280, 905));
		//SnowThread snowTh = new SnowThread();
		//add(new Snow(100,100,20,Color.BLACK));
		addSnow();
		//repaint();
//		snowTh.start();
	}
	//이미지 그리기
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);//this - 목적어(누구한테 알려줄거냐)
		for (int i = 0; i < snowVec.size(); i++) {
			//g.setColor(Color.WHITE);
			//Point point = snowVec.get(i);
			//int radius = (int)(Math.random()*10+10);
			//g.fillOval(point.x, point.y, SNOW_RADIUS, SNOW_RADIUS);
		}
	}
	//눈 추가
	private void addSnow() {
		for (int i = 0; i < SNOW_AMOUNT; i++) {
			Snow snow = new Snow(100+10*i,100,10, Color.BLACK);
			snowVec.add(snow);
			this.add(snow);
		}
	}
	//눈 내리기
	class SnowThread extends Thread {
		public void run() {
			while(true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(int i=0;i<snowVec.size();i++) {

				}
				repaint();
			}
		}
	}
}
//////////////////
public class Chap1308 extends JFrame {
	public Chap1308() {
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
