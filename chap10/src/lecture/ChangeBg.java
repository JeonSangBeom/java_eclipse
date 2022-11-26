package lecture;
import java.awt.Color;
//����� �缳��
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChangeBg extends JFrame {
	private JLabel label = new JLabel();
	Container contentPane;
	public ChangeBg() {
		this.setTitle("Ű���� �̺�Ʈ ���� ���Դϴ�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = this.getContentPane();
		contentPane.addKeyListener(new MyKeyListener());
		
		this.setSize(300,300);
		this.setVisible(true);
				
		//Ű���� ������ ���� ��Ŀ�� �޾ƿ���
		contentPane.setFocusable(true);
		contentPane.requestFocus();
	}

	class MyKeyListener extends KeyAdapter{//��� �޾� ���
//		f1Ű�� ������ ���� �ʷϻ�, %�� ������ ���� ��������� ����
		public void keyPressed(KeyEvent e) {
			System.out.println("char=="+e.getKeyChar());//Ű �� ���ڷ� �޾� ����
			System.out.println("code=="+e.getKeyCode());//Ű�� ���ڷ� �޾ƿ���
			if(e.getKeyChar()=='%') { // ���ڴ� '' �� ǥ�� / eqequals�� ��Ʈ�������� ���
				contentPane.setBackground(Color.YELLOW); // �÷� ������ �빮�ڷ� 
			}else if(e.getKeyCode()==KeyEvent.VK_F1) {// �⺻������ �����Ű���忡 �� �ִ� ���� ������ ����ϴ� ���(keyCode�θ� ��� ����)
				contentPane.setBackground(Color.GREEN);
			}
			
			
			
		}
	}
	
	public static void main(String[] args) {
		new ChangeBg();
	}
}
