package practice;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class Chap1401 extends JFrame {
	Chap1401() {
		this.setTitle("메뉴바 만들기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		this.setSize(500, 300);
		this.setVisible(true);
	}
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
		JMenu editMenu = new JMenu("편집");
		JMenu viewMenu = new JMenu("보기");
		JMenu inputMenu = new JMenu("입력");
		viewMenu.add(new JMenuItem("화면확대"));
		viewMenu.add(new JMenuItem("쪽윤곽"));
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
