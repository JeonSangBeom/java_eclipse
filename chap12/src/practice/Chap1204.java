package practice;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chap1204 extends JFrame {
	private ImgPanel imgPanel= new ImgPanel();

	public Chap1204() {
		this.setTitle("�׷����̿�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(imgPanel);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}

	

	class ImgPanel extends JPanel {
		private ImageIcon imgIcon = new ImageIcon("images/apple.png");// �̹��� �ҷ�����
		private Image img = imgIcon.getImage();//�̹����� �̱�
		private int w;
		private int h;
		private int posX = 100;
		private int posY = 100;
		public ImgPanel() {
			w = img.getWidth(this);// ���� ���� ���� �־��ֱ� ������
			h = img.getHeight(this);
			//System.out.println(w+"==="+h); //32 === 32 ���
			
			//�̺�Ʈ �ɱ�
			MyMouseListener listener = new MyMouseListener();
			this.addMouseListener(listener);
			this.addMouseMotionListener(listener);
		}
		//�׸� �׸���
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,posX,posY,w,h,this);// �̹��� �׸���(�̹��� , ��ǥ, ũ��, ���⿡��ĵǥ��)
		}
		class MyMouseListener extends MouseAdapter { // private�� ������ ���� innerŬ������ ȭ�椷
			private Point pressedPoint;
			private boolean isDrag = false;			
			
			public void mousePressed(MouseEvent e) {//������ ����
				pressedPoint = e.getPoint();//��ǥ ��������
				//�׸� �簢�� ��ǥ �� ���ǿ� �����Ǵ� �ڵ�
				if(posX  <= pressedPoint.x && posX+w  >= pressedPoint.x &&  
				   posY  <= pressedPoint.y && posY+h  >= pressedPoint.y) {
					isDrag= true;// �簢�� �ȿ� ���� ��� ���� ���� �ȴ�
				}
			}

			public void mouseReleased(MouseEvent e) {
				JPanel panel = (JPanel) e.getSource();
				Point mousePoint = e.getPoint();
				repaint();
				isDrag=false;// ���콺�� ���� false�� �صα� / �׷��� �̵��� �ȵȴ�
			
			}

			public void mouseDragged(MouseEvent e) {
				if(isDrag==false) return;// false��� ����(�簢�� ���� �ƴϸ�)
				Point mousePoint  = e.getPoint(); // ���콺 ��ǥ �� ������
				posX = posX+mousePoint.x - pressedPoint.x;
				posY = posY+mousePoint.y - pressedPoint.y;
				pressedPoint = mousePoint; // �ƴϸ� ���� ��� ������ �Ǿ� ������ ����
				repaint();
			}
		}
	}

	public static void main(String[] args) {
		new Chap1204();
	}
}
