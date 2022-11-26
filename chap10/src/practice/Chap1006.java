package practice;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Chap1006 extends JFrame {
	JLabel label = new JLabel("C");
	public Chap1006() {
		this.setTitle("Ű���� �̺�Ʈ ���� ���Դϴ�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		contentPane.add(label);
		label.setSize(20,20); // null�� ��� ũ�Ⱑ �������� �ʾ� ����� ������ �־� �Ѵ�
		label.setLocation(50,50);
		label.setFont(new Font("Colonna MT",Font.BOLD,24)); // ��Ʈ �����ϴ� ���
		// label�� ���콺�� Ŭ���� ��ġ �������� �̵�
		label.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int posX = (int)(Math.random()*300);
				int posY = (int)(Math.random()*300);
				label.setLocation(posX,posY);
			}
		});
		
		
		this.setSize(300,300);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Chap1006();
	}

}
