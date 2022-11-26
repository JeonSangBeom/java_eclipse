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
		this.setTitle("키보드 이벤트 연습 중입니다");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		contentPane.add(label);
		label.setSize(20,20); // null일 경우 크기가 정해지지 않아 사이즈를 설정해 둬야 한다
		label.setLocation(50,50);
		label.setFont(new Font("Colonna MT",Font.BOLD,24)); // 폰트 설정하는 방법
		// label을 마우스로 클릭시 위치 랜덤으로 이동
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
