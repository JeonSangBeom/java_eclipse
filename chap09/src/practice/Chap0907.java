package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chap0907 extends JFrame {
	public Chap0907() {
		this.setTitle("계산기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout()); // 기본패널(BorderLayout) - 동서남북 배치
		
		//northPanel
		JPanel northPanel = new JPanel();// JPanel 새로 만들기		
		northPanel.setLayout(new FlowLayout()); // 옆으로 나열해라
		northPanel.setOpaque(true);
		northPanel.setBackground(Color.LIGHT_GRAY);// 색상
		northPanel.add(new JLabel("수식입력"));
		northPanel.add(new JTextField(16)); // 입력란
		
		//centerPanel		
		JPanel centerPanel = new JPanel();//JPanel생성
		//계산식
		String marks[] = {"+","-","x","/"};		
		for(int i=0;i<4;i++) {
			JButton btns = new JButton(marks[i]);// String라 정수 변환이 필요 없다
			btns.setOpaque(true);
			btns.setBackground(Color.GREEN);
			centerPanel.add(btns);
		}
		//숫자
		centerPanel.setLayout(new GridLayout(4,4,5,5));//4칸 4줄 5공백 5공백
		for(int i=0;i<10;i++) { // 숫잦 넣기 / 크기는 본인이 알아서 설정이 되어 들어간다
			JButton btns = new JButton(Integer.toString(i));
			centerPanel.add(btns);
		}
		centerPanel.add(new JButton("CE"));
		centerPanel.add(new JButton("계산"));
		
	
		//southPanel
		JPanel southPanel = new JPanel();		
		southPanel.setLayout(new FlowLayout());
		southPanel.setOpaque(true);
		southPanel.setBackground(Color.ORANGE);
		southPanel.add(new JLabel("계산결과"));
		southPanel.add(new JTextField(16));
		
		//새로 추가된 패널을 기본 패널에 넣기
		contentPane.add(northPanel,BorderLayout.NORTH);
		contentPane.add(centerPanel,BorderLayout.CENTER);
		contentPane.add(southPanel,BorderLayout.SOUTH);
		
		this.setSize(300,300);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Chap0907();
	}
}
