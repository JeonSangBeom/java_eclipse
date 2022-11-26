package lecture;
//GridLayout 사용법
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutTest extends JFrame {
	public GridLayoutTest() {
		//기본
		
		this.setTitle("Grid Layout Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 100); // 위치 지정(프레임 생성시 화면에 나타나는 곳)

		Container contentPane = this.getContentPane();
		/*
		 * GridLayout grid = new GridLayout(4,2); 
		 * grid.setVgap(10);// 여백
		 * contentPane.setLayout(grid);
		 * //아래와 같은 것 /변수를 만들어 사용한 것과 아닌 것의 차이
		 */
		contentPane.setLayout(new GridLayout(4,2,10,10)); // (컬럼(기둥(줄)),로우(두칸), 가로여백, 세로여백)
		
		contentPane.add(new JLabel("이름"));// 이름 (표/라벨)
		contentPane.add(new JTextField("")); // 텍스트 입력 란
		contentPane.add(new JLabel("학번"));
		contentPane.add(new JTextField(""));
		contentPane.add(new JLabel("학과"));
		contentPane.add(new JTextField(""));
		contentPane.add(new JLabel("과목"));
		contentPane.add(new JTextField(""));
		
		//프레임안에 내용이 리사이즈를 하지 않으면 안뜨는 현상은 이렇게 사이즈와 비지블을 아래에 두면 해결이 된다 아니면 이것을 사용 revalidate 
		this.setSize(300,200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutTest();
	}
}





