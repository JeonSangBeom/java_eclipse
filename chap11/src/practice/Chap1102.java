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
		this.setTitle("��������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		contentPane.add(new JLabel("���� �Է��� ���� �����ּ���"));
		contentPane.add(tf);
		contentPane.add(cb);
		
		vec.add("�强ȣ");
		vec.add("�����");
		cb.setSelectedIndex(0);// �强ȣ �̸� ���̰� ����
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField) e.getSource();
				vec.add(tf.getText());// �޺��ڽ��� �߰�
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
