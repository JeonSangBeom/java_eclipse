package practice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Chap1107 extends JFrame {
	public Chap1107() {
		this.setTitle("Slider 글자 크기 조정");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("I LOVE JAVA");
		label.setHorizontalAlignment(JLabel.CENTER);		
		label.setFont(new Font("Noto Sans KR",Font.BOLD,20));
		contentPane.add(label,BorderLayout.CENTER);
		
		//슬라이더 생성
		JSlider slider = new JSlider(16,100,20);
		slider.setMajorTickSpacing(12);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		contentPane.add(slider,BorderLayout.NORTH);
		
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int val = slider.getValue();
				label.setFont(new Font("Noto Sans KR",Font.BOLD,val));
			}
		});
		
		this.setSize(500,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Chap1107();
	}
}
