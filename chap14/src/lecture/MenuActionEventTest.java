package lecture;
//메뉴바 연습 - 액션 이벤트
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuActionEventTest extends JFrame {
	private JLabel imgLabel = new JLabel(); //사진 불러와 붙일 곳

	public MenuActionEventTest() {
		this.setTitle("메뉴바");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(imgLabel, BorderLayout.CENTER);// 중앙에 붙이기
		createMenu();

		this.setSize(300, 300);
		this.setVisible(true);
	}
	//메뉴바 만들 메서드 (반복문 사용)
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar(); // 생성 및 선언
		JMenuItem menuItems[] = new JMenuItem[4];// 배열 이용
		String itemTitles[] = { "Load", "Hide", "Reshow", "Exit" };// JMenu아래 들어갈 것 배열에 넣기
		JMenu screenMenu = new JMenu("Screen");//JMenu만들어 변수에 넣어주기
		MenuActionListener menuListener = new MenuActionListener();//이벤트 선언
		for (int i = 0; i < 4; i++) {
			menuItems[i] = new JMenuItem(itemTitles[i]);//배열 넣어주기
			menuItems[i].addActionListener(menuListener);//메뉴 아이템에 있는  i에 리스너를 달아주기
			screenMenu.add(menuItems[i]);//JMenu에 넣어주기
		}
		menuBar.add(screenMenu);//메뉴바에 스크린메뉴 추가해주기
		setJMenuBar(menuBar);//메뉴바 넣기
	}
	//이벤트 달기 / 인터페이스 이용 / 하나만 존재하여 어댑터가 없다
	class MenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// System.out.println(e.getActionCommand()); //내가 어떤 명령어를 준건지 알 수 있다 (Load,Hide등등)
			String command = e.getActionCommand();//정보 값을 command에 넣어주기
			switch (command) {
			//더미 이미지 이용하여 불러온 이미지
			case "Load": //로드라면
				imgLabel.setIcon(new ImageIcon("images/nature02.jpg"));//아이콘 불러와서 뽑아 넣어주기
				break;
			case "Hide":
				imgLabel.setVisible(false);
				break;
			case "Reshow":
				imgLabel.setVisible(true);
				break;
			case "Exit":
				System.exit(0);
				break;
			}
		}
	}

	public static void main(String[] args) {
		new MenuActionEventTest();
	}
}
