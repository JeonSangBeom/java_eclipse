package lecture;
//BorderLayout �������� ��ġ
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class BorderLayoutTest extends JFrame {
	public BorderLayoutTest() {
		this.setSize(500,500);
		this.setVisible(true);
		this.setTitle("BORDER LAYOUT TEST");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container contentPane = this.getContentPane(); // �⺻ JPanel�� ��������
		contentPane.setLayout(new BorderLayout(10,20)); // BorderLayout(Frame�� �⺻ �г�) �������� ��ġ(���鸸���(����,����))
		
		contentPane.add(new JButton("add"),BorderLayout.NORTH);
		contentPane.add(new JButton("subtract"),BorderLayout.SOUTH);
		contentPane.add(new JButton("multiply"),BorderLayout.EAST);
		contentPane.add(new JButton("divide"),BorderLayout.WEST);
		contentPane.add(new JButton("calc"),BorderLayout.CENTER); // center�� �⺻�̿��� ���� �Ƚᵵ �ȴ�(,BorderLayout.CENTER) - �̺κ�
		
		
	}
	public static void main(String[] args) {
		new BorderLayoutTest(); // �տ� ���� BorderLayoutTest ���� = �Ⱥٿ��� �ȴ�;
	}
}





