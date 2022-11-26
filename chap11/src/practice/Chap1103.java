package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chap1103 extends JFrame {

	private String moneyTitles [] = {"오만원","만원","천원","오백원","백원","오십원","십원","일원"};
	private int units [] = {50000,10000,1000,500,100,50,10,1};
	private JTextField tfList[] = new JTextField[8];
	
	public Chap1103() {
		this.setTitle("동전바꾸기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		//topPanel 패널 하나 생성
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		contentPane.add(topPanel,BorderLayout.NORTH);
		//contentsPanel 패널 하나 생성
		JPanel contentsPanel = new JPanel();
		contentsPanel.setLayout(new GridLayout(8,2,10,10));//8줄에 2칸
		contentPane.add(contentsPanel,BorderLayout.CENTER);
		//topPanel 속성 설정
		topPanel.setOpaque(true);
		topPanel.setBackground(Color.GRAY);
		//상단 레이블 생성
		JLabel title = new JLabel("금액");
		JTextField money = new JTextField("",15);// 공백에 15글자
		JButton btnCalc = new JButton("계산");
		topPanel.add(title);
		topPanel.add(money);
		topPanel.add(btnCalc);
		//두번째 contentsPanel에 넣기 (배열로)
		for(int i=0;i<8;i++) {
			JLabel moneyTitleLabel = new JLabel(moneyTitles[i]);
			tfList[i] = new JTextField(20); // 텍스트 필드
			contentsPanel.add(moneyTitleLabel);
			contentsPanel.add(tfList[i]);
		}
		//btnCalc(계산) 클릭시 이벤트 걸기
		btnCalc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = money.getText();///임의의 변수에 텍스트 받아와 넣기
				if(temp.length() == 0) return; // 0 일경우 리턴(계산하지 않겠다)
				int realMoney = Integer.parseInt(temp);//String로 받기 때문에 정수 변환
				//System.out.println(realMoney);
				int rest;
				//System.out.println(realMoney/units[0]);
				for(int i=0;i<8;i++) {
					rest = realMoney/units[i];// 나머지 = 리얼머니를 units로 나누기(순서대로)
					tfList[i].setText(Integer.toString(rest));// 리스트에 넣어주기 값(넣을땐 String로 변환해서 넣어준다)
					if(rest>0) realMoney = realMoney%units[i]; // 계산 하고 남은 나머지를 realMoney에 다시 넣어주기
				}
			}
		});
		
		
		this.setSize(300,300);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Chap1103();
	}
}





