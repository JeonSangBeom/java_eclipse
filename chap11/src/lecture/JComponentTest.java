package lecture;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JComponentTest extends JFrame {
	
	public JComponentTest() {
		this.setTitle("컴퍼넌트 메서드 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//버튼 생성
		JButton btn01 = new JButton("Magenta / Yellow");
		JButton btn02 = new JButton("disable");
		JButton btn03 = new JButton("getX() / getY()");
		
		//버튼 넣어주기
		contentPane.add(btn01);
		contentPane.add(btn02);
		contentPane.add(btn03);
		
		//색상 및 폰트 변경
		btn01.setBackground(Color.MAGENTA);
		btn01.setForeground(Color.YELLOW);
		btn01.setFont(new Font("Arial",Font.BOLD,24));
		
		// 기능 없애기 (버튼이 안눌러진다)
		btn02.setEnabled(false); 
		
		
		btn03.addActionListener(new ActionListener() {//ActionListener - 버튼에서만 사용 가능
			@Override
			public void actionPerformed(ActionEvent e) {//ActionListener는 이것 하나 뿐(메서드)
				JButton btn = (JButton)e.getSource();//getSource - 코드 가져오기 obj이기 때문에 JButton으로 형변환 필요
				JComponentTest frame = (JComponentTest) btn.getTopLevelAncestor();//getTopLevelAncestor = 최상위 조상 구할때 사용(container)
				//JComponentTest - 리턴 타입을 잡은 것으로 형 변환 필요
				//클래스 타입에 하위계층을 계산하는 법
				frame.setTitle(btn.getX()+" / "+ btn.getY());//버튼의 좌표
				
			}
		});
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new JComponentTest(); 
	}

}
