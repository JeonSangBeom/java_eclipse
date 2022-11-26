package lecture;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

class JCheckBoxTest extends JFrame {
	public JCheckBoxTest() {
		this.setTitle("üũ�ڽ� �׽�Ʈ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		ImageIcon cherryIcon = new ImageIcon("images/lemon.png");
		
		//üũ�ڽ� ���� 3���� ���
		JCheckBox apple = new JCheckBox("���");// üũ �ȵ� �⺻ ����
		JCheckBox berry = new JCheckBox("����",true);// üũ�� ����
		JCheckBox lemon = new JCheckBox("����",cherryIcon);// üũ ĭ�� �̹��� �ֱ�
		
		contentPane.add(apple);
		contentPane.add(berry);
		contentPane.add(lemon);
		
		lemon.setBorderPainted(true);// �׵θ� �����Ͽ� ���� ȿ�� ���̰� �ϱ�
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JCheckBoxTest();
	}
}
