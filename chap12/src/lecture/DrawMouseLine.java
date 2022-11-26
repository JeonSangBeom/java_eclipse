package lecture;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawMouseLine extends JFrame {
	private DrawPanel drawPanel= new DrawPanel();
	public DrawMouseLine() {
		this.setTitle("�׸��׸���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(drawPanel); 

		this.setSize(300,300);
		this.setVisible(true);
	}
	
	class DrawPanel extends JPanel {
		//���� ��ǥ ������ �ֱ�  - Point=��ǥ�� ����ִ� ��ü(�ڹ� �⺻ ����)
		private Vector<Point> startVec = new Vector<>();
		private Vector<Point> endVec = new Vector<>();
		public DrawPanel() {// ������ ���� �� �̺�Ʈ ���̱�
			//���콺 �̺�Ʈ�� �̿��Ͽ� ���� �׸���
			this.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					//�̰��� �ι�° ��ǥ�� ���.
					Point endPoint = e.getPoint();
					endVec.add(endPoint);
					repaint();// ���� �ٽ� ȣ�����ش� / ����� (�������� �������)
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					//�̰��� ù��° ��ǥ�� ���.
					Point startPoint = e.getPoint();// ���� ��Ƶ� ����Ʈ �־�α�
					startVec.add(startPoint);
				}
				
				@Override
				public void mouseExited(MouseEvent e) {}				
				@Override
				public void mouseEntered(MouseEvent e) {}				
				@Override
				public void mouseClicked(MouseEvent e) {}
			});
		}
		//�׸��׸��� �޼���
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			for(int i=0;i<startVec.size();i++) {
				Point startPoint = startVec.elementAt(i); //����Ʈ ���� ������ �ֱ�
				Point endPoint = endVec.elementAt(i);
				//System.out.println(startPoint.getX());
				//System.out.println(startPoint.getY());
				//Point���� Ÿ�� ������ ������ ����ȯ �ʿ�
				g.drawLine((int)startPoint.getX(),(int)startPoint.getY(),
						   (int)endPoint.getX(),(int)endPoint.getY());
			}
		}
	}
	public static void main(String[] args) {
		new DrawMouseLine();
	}
}



