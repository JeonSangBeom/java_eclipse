package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//퍼튼 패널
class BtnsPanel extends JPanel {
	public BtnsPanel() {
		this.setOpaque(true);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new FlowLayout());// 패널의 디폴트 값은 flow이다 굳이 안써도 됨 - 흘러가는 배치
		
		this.add(new JButton("열기"));
		this.add(new JButton("닫기"));
		this.add(new JButton("나가기"));
	}
}

//StarPanel
class StarPanel extends JPanel {
	public StarPanel() {
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setLayout(null);// 위치 임의 지정
		
		for(int i=0;i<10;i++) {
			JLabel label = new JLabel("*");//*생성
			label.setForeground(Color.RED);
			label.setSize(20, 20);
			int x = (int)(Math.random()*150+50);//50~200
			int y = (int)(Math.random()*100+50);//50~150
			label.setLocation(x, y);//위치지정
			this.add(label);
		}
	}
}

//InputPanel
class InputPanel extends JPanel {
	public InputPanel() {
		this.setOpaque(true);
		this.setBackground(Color.ORANGE);
		this.setLayout(new FlowLayout());
		
		this.add(new JButton("Word Input"));
		this.add(new JTextField(16));
	}
}


public class Chap0910 extends JFrame {
	public Chap0910() {
		this.setTitle("여러개의 패널을 가진 프레임");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		// 선언
		BtnsPanel btnsPanel = new BtnsPanel(); 
		StarPanel starPanel = new StarPanel();
		InputPanel inputPanel = new InputPanel();
		
		//메인 패널에 넣어주기
		contentPane.add(btnsPanel,BorderLayout.NORTH);
		contentPane.add(starPanel,BorderLayout.CENTER);
		contentPane.add(inputPanel,BorderLayout.SOUTH);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Chap0910();
	}

}
