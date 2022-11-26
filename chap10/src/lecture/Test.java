package lecture;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends JFrame {

	public Test() {
		this.setTitle("독립적인 클래스로 존재한느 이벤트 리스너");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		JButton btn01 = new JButton("CLICK");
		JButton btn02 = new JButton("CLOSE");
		JButton btn03 = new JButton("OPEN");
		btn01.addActionListener(new MyActionListener());
		// btn02.addActionListener(new MyActionListener());
		// btn03.addActionListener(new MyActionListener());

		contentPane.add(btn01);
		contentPane.add(btn02);
		contentPane.add(btn03);

		this.setSize(300, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Test(); // independentClassListener에서 만들어둔 클래스 덕에 똑같이 사용 가능
	}
}
