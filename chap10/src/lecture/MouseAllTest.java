package lecture;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseAllTest extends JFrame{
	private JLabel label = new JLabel();	
	//Container contentPane;//������ ���� �������� ����
	public MouseAllTest() {
		this.setTitle("Ű���� �̺�Ʈ ���� ���Դϴ�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		//contentPane.addKeyListener(new MyKeyListener());
		
		//�ΰ��� ���ÿ� ����Ҷ� / �ϳ��� ��� new MyMouseListener()�� ����ϸ� �ȴ�
		MyMouseListener myMouseListener = new MyMouseListener();
		contentPane.addMouseListener(myMouseListener);
		contentPane.addMouseMotionListener(myMouseListener);
		
		contentPane.setLayout(new FlowLayout());
		contentPane.add(label);
		
		this.setSize(300,300);
		this.setVisible(true);
				
	}
	// �ڹٴ� ���� ����� �ȵȴ� / interface�� ������ �ƴϰ� ����� ȿ���� ����
	class MyMouseListener implements MouseListener, MouseMotionListener {// �������̽��� ���� ��� ����

		@Override
		public void mouseDragged(MouseEvent e) { // ���콺 ���� ���·� �̵���
			label.setText("dragged("+e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {// ������ �ʰ� �̵��ÿ�
			label.setText("moved("+e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getClickCount());// ���콺 Ŭ���� �����Ͽ� Ŭ�� ������ ���� ī��Ʈ�� �þ��
			Container contentPane = (Container)e.getSource();
			if(e.getClickCount()==2) { // ���� Ŭ���� ���� �� ��ȯ
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				contentPane.setBackground(new Color(r,g,b));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {// ���콺�� �������� 
			label.setText("pressed("+e.getX()+","+e.getY()+")"); //pressed �� ���콺 Ŭ���� ���� ��ǥ 
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {// ���콺�� ������ ������
			label.setText("Released("+e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseEntered(MouseEvent e) {// ���콺 Ŀ���� ������ ������ �����ϴ� ����
//			System.out.println(e.getSource());// getSource obj�� ���� �Ѵ�
			// �������� ���� ����Ҷ� �Ʒ� �ΰ����� ���
			Container contentPane = (Container)e.getSource();
			getContentPane().setBackground(Color.YELLOW);
			//contentPane.setBackground(Color.YELLOW);  // ���������� ����Ҷ� ����ϴ� ��� 
		}

		@Override
		public void mouseExited(MouseEvent e) {// ���콺 Ŀ���� �ѹ� ������ �ȿ� �� �� ���� ���ö�
			//contentPane.setBackground(Color.ORANGE); 
		} 
		
	}

	public static void main(String[] args) {
		new MouseAllTest();
	}

}
