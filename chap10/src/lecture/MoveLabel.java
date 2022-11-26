package lecture;
//�����¿�Ű ����
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import lecture.ChangeBg.MyKeyListener;

public class MoveLabel extends JFrame {
	//JLabel�� �ϳ������ ������ hello�� ä���
	//�����¿�Ű�� ������ 10px�ش��ϴ� Ű������ �����̱�
	//contentPane�� ���̰� null�� layout���� �� ���� keyAdapter�� ����Ͽ� ������ ����
	private JLabel label = new JLabel("HELLO");
	public MoveLabel() {
		this.setTitle("Ű���� �̺�Ʈ ���� ���Դϴ�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.addKeyListener(new MyKeyListener());
		contentPane.setLayout(null);
		contentPane.add(label);
		label.setLocation(50,50);
		label.setSize(100,20);
		
		this.setSize(300,300);
		this.setVisible(true);
				
		//Ű���� ������ ���� ��Ŀ�� �޾ƿ���
		contentPane.setFocusable(true);
		contentPane.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_LEFT: // �������� ȭ��ǥ �̵���
				label.setLocation(label.getX() - 10, label.getY());
				break; // ���ҽ� ������ �ʾƼ� �ٸ� ������ ����� �� ����
			case KeyEvent.VK_RIGHT: // ���������� ȭ��ǥ �̵���
				label.setLocation(label.getX() + 10, label.getY());
				break;
			case KeyEvent.VK_UP: // �������� ȭ��ǥ �̵���
				label.setLocation(label.getX(), label.getY() - 10); // ����� �����̶� - �� ���
				break;
			case KeyEvent.VK_DOWN: // �Ʒ������� ȭ��ǥ �̵���
				label.setLocation(label.getX(), label.getY() + 10);
				break;
			}		
		}
	}
	public static void main(String[] args) {
		new MoveLabel();
	}
	
}
