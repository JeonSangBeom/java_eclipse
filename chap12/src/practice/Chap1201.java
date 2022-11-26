package practice;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chap1201 extends JFrame {
	private ImgPanel imgPanel = new ImgPanel();
	public Chap1201() {
		this.setTitle("그림그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(imgPanel);

		this.setSize(300, 300);
		this.setVisible(true);
	}

	class ImgPanel extends JPanel {
		private boolean isShow = true;
		private ImageIcon imgIcon = new ImageIcon("images/jun.jpg");// 이미지 불러오기
		private Image img = imgIcon.getImage();//이미지 뽑아두기
		private JButton btn = new JButton("Hide / Show");//버튼 생성
		public ImgPanel() {
			this.setLayout(new FlowLayout());//디폴트 값
			this.add(btn);
			btn.addActionListener(new ActionListener() {// 바로 이벤트 걸어 사용
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("aaaa");
					isShow = !isShow; // 클릭시 isShow를 부정해서 false로 변경 시키는 것
//					if(isShow) isShow= false;
//					else isShow = true;
					repaint();// 그림 다시 불러오는것
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//조건 isShow라면(참이면) 그림을 그려라 - Boolean 타입의 변수 미리 생성 
			if(isShow) g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);//이미지 그리기
		}
	}

	public static void main(String[] args) {
		new Chap1201();
	}
}
