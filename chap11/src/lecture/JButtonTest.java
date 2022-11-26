package lecture;
//button ���� - �̹���
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest extends JFrame {
	public JButtonTest() {
		this.setTitle("button ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//�ؽ�Ʈ ��ư
		JButton txtButton = new JButton("I LOVE JAVA;");
		//�̹��� ��ư
		JButton imgButton = new JButton(new ImageIcon("images/phone.png")); // �ѹ��� ���� ���
		//�׵θ� ���ٶ� �Է��� �� �װ���
		imgButton.setBorderPainted(false);// �׵θ� ���ٶ�
		imgButton.setContentAreaFilled(false);// �׵θ� �� ���� ����
		imgButton.setFocusPainted(false);// ��Ŀ�� ������ ���̴� ��ư
		imgButton.setOpaque(false);// �Ⱥ��̰�
		
		imgButton.setRolloverIcon(new ImageIcon("images/phone_over.png"));//���콺 ������ ��� �ٲ�� ����
		imgButton.setPressedIcon(new ImageIcon("images/phone_press.png"));//Ŭ���� ����
		
		
		contentPane.add(txtButton);
		contentPane.add(imgButton);
		
		
		this.setSize(300, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JButtonTest();
	}
}
