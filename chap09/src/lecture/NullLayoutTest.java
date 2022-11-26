package lecture;
//NullLayout 사용법 - 내가 원하는 위치에 생성
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NullLayoutTest extends JFrame {
	
	public NullLayoutTest() {
		this.setSize(600,500);
		this.setVisible(true);
		this.setTitle("NULL LAYOUT TEST");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null); // default가 BorderLayout이다.
		
		JLabel  label = new JLabel("Hello"); // 변수로 라벨 생성
		contentPane.add(label); //frame panel에 추가하기 
		label.setLocation(0, 0); // 위치 잡아주기
		label.setSize(600,50); // 크기 생성(가로,세로)
		label.setOpaque(true); // 불투명(true로 잡아야 색상이 보인다)
		label.setBackground(Color.orange);// 색상
		//quiz 반복문 돌리기 총 12  3칸에 4개
		
		//첫번째 방법 - 한번 돌려서
//		for(int i=0;i<12;i++) {
//			JButton btn = new JButton("button"+i);// 하나씩 i+
//			contentPane.add(btn);
//			btn.setSize(200,50);
//			btn.setLocation((i%3)*200,50*(int)(Math.floor(i/3))+60);  //0,1,2 ==50(0), 3,4,5 ==100(1), 6,7,8 == 150(2)
		               //i%3 한줄에 3개에서 끝나야 하기 때문에 3으로 떨어질땐 끝내기 위해(계속 3까지만 계산하는 방식 - 0,1,2)
		               //(int) 정수로변환 Math.floor - 소숫점 버리기
					   //나눗셈을 이용하여 다음줄로 넘기는 방식(갯수가 끝난 후) +60은 처음 0 으로 계산할시 첫줄을 위해
//		}
		//반복문 두번 돌리기
		int count = 1;
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				JButton btn = new JButton("button"+count);
				contentPane.add(btn);
				btn.setSize(200,50);
				btn.setLocation(j*200,i*50+60);  
				count++;// btn0,1,2등 제한이 갈수 있기 때문에 count 사용
			}
		}
		/*
		 * 이것을 반복문으로 돌려 사용
		JButton btn01 = new JButton("button01");
		contentPane.add(btn01);
		btn01.setSize(200,50);
		btn01.setLocation(0,60);
		
		JButton btn02 = new JButton("button02");
		contentPane.add(btn02);
		btn02.setSize(200,50);
		btn02.setLocation(200,60);
		
		JButton btn03 = new JButton("button03");
		contentPane.add(btn03);
		btn03.setSize(200,50);
		btn03.setLocation(400,60);
		*/
	}
	
	public static void main(String[] args) {
		new NullLayoutTest();
	}
}





