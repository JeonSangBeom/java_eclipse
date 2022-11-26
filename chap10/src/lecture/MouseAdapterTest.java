package lecture;
//MouseAdapterTest // ���� ����Ҷ� ���
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class MouseAdapterTest extends JFrame {
	private JLabel label = new JLabel("HELLO");
	public MouseAdapterTest() {
		this.setTitle("�������� Ŭ������ �����Ѵ� �̺�Ʈ ������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		//panel�� �־��ֱ�
		contentPane.addMouseListener(new MyMouseAdapter());
		contentPane.add(label);
		label.setSize(50,30);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	
	// ����� �޾� ����ϰ� ��ü�� ������ �ʿ䰡 ��������
	class MyMouseAdapter extends MouseAdapter {				
		//�̺�Ʈ�� �߻��ϴ� ����(��������)
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			label.setLocation(x, y);//label
		}
		
	}
	public static void main(String[] args) {
		new MouseAdapterTest();
	}
}
