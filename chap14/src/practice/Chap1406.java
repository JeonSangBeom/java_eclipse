package practice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Chap1406 extends JFrame {
	Chap1406() {
		this.setTitle("학번 찾기(경고창 사용)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();		
		JToolBar toolBar = new JToolBar();
		JLabel label = new JLabel("학번");
		JTextField tf = new JTextField(10);
		toolBar.add(label);
		toolBar.add(tf);
		contentPane.add(toolBar, BorderLayout.SOUTH);
		tf.addKeyListener(new MyKeyListener());
		
		this.setSize(500, 300);
		this.setVisible(true);
	}
	class MyKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			//System.out.println(e.getKeyChar());// 숫자 얻어오기
			if(e.getKeyChar() < '0' || e.getKeyChar() > '9') {
				//숫자가 아닌 것을 뜻한다
				String msg = Character.toString(e.getKeyChar());//글자로 변형
				JOptionPane.showMessageDialog(
						null, msg+"는 숫자가 아닙니다","alert",JOptionPane.ERROR_MESSAGE);
				e.consume();// 조건 만족이 아닐 경우 입력이 안된다
			}
		}
		@Override
		public void keyPressed(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {}
		
	}

	public static void main(String[] args) {
		new Chap1406();
	}
}
