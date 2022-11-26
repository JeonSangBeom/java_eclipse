package practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import practice.Chap1002.MyMouseListener;

public class Chap1004 extends JFrame {
	JLabel label = new JLabel("Love JAVA");
	public Chap1004() {
		this.setTitle("Ű���� �̺�Ʈ ���� ���Դϴ�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(label);
		
		label.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					String labelTxt = label.getText();// �� ������ ���
					String first = labelTxt.substring(0,1);//0��° ���� 1���� - ù����
					String rest = labelTxt.substring(1);//������ 0�� ���� 1���� ����
					label.setText(rest.concat(first));//concat - ���ڸ� �޶�
					//���� �̵�Ű�� ������ ���� ù���ڰ� ���� �ڷ� ���� �ٴ´�
					System.out.println(rest);
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					String labelTxt = label.getText();// �� ������ ���
					int last = labelTxt.length()-1;
					label.setText(labelTxt.substring(last)+labelTxt.substring(0, last));
					//������ �̵�Ű�� ������ ���� ���������ڰ� ���� ������ ���� �ٴ´�
					
				}
				
			}
		});
		
		//MyMouseListener mouse = new MyMouseListener();
		//contentPane.addMouseListener(mouse);
		//contentPane.addMouseMotionListener(mouse);
		
		this.setSize(300,300);
		this.setVisible(true);
		
		label.setFocusable(true);
		label.requestFocus();
	}
	public static void main(String[] args) {
		new Chap1004();
	}

}
