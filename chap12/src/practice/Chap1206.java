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
		this.setTitle("������ �׸���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(imgPanel);
		
		//this.setSize(300, 300);// ��ܹ� ���� 300�̱� ������ ���簢���� �� �� ����
		//this.setResizable(false); // ������ �� �ٲٰ� �ϴ� ��
		//this.setLocationRelativeTo(null); // ������ �߾ӿ� ����
		this.pack();
		this.setVisible(true);
		
	}
	class ImgPanel extends JPanel {
		ImgPanel() {
			this.setPreferredSize(new Dimension(300,300));// ���簢���� ����� ���ؼ� �̷��� ��� �⺻ �������ʿ� pack()�Է� �ʼ�
		}
		
		public void paintComponent(Graphics g) {			
			super.paintComponent(g);
			int posX[] = new int[4];
			int posY[] = new int[4];
			int w = this.getWidth();
			int h=  this.getHeight();
			//������ �׸��� ���� �����α�
			posX[0] =  w/2;
			posX[1] =  0;
			posX[2] =  w/2;
			posX[3] =  w;
			
			posY[0] =  0;
			posY[1] =  h/2;
			posY[2] =  h;
			posY[3] =  h/2;
			for(int i=0;i<10;i++) {
				//10�� �ݺ��ϸ� ��� ��ø���� ����� �Ǿ� 10���� ������ ���� ����
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
