package practice;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Chap120602 extends JFrame {
	private ImgPanel imgPanel = new ImgPanel();

	public Chap120602() {
		this.setTitle("»ç°¢Çü¼± ±ß±â");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(imgPanel);

		this.setSize(300, 300);
		this.setVisible(true);
	}
	class ImgPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int w = this.getWidth();
			int h=  this.getHeight();
			int wGap = w/10;
			int hGap = h/10;
			System.out.println(h);
			System.out.println(w);
			for(int i=1;i<10;i++) {
				g.drawLine(i*wGap, 0, i*wGap, h);//(ÁÂÇ¥ , ³ÐÀÌ(¼±±ß±â))
				
			}
			for(int i=1;i<10;i++) {
				g.drawLine(0, hGap*i, w,hGap*i);
			}
		}
	}
	public static void main(String[] args) {
		new Chap120602();
	}
}
