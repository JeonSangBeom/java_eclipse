package lecture;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

class JCheckBoxTest extends JFrame {
	public JCheckBoxTest() {
		this.setTitle("체크박스 테스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		ImageIcon cherryIcon = new ImageIcon("images/lemon.png");
		
		//체크박스 생성 3가지 방식
		JCheckBox apple = new JCheckBox("사과");// 체크 안된 기본 상태
		JCheckBox berry = new JCheckBox("딸기",true);// 체크된 상태
		JCheckBox lemon = new JCheckBox("레몬",cherryIcon);// 체크 칸에 이미지 넣기
		
		contentPane.add(apple);
		contentPane.add(berry);
		contentPane.add(lemon);
		
		lemon.setBorderPainted(true);// 테두리 생성하여 음각 효과 보이게 하기
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JCheckBoxTest();
	}
}
