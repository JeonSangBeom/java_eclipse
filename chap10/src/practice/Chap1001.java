package practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Chap1001 extends JFrame {
	JLabel label = new JLabel("Love JAVA");
	public Chap1001() {
		this.setTitle("키보드 이벤트 연습 중입니다");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(label);
		label.addMouseListener(new MouseAdapter() { // 바로 Adapter를 생성하여 사용하기
			public void mouseEntered(MouseEvent e) {
				label.setText("사랑해 자바");
			}
			public void mouseExited(MouseEvent e) {
				label.setText("Love sJAVA");
			}
		});
		
		this.setSize(300,300);
		this.setVisible(true);
				
	}
	public static void main(String[] args) {
		new Chap1001();
	}

}
