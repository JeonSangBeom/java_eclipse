package practice;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Chap1105 extends JFrame {
	public Chap1105() {
		this.setTitle("Slider");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		//�����̴� ����
		JSlider slider = new JSlider(100, 200, 120);
		slider.setMajorTickSpacing(20);//20����
		slider.setPaintLabels(true);//���� �߰�
		slider.setPaintTicks(true);//��ħ�� �߰�
		contentPane.add(slider);
		
		//���̺� ����
		JLabel label = new JLabel(Integer.toString(slider.getValue()));// ���� �޾ƿͼ� string���� �ֱ�
		label.setOpaque(true);
		label.setBackground(Color.GREEN);
		label.setForeground(Color.WHITE);
		contentPane.add(label);
		
		//�����̴� �̺�Ʈ �ޱ�
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				label.setText(Integer.toString(slider.getValue()));
			}
		});
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Chap1105();
	}
}
