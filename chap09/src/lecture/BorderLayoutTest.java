package lecture;
//BorderLayout 동서남북 배치
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class BorderLayoutTest extends JFrame {
	public BorderLayoutTest() {
		this.setSize(500,500);
		this.setVisible(true);
		this.setTitle("BORDER LAYOUT TEST");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container contentPane = this.getContentPane(); // 기본 JPanel을 가져오기
		contentPane.setLayout(new BorderLayout(10,20)); // BorderLayout(Frame이 기본 패널) 동서남북 배치(여백만들기(수평,수직))
		
		contentPane.add(new JButton("add"),BorderLayout.NORTH);
		contentPane.add(new JButton("subtract"),BorderLayout.SOUTH);
		contentPane.add(new JButton("multiply"),BorderLayout.EAST);
		contentPane.add(new JButton("divide"),BorderLayout.WEST);
		contentPane.add(new JButton("calc"),BorderLayout.CENTER); // center은 기본이여서 굳이 안써도 된다(,BorderLayout.CENTER) - 이부분
		
		
	}
	public static void main(String[] args) {
		new BorderLayoutTest(); // 앞에 굳이 BorderLayoutTest 변수 = 안붙여도 된다;
	}
}





