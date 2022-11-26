package lecture;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JListAppend extends JFrame {
	private JTextField tf = new JTextField(20);
	private Vector<String> vec = new Vector<>();
	private JList<String> list = new JList<>(vec);
	public JListAppend() {
		this.setTitle("JListAppend 설명");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JLabel("글자를 입력후 엔터를 눌러주세요"));
		contentPane.add(tf);
		contentPane.add( new JScrollPane(list,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();// 값얻어오기위한 형변환
				vec.add(tf.getText());//얻어온 값 vec에 추가
				tf.setText("");//추가 후 공백 만들기
				list.setListData(vec);// 추가시 필요 없으면 추가가 안된다
			}
		});
		
		//기본 추가된 상태
		vec.add("장성호");
		vec.add("전상범");
		
		this.setSize(280,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JListAppend();
	}
}
