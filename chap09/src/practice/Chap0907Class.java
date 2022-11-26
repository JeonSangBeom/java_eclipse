package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/// 이런식으로 클래스를 나눠 쓸수 있다(코드 분리)
class NorthPanel extends JPanel { //JPanel을 상속 받아 사용
	public NorthPanel() {
		this.setLayout(new FlowLayout());
		this.setOpaque(true);
		this.setBackground(Color.LIGHT_GRAY);
		this.add(new JLabel("수식입력"));
		this.add(new JTextField(16));
	}
}

class CenterPanel extends JPanel {
	public CenterPanel() {
		String marks[] = { "+", "-", "x", "/" };
		setLayout(new GridLayout(4, 4, 5, 5));
		for (int i = 0; i < 10; i++) {
			JButton btns = new JButton(Integer.toString(i));
			add(btns);
		}
		add(new JButton("CE"));
		add(new JButton("계산"));

		for (int i = 0; i < 4; i++) {
			JButton btns = new JButton(marks[i]);
			btns.setOpaque(true);
			btns.setBackground(Color.GREEN);
			add(btns);
		}
	}
}

class SouthPanel extends JPanel {
	public SouthPanel() {
		setLayout(new FlowLayout());
		setOpaque(true);
		setBackground(Color.ORANGE);
		add(new JLabel("계산결과"));
		add(new JTextField(16));
	}
}

public class Chap0907Class extends JFrame {
	public Chap0907Class() {
		this.setTitle("계산기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		NorthPanel northPanel = new NorthPanel();
		CenterPanel centerPanel = new CenterPanel();
		SouthPanel southPanel = new SouthPanel();

		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(centerPanel,BorderLayout.CENTER);
		contentPane.add(southPanel,BorderLayout.SOUTH);

		this.setSize(300, 300);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Chap0907Class();
	}
}
