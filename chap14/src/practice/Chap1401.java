package practice;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class Chap1401 extends JFrame {
	Chap1401() {
		this.setTitle("�޴��� �����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		this.setSize(500, 300);
		this.setVisible(true);
	}
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("����");
		JMenu editMenu = new JMenu("����");
		JMenu viewMenu = new JMenu("����");
		JMenu inputMenu = new JMenu("�Է�");
		viewMenu.add(new JMenuItem("ȭ��Ȯ��"));
		viewMenu.add(new JMenuItem("������"));
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);
		menuBar.add(inputMenu);
		this.setJMenuBar(menuBar);
	}
	public static void main(String[] args) {
		new Chap1401();
	}
}
