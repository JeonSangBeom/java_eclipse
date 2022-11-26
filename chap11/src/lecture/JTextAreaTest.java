package lecture;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaTest extends JFrame {
	private JTextField tf = new JTextField(20);
	private JTextArea ta = new JTextArea(10,20);
	public JTextAreaTest() {
		this.setTitle("TextAreaTest");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JLabel("글자를 입력후 Enter를 누르세요"));
		contentPane.add(tf);
		contentPane.add( new JScrollPane(ta,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		//JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED - 스크롤 효과 줄때 사용
		
		//JTextField에 이벤트 걸기
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();//obj를 리턴하여 형변환 
				//System.out.println(tf.getText()); // getText 글자를 얻어 오는 것
				ta.append( tf.getText() +"\r\n"); // append - 스트링 추가 getText 얻어온 글자 + 한칸 띄우기(줄바꿈)
				tf.setText("");//추가후 공백 처리하기 위해
			}
		});
		
		this.setSize(280,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JTextAreaTest();
	}
}
