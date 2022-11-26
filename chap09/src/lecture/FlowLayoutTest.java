package lecture;
//FlowLayout 사용법 - 흘러가는 배치
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutTest extends JFrame {
	public FlowLayoutTest() {
		//기본세팅
		this.setSize(500, 300);// 가로 세로
		this.setVisible(true);//보이게
		this.setTitle("FLOW LAYOUT 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();// 기본
		contentPane.setLayout(new FlowLayout());//FlowLayout 이걸로 배치 / 흘러가는 배치 
		contentPane.add(new JButton("add"));
		contentPane.add(new JButton("subtract"));
		contentPane.add(new JButton("multiply"));
		contentPane.add(new JButton("divide"));
		contentPane.revalidate();//재검증하다 ->이것만 사용하여도 바로 뜸
		contentPane.repaint();//재칠하다 - > 버튼이 바로 활성화 되지 않을때 사용
		
	}
	public static void main(String[] args) {
		FlowLayoutTest flowLayout = new FlowLayoutTest();
	}
}
