package practice;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chap1205 extends JFrame {
	private ImgPanel imgPanel = new ImgPanel();

	public Chap1205() {
		this.setTitle("그림그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(imgPanel);

		this.setSize(300, 300);
		this.setVisible(true);
	}
	class ImgPanel extends JPanel {
		private ImageIcon imgIcon = new ImageIcon("images/apple.png");
		private Image img = imgIcon.getImage();
		private int w;
		private int h;
		public ImgPanel() {
			w = img.getWidth(this);
			h = img.getWidth(this);
			//키를 받을때 사용
			this.setFocusable(true);
			this.requestFocus();
			
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ADD || e.getKeyChar()=='+') {// 키보드에 있는 + 키가 적용되게 하기 위해 두가지 방법 함께 사용
						w = (int)(w*1.1);//10% 커지게
						h = (int)(h*1.1);
						System.out.println("aaa");
						repaint();
					} else if(e.getKeyCode()==KeyEvent.VK_SUBTRACT || e.getKeyChar()=='-') {
						w = (int)(w*0.9);//10% 작아지게
						h = (int)(h*0.9);
						System.out.println("bbb");
						repaint();
					}
				}
			});
		}
		//이미지 그려주기
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,10,10,w,h,this);
		}
	}
	public static void main(String[] args) {
		new Chap1205();
	}
}







