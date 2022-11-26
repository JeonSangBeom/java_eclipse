package lecture;
//사각형 그리기
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintPanelTest02 extends JFrame {
	private MyPanel myPanel = new MyPanel();
	public PaintPanelTest02() {
		this.setTitle("그림 그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(myPanel); 
		// 기존 JFrame이 가지고 있는 Container(Panel)늘 내가 만든 MyPanel로 바꾸겠다
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawRect(10,10,50,50);// 사각형 그리기 좌표,크기
			g.setColor(Color.RED);
			g.drawRect(50,50,50,50);
			g.setColor(Color.GREEN);
			g.drawRect(90,90,50,50);
		}
	}
	
	public static void main(String[] args) {
		new PaintPanelTest02();
	}

}
