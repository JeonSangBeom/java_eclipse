package practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Chap1005 extends JFrame {
	JLabel label = new JLabel("Love JAVA");
	public Chap1005() {
		this.setTitle("키보드 이벤트 연습 중입니다");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(label);
		label.setFont(new Font("Colonna MT",Font.BOLD,24)); // 폰트 설정하는 방법
		
		label.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ADD) {
					String labelTxt = label.getText();// 글 변수에 담기
					Font font = label.getFont();// 폰트 얻어오기
					int size = font.getSize();
					if(size>36) return;// 36 까지만 커지기
					label.setFont(new Font("Noto Sans KR",Font.BOLD,size+1));
				}
				if(e.getKeyCode()==KeyEvent.VK_SUBTRACT) {
					String labelTxt = label.getText();// 글 변수에 담기
					Font font = label.getFont();// 폰트 얻어오기
					int size = font.getSize();
					if(size<8) return;// 8 아래로만 작아지기
					label.setFont(new Font("Noto Sans KR",Font.BOLD,size-1));
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
		new Chap1005();
	}

}
