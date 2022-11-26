package practice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class Chap1403 extends JFrame {
	Chap1403() {
		this.setTitle("툴바 이용");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		JToolBar toolBar = new JToolBar();
		JButton btnExit = new JButton("exit");
		toolBar.add(btnExit);
		contentPane.add(toolBar, BorderLayout.NORTH);
		btnExit.addActionListener(new CloseActionListener());
		
		this.setSize(500, 300);
		this.setVisible(true);
	}
	class CloseActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int result = 
			JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", 
										   "alert", JOptionPane.YES_NO_OPTION);//리턴값 만들기
			if(result==JOptionPane.YES_OPTION) System.exit(0);//yes면 닫기
			else return;
		}
	}

	public static void main(String[] args) {
		new Chap1403();
	}
}
