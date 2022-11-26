package lecture;
//AnonymousClassListener -- 익명의 클래스 사용 / 직접 입력하여 사용
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnonymousClassListener extends JFrame {
	public AnonymousClassListener() {
		this.setTitle("독립적인 클래스로 존재한느 이벤트 리스너");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JButton btn01 = new JButton("CLICK");
		JButton btn02 = new JButton("CLOSE");
		JButton btn03 = new JButton("OPEN");
		//ActionListener는 button에만 사용 가능
		btn01.addActionListener(new ActionListener() { // 바로 사용하여 구현하여 사용
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				if(btn.getText().equals("CLICK")) btn.setText("클릭");
				else btn.setText("CLICK");
				setTitle("난 익명 클래스로 만들어진 리스너에서 부모클래스의 타이틀을 바꾸고 있습니다.");
				//여기선 this를 쓸수 없다 - this를 쓸 경우 ActionEvent를 가리키기 때문
			}
		});
		//btn02.addActionListener(new MyActionListener());
		//btn03.addActionListener(new MyActionListener());
		
		contentPane.add(btn01);
		contentPane.add(btn02);
		contentPane.add(btn03);
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AnonymousClassListener();
	}
}
