package lecture;
//상하좌우키 연습
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import lecture.ChangeBg.MyKeyListener;

public class MoveLabel extends JFrame {
	//JLabel을 하나만들고 내용은 hello로 채우기
	//상하좌우키를 누르면 10px해당하는 키값으로 움직이기
	//contentPane에 붙이고 null로 layout설정 그 다음 keyAdapter을 사용하여 움직여 보기
	private JLabel label = new JLabel("HELLO");
	public MoveLabel() {
		this.setTitle("키보드 이벤트 연습 중입니다");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.addKeyListener(new MyKeyListener());
		contentPane.setLayout(null);
		contentPane.add(label);
		label.setLocation(50,50);
		label.setSize(100,20);
		
		this.setSize(300,300);
		this.setVisible(true);
				
		//키보드 리스너 사용시 포커스 받아오기
		contentPane.setFocusable(true);
		contentPane.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_LEFT: // 왼쪽으로 화살표 이동시
				label.setLocation(label.getX() - 10, label.getY());
				break; // 안할시 멈추지 않아서 다른 조건을 사용할 수 없다
			case KeyEvent.VK_RIGHT: // 오른쪽으로 화살표 이동시
				label.setLocation(label.getX() + 10, label.getY());
				break;
			case KeyEvent.VK_UP: // 위쪽으로 화살표 이동시
				label.setLocation(label.getX(), label.getY() - 10); // 모니터 기준이라 - 로 사용
				break;
			case KeyEvent.VK_DOWN: // 아래쪽으로 화살표 이동시
				label.setLocation(label.getX(), label.getY() + 10);
				break;
			}		
		}
	}
	public static void main(String[] args) {
		new MoveLabel();
	}
	
}
