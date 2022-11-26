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
		this.setTitle("파일 열기에서 이미지드로우이용");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		Container contentPane = this.getContentPane();
//		this.setContentPane(imgPanel);//추가 대신 이런식으로 배치를 하여도 상관이 없다
		contentPane.add(imgPanel);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
		JMenuItem openItem = new JMenuItem("열기");
		openItem.addActionListener(new OpenActionListener());//이벤트 걸기
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
			fileChooser.showOpenDialog(null);// 파일 로그 불러오기 보이게 만들기
			String filePath = fileChooser.getSelectedFile().getPath();//이미지 경로
			ImageIcon imgIcon = new ImageIcon(filePath);//이미지 아이콘에 경로 넣기 (뽑아오기)
			Image image = imgIcon.getImage();//담기
			imgPanel.setDrawImage(image);//이미지패널에 담아온 이미지 넣어주기(만들어둔 클래스 ImagePanel)
			//imgLabel.setIcon(new ImageIcon(filePath));
		}
	}
	//드로우 이미지 사용
	class ImagePanel extends JPanel{
		private Image img = null;//전달받을 이미지(드로우 이미지를 사용하기 위해)
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





