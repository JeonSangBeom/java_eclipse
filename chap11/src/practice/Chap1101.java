package practice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class Chap1101 extends JFrame {
	private JButton btn = new JButton("TEST BUTTON");

	public Chap1101() {
		this.setTitle("JButton");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		//체크박스 생성
		JCheckBox check01 = new JCheckBox("버튼 비활성화");
		JCheckBox check02 = new JCheckBox("버튼 감추기");

		contentPane.add(check01);
		contentPane.add(check02);
		contentPane.add(btn);
		
		//이벤트 걸기
		//눌러진 상태에서 이벤트 주기
		check01.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) btn.setEnabled(false);//setEnabled - 눌러진 상태면 비활성화 
				else btn.setEnabled(true);// 아니면 다시 활성화
			}
		});
		check02.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) btn.setVisible(false);//setVisible - 눌러진 상태면 안보이게
				else btn.setVisible(true);//아니면 다시 보이게 
			}
		});
		

		this.setSize(250, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Chap1101();
	}
}
