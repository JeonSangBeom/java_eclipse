package lecture;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabPaneTest extends JFrame {
	TabPaneTest() {
		this.setTitle("TabPane 사용하기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		//JTabbedPane tabs = new JTabbedPane();
		JTabbedPane tabs = createTabbedPane();
		contentPane.add(tabs,BorderLayout.CENTER);
		
		this.setSize(500, 300);		
		this.setVisible(true);
	}
	private JTabbedPane createTabbedPane() {
		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);//TOP - 생성되는 위치
		tabs.addTab("tab01", new JLabel(new ImageIcon("images/apple02.png")));
		tabs.addTab("tab02", new JLabel(new ImageIcon("images/strawberry02.png")));
		tabs.addTab("tab03", new MyPanel());
		return tabs;
	}
	class MyPanel extends JPanel {
//		MyPanel() { // 아래 그림을 그려서 이 효과는 사라짐
//			this.setBackground(Color.YELLOW);
//		}
		//그림 그리기
		public void paintComponent(Graphics g) {
			g.setColor(Color.RED);
			g.fillRect(30, 30, 150, 150);
			g.setColor(Color.BLUE);
			g.fillOval(100, 100, 100, 100);
			g.setColor(Color.GREEN);
			g.drawString("Hello Java",30,50);
		}
	}
	public static void main(String[] args) {
		new TabPaneTest();
	}
}
