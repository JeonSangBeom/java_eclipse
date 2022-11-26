package lecture;
//DrawImageTest
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawImageTest extends JFrame {
	private ImgPanel imgPanel = new ImgPanel();
	public DrawImageTest() {
		this.setTitle("그림 그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(imgPanel); 
		// 기존 JFrame이 가지고 있는 Container(Panel)늘 내가 만든 MyPanel로 바꾸겠다
		this.setSize(800,800);
		this.setVisible(true);
	}
	//그림 그릴 곳
	class ImgPanel extends JPanel {
		private ImageIcon imgIcon = new ImageIcon("images/jun.jpg"); // 그림 가져오기
		private Image img = imgIcon.getImage();//이미지 변수에 넣기(뽑아오기) - 쉽게 말하면 캡쳐
		
		public void paintComponent(Graphics g) {
			//super.paintComponent(g);
			repaint();//기존 것을 지우고 다시 그려준다 위와 비슷
			g.setClip(50,50,300,300);//자르는 방법 중 하나(따로 쓰기)
			g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);
			//(그릴이미지, 좌표0,0,getWidth(),this.getHeight() (꽉채워 쓸때 사용), this-그림이 다그려지고 나에게 알려주겠단 뜻)
			
			//글 달기
			g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,48));
			g.drawString("JUN JI HYUN",100,100);
			
			
			//g.drawImage(img, 0,0,300,300,100,100,300,300,this); // 자르기 (좌표,크기 / 100,100에서 부터 300,300까지 자르기)
		}
	}
	public static void main(String[] args) {
		new DrawImageTest();
	}
}
