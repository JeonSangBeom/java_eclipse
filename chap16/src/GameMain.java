import java.awt.Color;

import javax.swing.JFrame;

public class GameMain extends JFrame {//JFrame ��� ��
	GameMain() { // ������ ����
		this.setTitle("Alien Game"); //Ÿ��Ʋ ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�⺻ �ݱ� �۾� ����
		this.setResizable(false);//ũ�� ���� ���� ����
		
		GamePanel gamePanel= new GamePanel();//���� �г��� ���� �����ڷ� ���� gamePanel��ü
		this.setContentPane(gamePanel); //���� â ���� - gamePanel�� ������ �����ڴ�
		
		//this.setLocationRelativeTo(null); //ȭ�� �߾ӿ� ����
		this.setVisible(true); // ǥ�� ����
		this.pack(); // ����� ������ �ʰ� �ڽ����� ���ߴ� �� ( gamePanel�� �����Ͽ� �ű⼭ �޾ƿ��� ����� - ũ�⸦ ����� �־� �Ѵ�
	}
	public static void main(String[] args) { //���ε� �ϳ� ����
		new GameMain();//������ �ҷ�����
	}
}





