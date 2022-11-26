package lecture;
///JComboBoxTest
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JComboBoxTest extends JFrame {//ComboBox도 배열을 가지고 만들면 된다
	private String fruits[] = {"apple","banana","strawberry","kiwi","orange","peach"};
	private String animals[]= {"lion","tiger","rabbit","horse"};
	private ImageIcon animalIcon [] = {
			new ImageIcon("images/lion.png"),
			new ImageIcon("images/tiger.png"),
			new ImageIcon("images/rabbit.png"),
			new ImageIcon("images/horse.png")
	} ;
	public JComboBoxTest() {
		this.setTitle("JComboBoxTest 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//콤보박스 추가(배열로 만들기)
		JComboBox<String> comboBox = new JComboBox<String>(fruits);
		contentPane.add(comboBox);
		
		JComboBox<String> animalComboBox = new JComboBox<String>();		
		
		JLabel imageLabel = new JLabel();
		
		
		//다른 방법의 콤보박스 추가
		for(int i=0;i<animals.length;i++) {
			animalComboBox.addItem(animals[i]);// 배열로 만들어둔 인덱스를 addItem을 통해 넣을 수 있따
		}		
		contentPane.add(animalComboBox);
		//이벤트 다는 법
		animalComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb =  (JComboBox) e.getSource();
				//System.out.println(cb.getSelectedIndex());
				int sel = cb.getSelectedIndex();//getSelectedIndex 배열순서대로 클릭시 숫자의 정보를 얻을 수 있다
				imageLabel.setIcon(animalIcon[sel]);
			}
		});
		contentPane.add(imageLabel);
		imageLabel.setIcon(animalIcon[0]);

		this.setSize(280,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JComboBoxTest();
	}
}
