package lecture;
//MouseEventListenerTest
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class MouseEventListenerTest extends JFrame {
	private JLabel label = new JLabel("HELLO");
	public MouseEventListenerTest() {
		this.setTitle("�������� Ŭ������ �����Ѵ� �̺�Ʈ ������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		//panel�� �־��ֱ�
		contentPane.addMouseListener(new MyMouseListener());
		contentPane.add(label);
		label.setSize(50,30);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	
	//Ŭ���� ����
	class MyMouseListener implements MouseListener {
		//�ܺο� ����Ͽ� �������̽��� �ҷ����� ������ 5���� �� �����Ͽ��� �Ѵ� �׷��� �ʰ� ������ �߻�Ŭ������ ����� ����Ͽ��� �Ѵ�
		//�Ⱦ��� �Ǹ� ����θ� �ȴ�
		@Override
		public void mouseClicked(MouseEvent e) {}
		//�̺�Ʈ�� �߻��ϴ� ����(��������)
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			label.setLocation(x, y);//label
		}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
	public static void main(String[] args) {
		new MouseEventListenerTest();
	}
}
