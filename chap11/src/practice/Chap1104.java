package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chap1104 extends JFrame {

	private String moneyTitles [] = {"오만원","만원","오천원","천원","오백원","백원","오십원","십원","일원"};
	private int units [] = {50000,10000,5000,1000,500,100,50,10,1};
	private JTextField tfList[] = new JTextField[9];
	private JCheckBox cbList[] = new JCheckBox[9];
	
	public Chap1104() {
		this.setTitle("동전");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		contentPane.add(topPanel,BorderLayout.NORTH);
		JPanel contentsPanel = new JPanel();
		contentsPanel.setLayout(new GridLayout(9,3,10,10));
		contentPane.add(contentsPanel,BorderLayout.CENTER);
		topPanel.setOpaque(true);
		topPanel.setBackground(Color.GRAY);
		JLabel title = new JLabel("금액");
		JTextField money = new JTextField("",15);
		JButton btnCalc = new JButton("계산");
		topPanel.add(title);
		topPanel.add(money);
		topPanel.add(btnCalc);
		for(int i=0;i<9;i++) {
			JLabel moneyTitleLabel = new JLabel(moneyTitles[i]);
			cbList[i] = new JCheckBox("",true);
			tfList[i] = new JTextField(20);
			contentsPanel.add(moneyTitleLabel);
			contentsPanel.add(tfList[i]);
			contentsPanel.add(cbList[i]);
		}
		btnCalc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = money.getText();
				if(temp.length() == 0) return;
				int realMoney = Integer.parseInt(temp);
				//System.out.println(realMoney);
				int rest;
				//System.out.println(realMoney/units[0]);
				for(int i=0;i<9;i++) {
					if(!cbList[i].isSelected()) {//체크박스가 선택이 되어 있지 않으면
						tfList[i].setText("0"); //0 을 입력하고 
						continue;//건너띄기
					}
					rest = realMoney/units[i];
					tfList[i].setText(Integer.toString(rest));
					if(rest>0) realMoney = realMoney%units[i];
				}
			}
		});
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Chap1104();
	}
}





