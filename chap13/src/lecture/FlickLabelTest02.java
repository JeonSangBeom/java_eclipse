package lecture;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickLabel02 extends JLabel implements Runnable {
	// Ŭ������ �ᱹ�� ����(�Ӽ�)�� �Լ��� �����̴� 
	public long delay;
	public Color flickColor;
	public Color normalColor;
	
	
	public FlickLabel02() {		
	}
	//�������ڸ��� ���� �ֱ�
	//������ �Լ�(�������ڸ��� ȣ���ϰڴ�)
	public FlickLabel02(String txt, long delay, Color flickColor, Color normalColor) {
		//super(txt); // �θ� ������ ȣ�� �� �� �Է�
		this.setText(txt);// �ڱ� �ڽ����� �ٷ� �ᵵ ������ �ϴ�
		this.delay = delay;
		this.setOpaque(true); // ������ ó�� (���� �ֱ� ����)
		this.flickColor = flickColor;
		this.normalColor= normalColor;
		thStart();
	}
	//���� �޼���� ����� ��� ����(���� �޼���)
	public void thStart() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		boolean isFlick= false;		
		while(true) {
			//System.out.println("aaa");
			isFlick  = !isFlick;
			if(isFlick) this.setBackground(flickColor);
			else this.setBackground(normalColor);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class FlickLabelTest02 extends JFrame {
	public FlickLabelTest02() {
		this.setTitle("Thread ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		FlickLabel02 label01 = new FlickLabel02("I LOVE JAVA", 100, Color.RED, Color.BLACK);
		JLabel label02 = new JLabel(" VS ");
		FlickLabel02 label03 = new FlickLabel02();
		
		
		contentPane.add(label01);
		contentPane.add(label02);
		contentPane.add(label03);
		//label01.thStart();
		//label03.thStart();//�޼��� ����� ������ ���
		
		//�Ű����� ���� ����� ��� ���������ڴ� public�� ����Ͽ��� �Ѵ�
		//label01.setText("I LOVE JAVA");
		//label01.delay=100;
		//label01.flickColor= Color.RED;
		//label01.normalColor= Color.BLACK;
		//label01.setOpaque(true);
		//label01.thStart();
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlickLabelTest02();
	}
}
