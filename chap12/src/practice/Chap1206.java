package practice;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Chap1206 extends JFrame {
	private ImgPanel imgPanel = new ImgPanel();

	public Chap1206() {
		this.setTitle("마름모 그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(imgPanel);
		
		//this.setSize(300, 300);// 상단바 포함 300이기 때문에 정사각형이 될 수 없다
		//this.setResizable(false); // 사이즈 못 바꾸게 하는 것
		//this.setLocationRelativeTo(null); // 무조건 중앙에 생성
		this.pack();
		this.setVisible(true);
		
	}
	class ImgPanel extends JPanel {
		ImgPanel() {
			this.setPreferredSize(new Dimension(300,300));// 정사각형을 만들기 위해선 이렇게 사용 기본 프레임쪽에 pack()입력 필수
		}
		
		public void paintComponent(Graphics g) {			
			super.paintComponent(g);
			int posX[] = new int[4];
			int posY[] = new int[4];
			int w = this.getWidth();
			int h=  this.getHeight();
			//마름모 그릴때 조건 만들어두기
			posX[0] =  w/2;
			posX[1] =  0;
			posX[2] =  w/2;
			posX[3] =  w;
			
			posY[0] =  0;
			posY[1] =  h/2;
			posY[2] =  h;
			posY[3] =  h/2;
			for(int i=0;i<10;i++) {
				//10번 반복하며 계속 중첩으로 계산이 되어 10개의 마름모 생성 가능
				posY[0] = posY[0] + 10;
				posX[1] = posX[1] + 10;
				posY[2] = posY[2] - 10;
				posX[3] = posX[3] - 10;
				g.drawPolygon(posX,posY,4);
			}
		}
	}
	public static void main(String[] args) {
		new Chap1206();
	}
}
