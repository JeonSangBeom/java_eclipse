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
		this.setTitle("JListTest ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//�迭�� �޾� ����ϴ� �� / ����Ʈ�� �迭 �ֱ�
		JList<String> list01 = new JList<>(fruits);
		contentPane.add(list01);
		
		// ����Ʈ�� �̹��� �迭 �־� ����ϴ� ��
		JList<ImageIcon> list02 = new JList<>(images);
		contentPane.add(list02);
		
		// ��ũ�� �־� ����� ��
		JList<String> list03 = new JList<>(fruits);
		JScrollPane scrollList = new JScrollPane(list03);// ũ�� �����ÿ��� ���� ������ ����� ����� �Ͽ��� �Ѵ�
		//scrollList.setPreferredSize(new Dimension(100,100));// ũ�� �����ϱ�
		contentPane.add( scrollList );
		
		//Vector�̿� ���
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
