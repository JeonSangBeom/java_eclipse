package lecture;
//JDialog 사용법 - 팝업창 같은 것
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;

//다이얼로그는 프레임과 상관 없이 단독으로 존재한다
class MyDialog extends JDialog {
	private JTextField tf = new JTextField(10);
	private JButton btn = new JButton("OK");
	//생성자 생성
	public MyDialog(JFrame frame, String title) {
		super(frame,title);//super는 부모 생성자 호출(제일 위에 써야 한다)
		this.setLayout(new FlowLayout());
		this.setSize(200,200);
		this.add(tf);//텍스트 필드
		this.add(btn);//버튼
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//tf.setText("");
				setVisible(false);//이곳에 this를 쓰면 버튼이 사라진다 
			}
		});
	}
	//스트링을 리턴하는 메서드 생성 / DialogTest와 별개의 클래스이기 때문에 외부에 노출이 가능한 메서드를 만들어 사용
	public String getInputText() {
		return tf.getText();//텍스트 필드에 입력한 getText얻어와 리턴
	}
}

public class DialogTest extends JFrame {
	private MyDialog dialog;
	public DialogTest() {
		this.setTitle("dialog 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnDialog  = new JButton("Show Dialog");//borderLayout이기 때문에 버튼이 프레임 전체를 덮게 생성
		Container contentPane = this.getContentPane();
		contentPane.add(btnDialog); //그냥 this.add를 해도 가능 
		dialog = new MyDialog(this, "Dialog"); // 내프레임을 쓰고 / 문자는 Dialog를 사용하겠다
		//이벤트 걸기
		btnDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);//btnDialog 클릭시 dialog 보이게
				String txt = dialog.getInputText();// 텍스틀 넣어둔 메서드를 변수에 담아주기
				btnDialog.setText(txt);
			}
		});
		this.setSize(300, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DialogTest();
	}
}
