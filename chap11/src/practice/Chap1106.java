package practice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Chap1106 extends JFrame {
	public Chap1106() {
		this.setTitle("Slider");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		//JTextArea 생성
		JTextArea ta = new JTextArea(8,10);
		contentPane.add(new JScrollPane(ta),BorderLayout.NORTH);
		//슬라이더 생성
		JSlider slider = new JSlider(0,100,0);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		contentPane.add(slider,BorderLayout.CENTER);
		
		//JTextArea 이벤트 달기
		ta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {// 키보드 입력시 
				int total = ta.getText().length();// 글자를 받아 그 길이를 변수에 담기
				if(total>=100) {// 100이 넘어가면
					ta.setText(ta.getText().substring(0,100));//얻어온 값의 0,100까지만 써라
					return;
				}
				slider.setValue(total);
			}
		});
		// 슬라이더 이동시켜 지우기 글자(뒤로만 가능)
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int val = slider.getValue();// 슬라이더의 값 변수 넣기
				int total = ta.getText().length();
				//System.out.println(total);
				if(val<=total) {// 글자수 보다 슬라이더가 크면 안되기 때문에 그게 되면 리턴
					ta.setText(ta.getText().substring(0,val));
					return;
				} 
				try {
					ta.setText(ta.getText().substring(0,val));
				} catch (Exception err) {
					//err.printStackTrace();
					System.out.println("글자수보다 슬라이더가 길면 안되됴ㅐ요 ");
				}
			}
		});
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Chap1106();
	}
}
