package lecture;
//MouseAdapterTest // 적게 사용할때 사용
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class MouseAdapterTest extends JFrame {
	private JLabel label = new JLabel("HELLO");
	public MouseAdapterTest() {
		this.setTitle("독립적인 클래스로 존재한느 이벤트 리스너");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		//panel에 넣어주기
		contentPane.addMouseListener(new MyMouseAdapter());
		contentPane.add(label);
		label.setSize(50,30);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	
	// 상속을 받아 사용하고 전체를 구현할 필요가 없어진다
	class MyMouseAdapter extends MouseAdapter {				
		//이벤트가 발생하는 지점(눌렀을때)
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			label.setLocation(x, y);//label
		}
		
	}
	public static void main(String[] args) {
		new MouseAdapterTest();
	}
}
