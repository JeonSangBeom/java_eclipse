package practice;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Chap1002 extends JFrame {
	public Chap1002() {
		this.setTitle("키보드 이벤트 연습 중입니다");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		
		MyMouseListener mouse = new MyMouseListener();
		contentPane.addMouseListener(mouse);
		contentPane.addMouseMotionListener(mouse);
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter{
		public void mouseDragged(MouseEvent e) {
			Container contentPane = (Container) e.getSource();
			contentPane.setBackground(Color.GREEN);
		}
		public void mouseReleased(MouseEvent e) {
			Container contentPane = (Container) e.getSource();
			contentPane.setBackground(Color.YELLOW);
		}
	}
	public static void main(String[] args) {
		new Chap1002();
	}

}
