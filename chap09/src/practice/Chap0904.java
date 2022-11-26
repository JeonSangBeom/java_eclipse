package practice;
//컬러 바꿔주기
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Chap0904 extends JFrame {
	
	public Chap0904() {
		
		this.setTitle("Grid");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(1,10));
		JButton btns[] = new JButton[10];
		Color colors[] = {Color.RED,
						  Color.ORANGE,
						  Color.BLUE,
						  Color.GREEN,
						  Color.CYAN,
						  Color.MAGENTA,
						  Color.GRAY,
						  Color.PINK,
						  Color.BLACK,
						  Color.DARK_GRAY,
						  }; // 배열로 색상 미리 정해두기
		int total = btns.length;
		for(int i=0;i<total;i++) {
			btns[i] = new JButton(Integer.toString(i));
			btns[i].setOpaque(true); // 불투명을 사용하겠다(백그라운드 색깔을 사용할시 무조건 필수)
			//btns[i].setBackground(colors[i]); // 정해둔 배열로 사용할때
			//btns[i].setBackground(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256))); // 랜덤하게 색상을 사용하고 싶을 때
			btns[i].setBackground(new Color(255,0,0));// 내가 알고 있는 색상으로 사용할 경우 
			btns[i].setForeground(Color.WHITE); // 글자색
			contentPane.add(btns[i]);
		}
		this.setSize(500,200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Chap0904();
	}
}





