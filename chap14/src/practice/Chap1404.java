package practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Chap1404 extends JFrame {
	private JLabel resultLabel = new JLabel("출력장");//다이어로그에서 사용하기 위해 전역변수로 사용

	Chap1404() {
		this.setTitle("학번 입력");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		JButton btnCalc = new JButton("calculate");
		contentPane.add(btnCalc);
		contentPane.add(resultLabel);
		btnCalc.addActionListener(new MyActionListener());
		
		this.setSize(500, 300);
		this.setVisible(true);
	}

	class MyActionListener implements ActionListener {
		private CalcDialog calcDialog;

		MyActionListener() {
			calcDialog = new CalcDialog(Chap1404.this);//프레임을 가리키는 것
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			calcDialog.setVisible(true);
			resultLabel.setText(Integer.toString(calcDialog.getSum()));
		}
	}
	class CalcDialog extends JDialog {
		private JTextField tf01 = new JTextField(15);
		private JTextField tf02 = new JTextField(15);
		private JButton btn = new JButton("ADD");
		private int sum = 0;//밖에서도 쓸수 있게
		
		CalcDialog(JFrame frame) {
			super(frame, "Calc Dialog", true);//true를 쓰면 modal이 되어 다른 무엇도 할 수 없게 된다
			this.setLayout(new FlowLayout());
			this.add(new JLabel("두 수를 더합니다."));
			this.setSize(200, 200);
			this.add(tf01);
			this.add(tf02);
			this.add(btn);
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {					
					try {
						int txt01 = Integer.parseInt(tf01.getText());//정수로 바꿔 넣기
						int txt02 = Integer.parseInt(tf02.getText());
						sum = txt01 + txt02;//정수로 변환한 값을 더해주기
						tf01.setText("");
					} catch (Exception e2) {
						//e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"정수가 아닌 뭔가가 들어갔어요.","정수 오류",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					setVisible(false);//add 버튼 클릭시 사라지게
				}
			});
		}
		public int getSum() {//다른 곳에서 사용할 수 있게 메서드 만들기
			return sum;
		}
	}

	public static void main(String[] args) {
		new Chap1404();
	}
}
