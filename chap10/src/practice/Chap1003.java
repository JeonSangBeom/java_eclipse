package practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import practice.Chap1002.MyMouseListener;

public class Chap1003 extends JFrame {
	JLabel label = new JLabel("Love JAVA");
	public Chap1003() {
		this.setTitle("키보드 이벤트 연습 중입니다");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(label);
		
		label.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					String labelTxt = label.getText();// 글 변수에 담기
					StringBuffer sb = new StringBuffer(labelTxt);//문자 배열로 나누기
					//System.out.println(sb.reverse());//reverse 반대로 읽기
					String reversedTxt = sb.reverse().toString();//reverse는 StringBuffer를 리턴하기 때문에 toString() 써줘야 string로 받을 수 있다
					label.setText(reversedTxt);
				}
			}
		});
		
		//MyMouseListener mouse = new MyMouseListener();
		//contentPane.addMouseListener(mouse);
		//contentPane.addMouseMotionListener(mouse);
		
		this.setSize(300,300);
		this.setVisible(true);
		
		label.setFocusable(true);
		label.requestFocus();
	}
	public static void main(String[] args) {
		new Chap1003();
	}

}
