package lecture;
//KeyListenerTest 사용법
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import lecture.MouseAdapterTest.MyMouseAdapter;

public class KeyListenerTest extends JFrame {
	private JLabel messages[];
	public KeyListenerTest() {
		this.setTitle("키이벤트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());		
		contentPane.addKeyListener(new MyKeyListener());//contentPane에 Listener을 달아 놓은 것
		messages = new JLabel[3];
		messages[0] = new JLabel("getKeyCode()");
		messages[1] = new JLabel("getKeyChar()");
		messages[2] = new JLabel("getKeyText()");
		for(int i=0;i<3;i++) {
			contentPane.add(messages[i]);
			messages[i].setSize(800,50);
			messages[i].setOpaque(false);
			messages[i].setBackground(Color.WHITE);
		}
		
		
		this.setSize(500,500);
		this.setVisible(true);
		//포커스를 받을 수 있는 존재로 만들때
		contentPane.setFocusable(true);// 이제부터 포커스를 받게 해주겠다
		contentPane.requestFocus();
	}
	//리스너를 달아서 이벤틀르 받을 수 있다. 이때 
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();// 특수 기호를 알고 싶을때 이용 / 숫자로 나타나서 알 수 있다
			char keyChar = e.getKeyChar();// 키보드 알파벳으로 알고 사용하고 싶을때 사용
			messages[0].setText(Integer.toString(keyCode));
			messages[1].setText(Character.toString(keyChar));
			messages[2].setText(e.getKeyText(keyCode)); // 키보드에 있는 그대로 가져온다 / 잘 안씀
		}
		
	}
	public static void main(String[] args) {
		new KeyListenerTest();
	}
	

}
