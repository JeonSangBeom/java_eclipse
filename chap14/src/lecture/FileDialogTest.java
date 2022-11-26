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
		this.setTitle("���� Dialog �ڽ� �ߴ� test");
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
		
		this.setJMenuBar(menuBar);// ���� ��ü�� �ٿ��ֱ�
		openItem.addActionListener(new OpenActionListener());//openItem�� �������� �ɼǶ߰� �ϱ�
	}
	//�̺�Ʈ �ɱ�
	class OpenActionListener implements ActionListener {
		private JFileChooser fileChooser = new JFileChooser();
		//������ / ���ص� ���� ����� ���´�
		/*
		 * OpenActionListener() { fileChooser = new JFileChooser();// ���� ���̾�α� }
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = 
					new FileNameExtensionFilter("images", "jpg","gif","png"); // �̰͸� ���̰� ���� �ɱ�
			fileChooser.setFileFilter(filter);//���� ó�� �־��ֱ�
			fileChooser.showOpenDialog(null);// ���� ���̾�α� ���̰� �ϱ�
			String filePath = fileChooser.getSelectedFile().getPath();//getSelectedFile - ���� ������ ���� getPath - ��� ������
			imgLabel.setIcon(new ImageIcon(filePath));// ��� �־� �ҷ�����
		}
		
	}
	public static void main(String[] args) {
		new FileDialogTest();
	}
}





