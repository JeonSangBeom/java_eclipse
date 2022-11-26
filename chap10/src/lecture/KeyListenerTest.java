package lecture;
//KeyListenerTest ����
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import lecture.MouseAdapterTest.MyMouseAdapter;

public class KeyListenerTest extends JFrame {
	private JLabel messages[];
	public KeyListenerTest() {
		this.setTitle("Ű�̺�Ʈ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());		
		contentPane.addKeyListener(new MyKeyListener());//contentPane�� Listener�� �޾� ���� ��
		messages = new JLabel[3];
		messages[0] = new JLabel("getKeyCode()");
		messages[1] = new JLabel("getKeyChar()");
		messages[2] = new JLabel("getKeyText()");
		for(int i=0;i<3;i++) {
			contentPane.add(messages[i]);
			messages[i].setSize(800,50);
			messages[i].setOpaque(false);
			messages[i].setBackground(Color.WHITE);
		}
		
		
		this.setSize(500,500);
		this.setVisible(true);
		//��Ŀ���� ���� �� �ִ� ����� ���鶧
		contentPane.setFocusable(true);// �������� ��Ŀ���� �ް� ���ְڴ�
		contentPane.requestFocus();
	}
	//�����ʸ� �޾Ƽ� �̺�Ʋ�� ���� �� �ִ�. �̶� 
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();// Ư�� ��ȣ�� �˰� ������ �̿� / ���ڷ� ��Ÿ���� �� �� �ִ�
			char keyChar = e.getKeyChar();// Ű���� ���ĺ����� �˰� ����ϰ� ������ ���
			messages[0].setText(Integer.toString(keyCode));
			messages[1].setText(Character.toString(keyChar));
			messages[2].setText(e.getKeyText(keyCode)); // Ű���忡 �ִ� �״�� �����´� / �� �Ⱦ�
		}
		
	}
	public static void main(String[] args) {
		new KeyListenerTest();
	}
	

}
