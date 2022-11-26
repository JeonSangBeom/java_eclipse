package practice;
//gride 사용
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Chap0903 extends JFrame {
	
	public Chap0903() {
		//선언과 동시에 실행되는 함수
		this.setTitle("Grid");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(1,10));// 한줄에 10칸
		
		//JButton을 열개 담는 배열 만들기
		JButton btns[] = new JButton[10];
		int total = btns.length;
		for(int i=0;i<total;i++) {
			btns[i] = new JButton(Integer.toString(i+1));// JButton()이 안에는 무조건 String만 들어가야한다 (""+i)로도 사용 가능
			contentPane.add(btns[i]);
		}
		this.setSize(500,200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Chap0903();
	}
}





