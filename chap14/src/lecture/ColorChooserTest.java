package lecture;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import lecture.FileDialogTest.OpenActionListener;

public class ColorChooserTest extends JFrame {
	private JLabel label = new JLabel("Hello Java");
	ColorChooserTest() {
		this.setTitle("color Chooser");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Russo one",Font.BOLD,48));
		contentPane.add(label,BorderLayout.CENTER);
		createMenu();
		
		this.setSize(500, 300);
		this.setVisible(true);
	}
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Text");
		JMenuItem colorItem = new JMenuItem("Color");
		fileMenu.add(colorItem);
		menuBar.add(fileMenu);
		
		this.setJMenuBar(menuBar);
		colorItem.addActionListener(new ColorActionListener());
	}
	//아이템에 이벤트 걸기
	class ColorActionListener implements ActionListener{
		@Override 
		public void actionPerformed(ActionEvent e) {
			Color seletedColor = JColorChooser.showDialog(null, "Color", Color.YELLOW);//컬러 찾는 것(처음 선택 yellow설정)
			label.setForeground(seletedColor);// 색상 넣기
		}
	}
	public static void main(String[] args) {
		new ColorChooserTest();
	}
}



