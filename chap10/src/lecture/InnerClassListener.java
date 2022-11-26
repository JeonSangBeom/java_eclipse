package lecture;
//InnerClassListener - private 사용 / 부모에 접근을 위할때 보통 사용한다
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class InnerClassListener extends JFrame {
	public InnerClassListener() {
		this.setTitle("독립적인 클래스로 존재한느 이벤트 리스너");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JButton btn01 = new JButton("CLICK");
		JButton btn02 = new JButton("CLOSE");
		JButton btn03 = new JButton("OPEN");
		btn01.addActionListener(new MyInnerActionListener());
		//btn02.addActionListener(new MyActionListener());
		//btn03.addActionListener(new MyActionListener());
		
		contentPane.add(btn01);
		contentPane.add(btn02);
		contentPane.add(btn03);
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	// 클래스 내부로 들어와 만들어 준다 inner 클래스 - 잘 쓰지는 않는다.
	private class MyInnerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(e);
			JButton btn = (JButton)e.getSource();
			//System.out.println(btn.getText());
			if(btn.getText().equals("CLICK")) btn.setText("클릭");
			else btn.setText("CLICK");
			InnerClassListener.this.setTitle("난 이너 클래스로 작성된 이벤트 리스너에 의해 바뀌는 제목입니다.");
			//InnerClassListener 내부에 있기 때문에 불러와 사용 가능 /InnerClassListener를 안쓸경우 MyInnerActionListener을 불러 올려고 하기 때문에 필요
			//다만 this사용은 필수 사용하지 않을 경우 stitic 메서드가 되기 때문에
		}
	}
	public static void main(String[] args) {
		new InnerClassListener();
	}
}
