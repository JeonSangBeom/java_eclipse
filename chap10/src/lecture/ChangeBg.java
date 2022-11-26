package lecture;
import java.awt.Color;
//어댑터 재설명
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChangeBg extends JFrame {
	private JLabel label = new JLabel();
	Container contentPane;
	public ChangeBg() {
		this.setTitle("키보드 이벤트 연습 중입니다");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = this.getContentPane();
		contentPane.addKeyListener(new MyKeyListener());
		
		this.setSize(300,300);
		this.setVisible(true);
				
		//키보드 리스너 사용시 포커스 받아오기
		contentPane.setFocusable(true);
		contentPane.requestFocus();
	}

	class MyKeyListener extends KeyAdapter{//상속 받아 사용
//		f1키를 누르면 색이 초록색, %를 누르면 색이 노란색으로 변경
		public void keyPressed(KeyEvent e) {
			System.out.println("char=="+e.getKeyChar());//키 값 글자로 받아 오기
			System.out.println("code=="+e.getKeyCode());//키를 숫자로 받아오기
			if(e.getKeyChar()=='%') { // 문자는 '' 로 표시 / eqequals는 스트링에서만 사용
				contentPane.setBackground(Color.YELLOW); // 컬러 색상은 대문자로 
			}else if(e.getKeyCode()==KeyEvent.VK_F1) {// 기본적으로 버츄얼키보드에 들어가 있는 것을 가져와 사용하는 방법(keyCode로만 사용 가능)
				contentPane.setBackground(Color.GREEN);
			}
			
			
			
		}
	}
	
	public static void main(String[] args) {
		new ChangeBg();
	}
}
