package practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import practice.Chap1002.MyMouseListener;

public class Chap1004 extends JFrame {
	JLabel label = new JLabel("Love JAVA");
	public Chap1004() {
		this.setTitle("키보드 이벤트 연습 중입니다");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(label);
		
		label.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					String labelTxt = label.getText();// 글 변수에 담기
					String first = labelTxt.substring(0,1);//0번째 부터 1까지 - 첫글자
					String rest = labelTxt.substring(1);//나머지 0번 빼고 1부터 전부
					label.setText(rest.concat(first));//concat - 글자를 달때
					//왼쪽 이동키를 누를때 마다 첫글자가 제일 뒤로 가서 붙는다
					System.out.println(rest);
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					String labelTxt = label.getText();// 글 변수에 담기
					int last = labelTxt.length()-1;
					label.setText(labelTxt.substring(last)+labelTxt.substring(0, last));
					//오른쪽 이동키를 누를때 마다 마지막글자가 제일 앞으로 가서 붙는다
					
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
		new Chap1004();
	}

}
