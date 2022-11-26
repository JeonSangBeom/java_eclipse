package lecture;
//button 연습 - 이미지
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest extends JFrame {
	public JButtonTest() {
		this.setTitle("button 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//텍스트 버튼
		JButton txtButton = new JButton("I LOVE JAVA;");
		//이미지 버튼
		JButton imgButton = new JButton(new ImageIcon("images/phone.png")); // 한번에 쓰는 방법
		//테두리 없앨때 입력할 값 네가지
		imgButton.setBorderPainted(false);// 테두리 없앨때
		imgButton.setContentAreaFilled(false);// 테두리 안 내부 여백
		imgButton.setFocusPainted(false);// 포커스 됐을때 보이는 버튼
		imgButton.setOpaque(false);// 안보이게
		
		imgButton.setRolloverIcon(new ImageIcon("images/phone_over.png"));//마우스 가져다 대면 바뀌게 설정
		imgButton.setPressedIcon(new ImageIcon("images/phone_press.png"));//클릭시 변경
		
		
		contentPane.add(txtButton);
		contentPane.add(imgButton);
		
		
		this.setSize(300, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JButtonTest();
	}
}
