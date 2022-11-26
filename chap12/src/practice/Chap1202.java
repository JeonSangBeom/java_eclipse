package practice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chap1202 extends JFrame {
	private ImgPanel imgPanel = new ImgPanel();

	public Chap1202() {
		this.setTitle("�׸� �׸���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(imgPanel);

		this.setSize(300, 300);
		this.setVisible(true);
	}

	class ImgPanel extends JPanel {
		private ImageIcon imgIcon = new ImageIcon("images/jun.jpg");
		private Image img = imgIcon.getImage();
		private int ovalX, ovalY;

		public ImgPanel() {
			this.addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseMoved(MouseEvent e) {
				}

				@Override
				public void mouseDragged(MouseEvent e) { // ���� ���� �̵�
					ovalX = e.getX()-10;
					ovalY = e.getY()-10;
					//-10 ���� - Ŀ�� ��ġ ���߱� ����
					repaint();
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.setColor(new Color(0, 255, 0, 255));
			g.fillOval(ovalX, ovalY, 20, 20);// �� �׸���
		}
	}

	public static void main(String[] args) {
		new Chap1202();
	}
}
