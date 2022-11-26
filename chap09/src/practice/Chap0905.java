package practice;
//GridLayout
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Chap0905 extends JFrame {
	public Chap0905() {
		this.setTitle("Grid");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(4,4));
		
		JButton btns[] = new JButton[16];
		int total = btns.length;
		for(int i=0;i<total;i++) {
			btns[i] = new JButton(Integer.toString(i));
			btns[i].setOpaque(true);
			int r =  (int)(Math.random()*256);// ������ �������� ���ֱ�
			int g =  (int)(Math.random()*256);
			int b =  (int)(Math.random()*256);
			btns[i].setBackground(new Color(r,g,b));// ������ ���� ���
			btns[i].setForeground(new Color(255,255,255));// ���ڻ�
			btns[i].setBorderPainted(false); // �׵θ� ���ֱ�
//			btns[i].setContentAreaFilled(false); // ���뿵�� ���ֱ�
			contentPane.add(btns[i]);
		}
		
		this.setSize(500,200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Chap0905();
	}
}
