import java.awt.Color;

import javax.swing.JFrame;

public class GameMain extends JFrame {//JFrame 상속 및
	GameMain() { // 생성자 생성
		this.setTitle("Alien Game"); //타이틀 명
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //기본 닫기 작업 설정
		this.setResizable(false);//크기 조정 가능 설정
		
		GamePanel gamePanel= new GamePanel();//게임 패널을 따로 생성자로 만들어서 gamePanel대체
		this.setContentPane(gamePanel); //내용 창 설정 - gamePanel의 설정을 따르겠다
		
		//this.setLocationRelativeTo(null); //화면 중앙에 띄우기
		this.setVisible(true); // 표시 가능
		this.pack(); // 사이즈를 정하지 않고 자식한테 맞추는 것 ( gamePanel를 생성하여 거기서 받아오게 만든다 - 크기를 만들어 둬야 한다
	}
	public static void main(String[] args) { //메인도 하나 생성
		new GameMain();//생성자 불러오기
	}
}





