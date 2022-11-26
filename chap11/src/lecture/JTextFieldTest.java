package lecture;
//텍스트 필드 연습
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextFieldTest extends JFrame {
	public JTextFieldTest() {
		this.setTitle("텍스트 필드 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JLabel("이름"));
		contentPane.add(new JTextField("이름을 쓰세요.",20)); // 20 - 크기 지정 20자 정도 쓰겠다
		contentPane.add(new JLabel("학과"));
		contentPane.add(new JTextField("학과를 쓰세요.",20));
		contentPane.add(new JLabel("주소"));
		contentPane.add(new JTextField("주소를 쓰세요",20));
		
		contentPane.add(new JScrollPane(new JTextArea("나는 거위의 꿈을 꾸었어요...",5,23)) );//5줄에 23문자
		//JTextArea - 넓은 텍스트 창  JScrollPane - 텍스트가 화면을 넘어갈때 스크롤 생성
		
		this.setSize(280,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JTextFieldTest();
	}
}






