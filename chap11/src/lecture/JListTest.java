package lecture;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class JListTest extends JFrame {
	private String fruits[] = {"apple","lemon","kiwi","banana","peach","apple","lemon","kiwi","banana","peach","apple","lemon","kiwi","banana","peach"};
	private ImageIcon images[] = {
			new ImageIcon("images/apple.png"),
			new ImageIcon("images/strawberry.png"),
			new ImageIcon("images/lemon.png")
	};
	public JListTest() {
		this.setTitle("JListTest 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//배열을 받아 사용하는 법 / 리스트에 배열 넣기
		JList<String> list01 = new JList<>(fruits);
		contentPane.add(list01);
		
		// 리스트에 이미지 배열 넣어 사용하는 법
		JList<ImageIcon> list02 = new JList<>(images);
		contentPane.add(list02);
		
		// 스크롤 넣어 만드는 법
		JList<String> list03 = new JList<>(fruits);
		JScrollPane scrollList = new JScrollPane(list03);// 크기 지정시에는 따로 변수로 만들어 사용을 하여야 한다
		//scrollList.setPreferredSize(new Dimension(100,100));// 크기 지정하기
		contentPane.add( scrollList );
		
		//Vector이용 방법
		Vector<String> vec = new Vector<>();
		vec.add("test01");
		vec.add("test02");
		vec.add("test03");
		vec.add("test04");
		vec.add("test05");
		vec.add("test06");
		vec.add("test07");
		
		JList<String> list04 = new JList<>(vec);
		contentPane.add(list04);
		vec.add("test08");
		vec.add("test09");
		
		
		this.setSize(280,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JListTest();
	}
}
