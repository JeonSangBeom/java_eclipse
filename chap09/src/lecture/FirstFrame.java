package lecture;
//Swing JFram 사용법
//container안에 컴포넌트가 들어가는 형식
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstFrame extends JFrame { //만들때 바로 JFrame을 상속하고 사용해 준다 
	public FirstFrame() {// 생성자 = 만들자 마자 바로 생성될 것
		//Frame 기본세팅
		setSize(400, 400); // 크기(사이즈 결정)
		setVisible(true);  // 보이게 만들기 f11을 눌렀을때 보일려면 이게 필요하다(화면에 표시)
		setTitle("my first frame");//타이틀명 변경 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x버튼을 클릭하여 종료하였을때 완전히 종료되게 만들어주는 명령어		
		//메서드 확인이 필요할 경우 this.을 사용하여 확인하면 된다
		
		Container contentPane = this.getContentPane(); // JFrame 생성시 만들어지는 기본 JPanel을 가져오는 것
		contentPane.setBackground(Color.orange);//배경 색상 변경
		contentPane.setLayout(new FlowLayout());// 이렇게 배치를 해줘야 사용 가능 /아니면 전체를 동서남북의 기준으로 생성이 되어 Panel을 전부 덮어버림
		//FlowLayout - 옆으로 계속 나열하는 것
		contentPane.add(new JButton("OK"));//버튼 생성
		contentPane.add(new JButton("CLICK"));//버튼 클릭 
		//add는 contentPane.을 붙이지 않아도 자체적으로 Frame안에 있는 contentPane을 찾아 붙여준다
		 
		
	}
	public static void main(String[] args) {
		FirstFrame myFrame = new FirstFrame();
	}
}
