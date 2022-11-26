package lecture;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JComponentTest extends JFrame {
	
	public JComponentTest() {
		this.setTitle("���۳�Ʈ �޼��� ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//��ư ����
		JButton btn01 = new JButton("Magenta / Yellow");
		JButton btn02 = new JButton("disable");
		JButton btn03 = new JButton("getX() / getY()");
		
		//��ư �־��ֱ�
		contentPane.add(btn01);
		contentPane.add(btn02);
		contentPane.add(btn03);
		
		//���� �� ��Ʈ ����
		btn01.setBackground(Color.MAGENTA);
		btn01.setForeground(Color.YELLOW);
		btn01.setFont(new Font("Arial",Font.BOLD,24));
		
		// ��� ���ֱ� (��ư�� �ȴ�������)
		btn02.setEnabled(false); 
		
		
		btn03.addActionListener(new ActionListener() {//ActionListener - ��ư������ ��� ����
			@Override
			public void actionPerformed(ActionEvent e) {//ActionListener�� �̰� �ϳ� ��(�޼���)
				JButton btn = (JButton)e.getSource();//getSource - �ڵ� �������� obj�̱� ������ JButton���� ����ȯ �ʿ�
				JComponentTest frame = (JComponentTest) btn.getTopLevelAncestor();//getTopLevelAncestor = �ֻ��� ���� ���Ҷ� ���(container)
				//JComponentTest - ���� Ÿ���� ���� ������ �� ��ȯ �ʿ�
				//Ŭ���� Ÿ�Կ� ���������� ����ϴ� ��
				frame.setTitle(btn.getX()+" / "+ btn.getY());//��ư�� ��ǥ
				
			}
		});
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new JComponentTest(); 
	}

}
