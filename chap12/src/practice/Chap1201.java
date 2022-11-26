package practice;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chap1201 extends JFrame {
	private ImgPanel imgPanel = new ImgPanel();
	public Chap1201() {
		this.setTitle("�׸��׸���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(imgPanel);

		this.setSize(300, 300);
		this.setVisible(true);
	}

	class ImgPanel extends JPanel {
		private boolean isShow = true;
		private ImageIcon imgIcon = new ImageIcon("images/jun.jpg");// �̹��� �ҷ�����
		private Image img = imgIcon.getImage();//�̹��� �̾Ƶα�
		private JButton btn = new JButton("Hide / Show");//��ư ����
		public ImgPanel() {
			this.setLayout(new FlowLayout());//����Ʈ ��
			this.add(btn);
			btn.addActionListener(new ActionListener() {// �ٷ� �̺�Ʈ �ɾ� ���
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("aaaa");
					isShow = !isShow; // Ŭ���� isShow�� �����ؼ� false�� ���� ��Ű�� ��
//					if(isShow) isShow= false;
//					else isShow = true;
					repaint();// �׸� �ٽ� �ҷ����°�
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//���� isShow���(���̸�) �׸��� �׷��� - Boolean Ÿ���� ���� �̸� ���� 
			if(isShow) g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);//�̹��� �׸���
		}
	}

	public static void main(String[] args) {
		new Chap1201();
	}
}
