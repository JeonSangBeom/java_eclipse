package lecture;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ToolTipManager;

public class TooltipTest extends JFrame {
	//과일 이미지 두개 올리기
	//JLabel 에 과일이미지 올리기
	//마우스 올리면 Tooltip 생기게 하고
	// 3초 뒤에 사라지게
	public TooltipTest() {
		this.setTitle("툴팁 사용");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//이미지 넣고 추가
		JLabel appleLabel = new JLabel(new ImageIcon("images/apple02.png"));
		JLabel berryLabel = new JLabel(new ImageIcon("images/strawberry02.png"));
		contentPane.add(appleLabel);
		contentPane.add(berryLabel);
		
		//툴팁
		appleLabel.setToolTipText("사과");
		berryLabel.setToolTipText("딸기");
		
		//툴팁 설정
		ToolTipManager manager = ToolTipManager.sharedInstance();
		manager.setInitialDelay(100);
		manager.setDismissDelay(3000);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new TooltipTest();
	}
}
