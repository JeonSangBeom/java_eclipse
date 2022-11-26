package lecture;
//JLabel그림 넣기 연습 / 폴더 images만들어 사용
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JLabelTest extends JFrame {

	public JLabelTest() {
		this.setTitle("JLabel그림 넣기 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//txtLabel
		JLabel txtLabel = new JLabel("I LOVE JAVA;");
		//imageLabel
		ImageIcon imageIcon = new ImageIcon("images/heart_big.png");//ImageIcon - 이미지는 이미지아이콘을 만든 후에 불러올수 있다
		JLabel imgLabel = new JLabel(imageIcon);// 불러온 것을 임폴트 해주어야 사용 가능
		//txtAndImgLabel
		ImageIcon phoneIcon = new ImageIcon("images/phone.png");
		JLabel txtAndImgLabel = new JLabel("CALL ME",phoneIcon,SwingConstants.CENTER);//글자를 먼저 쓰고 이미지를 넣어야 한다 / SwingConstants.CENTER - 가운데 정렬
		
		contentPane.add(txtLabel);
		contentPane.add(imgLabel);
		contentPane.add(txtAndImgLabel);
		
		this.setSize(300, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new JLabelTest();
	}
}
