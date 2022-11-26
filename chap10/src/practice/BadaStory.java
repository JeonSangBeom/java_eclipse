package practice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BadaStory extends JFrame {
	
	public BadaStory() {
		this.setTitle("바다이야기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JFrame은 기본 적으로 JPanel을 하나 가지고 있는데
		//기존 사용 방식의 Container contentPane = this.getContentPane(); = 기본 패널 가져오기 
		//위의 방식과 바꿔서 사용한 것이 아래 사용한 방식이다
		GamePanel gamePanel = new GamePanel();
		
		this.setContentPane(gamePanel);
		
		this.setSize(500,300);
		this.setVisible(true);
	}
	
	class GamePanel extends JPanel{
		private JLabel resultLabel = new JLabel("START");
		private JLabel labelList [] = new JLabel[3];
		public GamePanel() {
			this.setLayout(null);
			resultLabel.setSize(200,30);// Label 크기 가로200 세로30의 크기의 사각형 생성
			resultLabel.setLocation(150,200);
			resultLabel.setOpaque(true);
			resultLabel.setBackground(Color.YELLOW);
			resultLabel.setHorizontalAlignment(JLabel.CENTER);//글자 가운데 정렬
			this.add(resultLabel);
			for(int i=0;i<labelList.length;i++) {
				labelList[i] = new JLabel("0");
				labelList[i].setSize(100,50);//사각형 크기
				labelList[i].setLocation(90+(100+10)*i,80); // 위치 (처음은 90부터 시작, 그다음 거기서 + 가로길이 100 + 여백 10)
				labelList[i].setOpaque(true);//보이게 하기
				labelList[i].setBackground(Color.MAGENTA);//배경 색상
				labelList[i].setForeground(Color.YELLOW);//글자 색상
				labelList[i].setFont(new Font("Arial",Font.BOLD,36));//폰트설정
				labelList[i].setHorizontalAlignment(JLabel.CENTER);//글자 가운데 정렬
				this.add(labelList[i]);
			}
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						int random01 = (int)(Math.random()*5);
						int random02 = (int)(Math.random()*5);
						int random03 = (int)(Math.random()*5);
						labelList[0].setText(Integer.toString(random01)); // toString는 Integer에 속해 있다
						labelList[1].setText(Integer.toString(random02));
						labelList[2].setText(""+random03); 
						if(random01==random02 && random02==random03) {// 세개가 같을때 GOOD LUCK 뜨게 만들기
							resultLabel.setText("GOOD LUCK");
							resultLabel.setBackground(Color.RED);
						}else {
							resultLabel.setText("A SHIP DA");
							resultLabel.setBackground(Color.YELLOW);
						}
					}
				}
			});
			this.setFocusable(true);
			this.requestFocus();
		}
	}
	
	public static void main(String[] args) {
		new BadaStory();
	}

}
