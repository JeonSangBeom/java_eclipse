package practice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chap1207 extends JFrame {
	private ImgPanel imgPanel = new ImgPanel();

	public Chap1207() {
		this.setTitle("���콺�� �׸���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(imgPanel);
		
		this.pack();//�����ϴ� ��
		this.setVisible(true);
		
	}
	class ImgPanel extends JPanel {
		//������ ���� vector �̿�
		private Vector<Integer> mouseXvec = new Vector<>();
		private Vector<Integer> mouseYvec = new Vector<>();
		public ImgPanel() {
			this.setPreferredSize(new Dimension(300,300));
			///���콺 �̺�Ʈ
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					//�߰����ֱ�
					mouseXvec.add(e.getX());
					mouseYvec.add(e.getY());
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {			
			super.paintComponent(g);
			g.setColor(Color.RED);
			int posX[] = new int[mouseXvec.size()];
			int posY[] = new int[mouseYvec.size()];
			for(int i=0;i<mouseXvec.size();i++) {
				posX[i] = mouseXvec.get(i);
				posY[i] = mouseYvec.get(i);
			}
			g.fillPolygon(posX,posY,posX.length);
		}
	}
	public static void main(String[] args) {
		new Chap1207();
	}
}
