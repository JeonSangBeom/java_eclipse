package lecture;
//이벤트 사용법 IndependentClassListener 독립적인 클래스
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//독립적인 클래스 생성
class MyActionListener implements ActionListener {//implements -  인터페이스를 상속 받을 때 사용
	//구현해주기
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e); // 여러 이벤트(객체) 확인 가능  
		JButton btn = (JButton)e.getSource(); //업 캐스팅 / getSource는 해당 클래스를 가리키지만 Obj로 분류가 되어 캐스팅을 하여 사용을 하여야 한다(버튼인지 텍스트인지 구분이 안된 상태)
//		System.out.println(btn.getText()); // getSource로 사용 불가능했던 메서드 사용 가능
		// 이벤트가 걸리 JButton 전체에 해당 이벤트 효과 발생
		if(btn.getText().equals("CLICK")) btn.setText("클릭"); //Text가 CLICK라면 버튼을 클릭으로 변경
		else btn.setText("CLICK");
	}
}

public class IndependentClassListener extends JFrame { //extends - 클래스를 상속 받을 때 사용
	public IndependentClassListener() {
		this.setTitle("독립적인 클래스로 존재하는 이벤트 리스너");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JButton btn01 = new JButton("CLICK");
		JButton btn02 = new JButton("CLOSE");
		JButton btn03 = new JButton("OPEN");
		btn01.addActionListener(new MyActionListener());// 이벤트 걸어주는 법 -> 클래스를 만들어서 넣어주기
		//btn02.addActionListener(new MyActionListener());
		//btn03.addActionListener(new MyActionListener());
//		System.out.println(btn01.getText());// CLICK 글자를 가져올 수 있다
		
		contentPane.add(btn01);
		contentPane.add(btn02);
		contentPane.add(btn03);
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new IndependentClassListener();
	}
}
