package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chap1211 extends JFrame {
	//private InputPanel inputPanel = new InputPanel();
	private ChartPanel chartPanel = new ChartPanel();
	private String labels[] = {"apple","cherry","berry","prune"};
	private JTextField tfList[] = new JTextField [4];
	private int arcList[] = new int[4];
	private int dataList[] = {0,0,0,0};//������ ��Ƶ� ��
	private Color colors[] = {Color.RED,Color.BLUE,Color.MAGENTA,Color.ORANGE};
	
	public Chap1211() {
		this.setTitle("������Ʈ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		//����� �߰� ��� - �ٸ��� �ϸ� ���� �߻�
		contentPane.add(new InputPanel(),BorderLayout.NORTH);
		contentPane.add(chartPanel,BorderLayout.CENTER);
		
		this.setSize(500,400);
		this.setVisible(true);
	}
	
	private class InputPanel extends JPanel {
		public InputPanel() {
			this.setBackground(Color.LIGHT_GRAY);
			this.setLayout(new FlowLayout());
			for(int i=0;i<4;i++) {
				tfList[i] = new JTextField("0",5);//0�� ���� ���ڼ� 5���� ���ڴ�
				tfList[i].addActionListener(new MyActionListener());
				this.add(new JLabel(labels[i]));//���̺� ���� �� �߰�
				this.add(tfList[i]);
			}
		}
		class MyActionListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();// ������������
				int num = Integer.parseInt(tf.getText());// �ؽ�Ʈ�ʵ忡 �Է��� �� num������ �־�α�
				int sum = 0;//�Է��� 4���� �� ���ϱ�
				for(int i=0;i<4;i++) {
					dataList[i] =  Integer.parseInt(tfList[i].getText());//tf.getText()�� ����Ͽ��� �ȴ�
					//tfList�� �� �ִ� �Է� �� �����ͼ� �迭�� �ֱ�
					sum+=dataList[i];//������� ���� �����ֱ�
				}
				//0���� �����ؼ� 360���� 4��� �ʿ�
				for(int i=0;i<4;i++) {
					//System.out.println((double)dataList[i] / (double)sum);
					arcList[i] = (int)(Math.round( (double)dataList[i] / (double)sum * 360));
					//360���� 4��� -sum�� dataList �Ѵ� int���� ����ȯ �ʿ�
					//System.out.print(arcList[i]+",");
				}
				chartPanel.repaint();//���� ĥ������ ������ �ʰ� ���� �׸��� ���ֱ�
			}
		}
	}
	
	private class ChartPanel extends JPanel {
		//�׸� �׸���
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int startAngle = 0;//0���� �����ؼ� 360����
			for(int i=0;i<4;i++) {
				g.setColor(colors[i]);//������ �迭 ���
				g.fillArc(150, 50, 200, 200, startAngle, arcList[i]);//(�׸���ġ,����,����,��������(����),������(����))
				startAngle+=arcList[i];
			}
			//���� 4��� �ȴ�
//			g.setColor(Color.RED);
//			g.fillArc(150, 50, 200, 200, 0, 90);
//			g.setColor(Color.GREEN);
//			g.fillArc(150, 50, 200, 200, 90, 90);
//			g.setColor(Color.BLUE);
//			g.fillArc(150, 50, 200, 200, 180, 90);
//			g.setColor(Color.ORANGE);
//			g.fillArc(150, 50, 200, 200, 270, 90);
		}
	}
	
	public static void main(String[] args) {
		new Chap1211();
	}
}
