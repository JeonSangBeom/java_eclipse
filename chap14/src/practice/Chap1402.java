package practice;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class Chap1402 extends JFrame {
	private JLabel imgLabel = new JLabel();
	private ImagePanel imgPanel = new ImagePanel(); 
	Chap1402() {
		this.setTitle("���� ���⿡�� �̹�����ο��̿�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		Container contentPane = this.getContentPane();
//		this.setContentPane(imgPanel);//�߰� ��� �̷������� ��ġ�� �Ͽ��� ����� ����
		contentPane.add(imgPanel);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("����");
		JMenuItem openItem = new JMenuItem("����");
		openItem.addActionListener(new OpenActionListener());//�̺�Ʈ �ɱ�
		fileMenu.add(openItem);
		menuBar.add(fileMenu);
		this.setJMenuBar(menuBar);
	}
	class OpenActionListener implements ActionListener{
		private JFileChooser fileChooser;
		OpenActionListener() {
			fileChooser = new JFileChooser();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			fileChooser.showOpenDialog(null);// ���� �α� �ҷ����� ���̰� �����
			String filePath = fileChooser.getSelectedFile().getPath();//�̹��� ���
			ImageIcon imgIcon = new ImageIcon(filePath);//�̹��� �����ܿ� ��� �ֱ� (�̾ƿ���)
			Image image = imgIcon.getImage();//���
			imgPanel.setDrawImage(image);//�̹����гο� ��ƿ� �̹��� �־��ֱ�(������ Ŭ���� ImagePanel)
			//imgLabel.setIcon(new ImageIcon(filePath));
		}
	}
	//��ο� �̹��� ���
	class ImagePanel extends JPanel{
		private Image img = null;//���޹��� �̹���(��ο� �̹����� ����ϱ� ����)
		public void setDrawImage(Image img) {
			this.img = img;
			repaint();
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		}
	}
	
	public static void main(String[] args) {
		new Chap1402();
	}
}





