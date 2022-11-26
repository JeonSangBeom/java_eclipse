package lecture;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileDialogTest extends JFrame {	
	private JLabel imgLabel = new JLabel();
	
	public FileDialogTest() {
		this.setTitle("파일 Dialog 박스 뜨는 test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.add(imgLabel);
		createMenu();
		
		this.setSize(500, 300);
		this.setVisible(true);
	}
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		fileMenu.add(openItem);
		menuBar.add(fileMenu);
		
		this.setJMenuBar(menuBar);// 만든 전체를 붙여주기
		openItem.addActionListener(new OpenActionListener());//openItem을 눌렀을때 옵션뜨게 하기
	}
	//이벤트 걸기
	class OpenActionListener implements ActionListener {
		private JFileChooser fileChooser = new JFileChooser();
		//생성자 / 안해도 같은 결과가 나온다
		/*
		 * OpenActionListener() { fileChooser = new JFileChooser();// 파일 다이어로그 }
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = 
					new FileNameExtensionFilter("images", "jpg","gif","png"); // 이것만 보이게 필터 걸기
			fileChooser.setFileFilter(filter);//필터 처리 넣어주기
			fileChooser.showOpenDialog(null);// 파일 다이어로그 보이게 하기
			String filePath = fileChooser.getSelectedFile().getPath();//getSelectedFile - 내가 선택한 파일 getPath - 경로 얻어오기
			imgLabel.setIcon(new ImageIcon(filePath));// 경로 넣어 불러오기
		}
		
	}
	public static void main(String[] args) {
		new FileDialogTest();
	}
}





