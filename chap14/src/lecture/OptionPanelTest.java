package lecture;
//Dialog 종류
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionPanelTest extends JFrame {
	public OptionPanelTest() {
		this.setTitle("Dialog 종류");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.add(new BtnPanel(),BorderLayout.NORTH);
		
		this.setSize(500, 300);
		this.setVisible(true);
	}
	
	class BtnPanel extends JPanel {
		private JButton btnInput=new JButton("Input Name");
		private JButton btnConfirm=new JButton("Confirm");
		private JButton btnMsg=new JButton("Message");
		private JTextField tf = new JTextField(10);
		//기본 생성자
		public BtnPanel() {
			this.setBackground(Color.LIGHT_GRAY);
			this.setLayout(new FlowLayout());
			this.add(btnInput);
			this.add(btnConfirm);
			this.add(btnMsg);
			this.add(tf);
			//각 이벤트 달기
			//입력값 담기
			btnInput.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String name = JOptionPane.showInputDialog("이름을 입력하세요");//JOptionPane(다이어로그)
					if(name==null) return ;//name이 null이면 return아니면 tf에 글자 입력
					tf.setText(name);
				}
			});
			//컨펌 이벤트
			btnConfirm.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int result = 
				JOptionPane.showConfirmDialog(null, "계속 할건가요?","Confirm",JOptionPane.YES_NO_OPTION);//기본 매개변수와 나머지 입력 후 yes,no 컨펌 받는 것
					if(result==JOptionPane.CLOSED_OPTION) tf.setText("closed no select");//그냥 닫을 경우
					else if(result==JOptionPane.YES_OPTION) tf.setText("Yes");//yes를 눌렀을때
					else tf.setText("No");//no를 눌렀을때
				}
			});
			//에러 표시 메시지 뜨게 하는 법
			btnMsg.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Red Alert","Message",JOptionPane.ERROR_MESSAGE);
				}
			});
		}
	}
	
	public static void main(String[] args) {
		new OptionPanelTest();
	}
}



