package practice;
//JLabel ����� / �����ϰ� ��ġ
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Chap0906 extends JFrame {
	//panel 4
	//contentPane flowLayout
	public Chap0906() {
		this.setTitle("Grid");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		for(int i=0;i<20;i++) {
			JLabel label = new JLabel("");
			label.setOpaque(true);
			label.setBackground(new Color(255,0,0));
			//Math.random()*(max - min)+min 50~200 - �ִ� �ּҰ��� ��� ���� �� ����
			// �ִ밪 250�� ���ڿ��� 50,50���� 200,200 ���� ���ڷ� ����� ������
			int x = (int)(Math.random()*150)+50;
			int y = (int)(Math.random()*150)+50;
			label.setSize(10,10);
			label.setLocation(x,y); // ��ġ
			contentPane.add(label);
		}
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
		
	public static void main(String[] args) {
		new Chap0906(); 
	}

}
