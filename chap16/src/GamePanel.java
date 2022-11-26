import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
//GamePanel - ���� ȭ�� �׸��� / �̺�Ʈ
public class GamePanel extends JPanel { //setContentPane�� ��� �������� JPanel�� ��� �޾ƾ߸� �����ϴ�
	// �׸� �׸��� ����
	private Image bufferImage; // ���� �̹��� ����� ����Ʈ
	private Graphics screenGraphics;// screenGraphics ����Ʈ
	
	//��� �̹��� �ҷ�����
	private Image loadingImage = new ImageIcon("images/loading_page.jpg").getImage();
	private Image startImage = new ImageIcon("images/start_page.jpg").getImage();
	
	private Game game;// ������ �����ϰ�(GameŬ���� �̿��� �ϱ� ����) 
	
	//���¸� ��Ÿ���� ���� ����(�����̹����� �Ѿ��)
	private String isState = "start";
	private int num=0;
	GamePanel() { //������ �ϳ� ���� - �⺻ ũ�� �� ���� ������ �ϸ� GameMain���� ������ pack�� ��� �޾� ��Ÿ����
		this.setPreferredSize(new Dimension(1200, 800));//�⺻ ���� ũ�� ���� /Dimension(ġ��)-��� ��߸� �Դ´�
		this.setOpaque(true);//������ ����
		this.setBackground(Color.BLACK);//��� ����
		gameInit();//�Ʒ� ������Ų gameInit()�� �ҷ� ���� GamePanel���� ����
	}

	public void gameInit() { // ���� ������ �ϳ� �صд� (������ ���� ���� �޼��� ����)
		game = new Game(); // �������� �����ص� �� ����
		
		//Ű �̺�Ʈ ���� �⺻ �ɼ�
		this.setFocusable(true);//Ű �̺�Ʈ ���� ���� �� �ְ� ���ش�(���� ����)		
		this.requestFocus();//Ű �̺�Ʈ ���� ���� �� �ְ� ���ش�(������ �� ��û)
		
		// Ű�� �̺�Ʈ�� �ް�(Ű����� �̹��� �̵���Ű�� ����� �̺�Ʈ) / KeyListener(�������� ������ ���) -�������̵� �ڵ� ����
		this.addKeyListener(new KeyListener() { 
			@Override//�����Ұ�� �׳� �־� �Ѵ�
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {//keyReleased - Ű�� ���� ����
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT: // ������ ���ٰ� ���� false�� �༭ ���� �ش�
					game.isLeft = false;
					break;
				case KeyEvent.VK_RIGHT:
					game.isRight = false;
					break;
				case KeyEvent.VK_UP:
					game.isUp = false;
					break;
				case KeyEvent.VK_DOWN:
					game.isDown = false;
					break;
				case KeyEvent.VK_SPACE:
					game.isShoot = false;
					break;
				}
			}
			@Override
			public void keyPressed(KeyEvent e) { // keyPressed - Ű�� ��������
				// System.out.println(e.getKeyCode());
				switch (e.getKeyCode()) {// Ű ���� ��� ����
				case KeyEvent.VK_LEFT:// ����1 ����� Ű���尡 ������ ������
					game.isLeft = true;//game�� �ִ� false ���� true�� ���� 
					break;
				case KeyEvent.VK_RIGHT:
					game.isRight = true;
					break;
				case KeyEvent.VK_UP:
					game.isUp = true;
					break;
				case KeyEvent.VK_DOWN:
					game.isDown = true;
					break;
					
				case KeyEvent.VK_SPACE: // �Ѿ� ������ ��
					game.isShoot = true;
					break;		
					
				case KeyEvent.VK_R:
					//game = new Game();
					//game.isOver= false; ���� ����ŸƮ �ϰ� �ϴ� ��� - ���� ���߿��� R�� ������ �ٽ� �����ϴ� ���� �߻�
					if(game.isOver) isState="start";//game�� �ִ� isOver�� ���϶��� R�� ���� �� �ְ� - ������ isState�� start�� �ٲ��ش�
					break;
				case KeyEvent.VK_ENTER:
					if(isState=="start") { //���� ������ ���� isState�� start���
						startGame();// �޼��� �ҷ��ͼ� isState�� loading�� �ȴ�
					}
					break;
				case KeyEvent.VK_ESCAPE: // Ű���� esc�� ������ �ݾ����� ������ ���ش�
					System.exit(0);
					break;
				}
			}
		});
	}
	private void startGame() {// ������ ���۵Ǹ�
		isState="loading"; // ���� isstate ������ loading���� ����
		//�ð� ���� - �ð� ������ ���� �����ϰ�
		Timer loadingTimer = new Timer();// Timer ����Ʈ - �ϳ��� ������ 
		TimerTask loadingTimerTask = new TimerTask() { //���� ���� �ٴϸ� setTimeout�� ����
			@Override
			public void run() {// 3�� �ڸ� �ٲ�� (�Ʒ� ������ ��)
				isState = "gaming"; 
				game = new Game();
			}
		};
		loadingTimer.schedule(loadingTimerTask, 3000); // 3�ʵ� �����ϰڴ�(������)
	}
	
	
	
	
	
	// double buffering ��� ( �ϳ��� �÷��̾ �����ϴ� ���� �ƴ� ȭ��ĸóó�� �����ϸ� �ȴ�)
	public void paintComponent(Graphics g) {//�׸� �׸���		
		// 1. ���� �̹��� ����
		// 2. �޸� �� �ø���
		// 3. graphics �� �׸���
		num++;
		bufferImage = this.createImage(1200, 800); // ���� �̹����� �̹����� �ϳ� �����صΰ�(�г� ũ��) - Image Ŭ����
		screenGraphics = bufferImage.getGraphics();//screenGraphics�� �̹��� �ֱ� - Graphics Ŭ������
		screenCapture(screenGraphics);// screenGraphics�� �̹��� �ȿ� ������ �׸� �ֱ�
		g.drawImage(bufferImage, 0, 0, null); // �׸��� ��� �̹��� �� �������� ��ü������ �ѹ� �׷��ֱ�(�̰� �ݺ��� �ȴ�(���� �̹����� ��ǥ ũ�� null��))
	}	

	public void screenCapture(Graphics g) {// ��� ȣ�� �Ǵ� ��
		if(isState.equals("start")) {// ���ڷ� equals ���
			g.drawImage(startImage,0,0,null);//���� �̹���
		} else if(isState.equals("loading")) {
			g.drawImage(loadingImage,0,0,null);
		} else {
			game.drawAll(g); // ķ���� �̹����� ���ӿ��� ������ ����(�׸��� �� �Ѿ�, ����� �� ����/ GameŬ������ public�� �޼��� ������ ����)
		}
		repaint(); // ©���� ���� �߻��� ���� ���� ���(�ٽ� �׷��ش�)
	}
}
