package practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import practice.Chap1002.MyMouseListener;

public class Chap1003 extends JFrame {
	JLabel label = new JLabel("Love JAVA");
	public Chap1003() {
		this.setTitle("Ű���� �̺�Ʈ ���� ���Դϴ�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(label);
		
		label.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					String labelTxt = label.getText();// �� ������ ���
					StringBuffer sb = new StringBuffer(labelTxt);//���� �迭�� ������
					//System.out.println(sb.reverse());//reverse �ݴ�� �б�
					String reversedTxt = sb.reverse().toString();//reverse�� StringBuffer�� �����ϱ� ������ toString() ����� string�� ���� �� �ִ�
					label.setText(reversedTxt);
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
		new Chap1003();
	}

}
