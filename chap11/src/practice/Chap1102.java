package practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Chap1102 extends JFrame {
	private JTextField tf = new JTextField(20);
	private Vector<String> vec = new Vector<>();
	private JComboBox<String> cb = new JComboBox<>(vec);

	public Chap1102() {
		this.setTitle("연습문제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		contentPane.add(new JLabel("글자 입력후 엔터 눌러주세용"));
		contentPane.add(tf);
		contentPane.add(cb);
		
		vec.add("장성호");
		vec.add("전상범");
		cb.setSelectedIndex(0);// 장성호 이름 보이게 설정
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField) e.getSource();
				vec.add(tf.getText());// 콤보박스에 추가
				tf.setText("");
			}
		});
		
		this.setSize(280, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Chap1102();
	}
}
