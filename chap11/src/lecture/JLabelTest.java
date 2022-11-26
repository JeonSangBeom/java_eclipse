package lecture;
//JLabel�׸� �ֱ� ���� / ���� images����� ���
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JLabelTest extends JFrame {

	public JLabelTest() {
		this.setTitle("JLabel�׸� �ֱ� ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//txtLabel
		JLabel txtLabel = new JLabel("I LOVE JAVA;");
		//imageLabel
		ImageIcon imageIcon = new ImageIcon("images/heart_big.png");//ImageIcon - �̹����� �̹����������� ���� �Ŀ� �ҷ��ü� �ִ�
		JLabel imgLabel = new JLabel(imageIcon);// �ҷ��� ���� ����Ʈ ���־�� ��� ����
		//txtAndImgLabel
		ImageIcon phoneIcon = new ImageIcon("images/phone.png");
		JLabel txtAndImgLabel = new JLabel("CALL ME",phoneIcon,SwingConstants.CENTER);//���ڸ� ���� ���� �̹����� �־�� �Ѵ� / SwingConstants.CENTER - ��� ����
		
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
