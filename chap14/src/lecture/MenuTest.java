package lecture;
//메뉴바 연습
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuTest extends JFrame {
	public MenuTest() {
		this.setTitle("메뉴바 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu();
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	//메뉴바 만들 메서드
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();//메뉴바 생성 및 선언
		//Screen메뉴바 하단
		JMenu screenMenu = new JMenu("Screen");
		screenMenu.add(new JMenuItem("Load"));
		screenMenu.add(new JMenuItem("Hide"));
		screenMenu.add(new JMenuItem("Reshow"));
		screenMenu.addSeparator();//선 나누기
		screenMenu.add(new JMenuItem("Exit"));
		//메뉴바에 추가
		menuBar.add(screenMenu);
		menuBar.add(new JMenu("Edit"));		
		menuBar.add(new JMenu("Source"));
		menuBar.add(new JMenu("Project"));
		menuBar.add(new JMenu("Run"));
		//JMenuBar에 추가 (최종 - 여기에 안넣어 주면 아무것도 생성이 안된다)
		setJMenuBar(menuBar);
		
	}
	public static void main(String[] args) {
		new MenuTest();
	}
}



