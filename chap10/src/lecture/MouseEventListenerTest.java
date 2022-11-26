package lecture;
//MouseEventListenerTest
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class MouseEventListenerTest extends JFrame {
	private JLabel label = new JLabel("HELLO");
	public MouseEventListenerTest() {
		this.setTitle("독립적인 클래스로 존재한느 이벤트 리스너");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		//panel에 넣어주기
		contentPane.addMouseListener(new MyMouseListener());
		contentPane.add(label);
		label.setSize(50,30);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	
	//클래스 사용시
	class MyMouseListener implements MouseListener {
		//외부에 사용하여 인터페이스를 불러오면 무조건 5개를 다 구현하여야 한다 그러지 않고 싶으면 추상클래스로 만들어 사용하여야 한다
		//안쓰게 되면 비워두면 된다
		@Override
		public void mouseClicked(MouseEvent e) {}
		//이벤트가 발생하는 지점(눌렀을때)
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			label.setLocation(x, y);//label
		}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
	public static void main(String[] args) {
		new MouseEventListenerTest();
	}
}
