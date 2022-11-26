package practice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.css.Rect;
//ġŲ ������
class ChickenThread extends Thread {
	private JLabel target;
	public ChickenThread(JLabel target) {
		this.target = target;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				try {
					Thread.sleep(1000);// 0.02�ʸ��� �����̴µ� �ȿ����̰� �� ��� 1������ ���߾��
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				//e.printStackTrace();
			}
			int x = target.getX() - 5;//�·� 5�� �̵�
			int y = target.getY();
			if(x<-64) target.setLocation(500,y);//x�� -64���� �۾����� �ٽ� 500�� ��ġ�� �̵�
			else target.setLocation(x,y);
			target.getParent().repaint();//�ٽ� �׸���(�ٽ� �׸��� ���� ������ �ƴ� �θ� �׸��� �ȴ�)
										//ġŲ�� �θ�
		}
	}
}
////////////////////////////////
//�Ѿ� ������
class BulletThread extends Thread {
	private JLabel target;
	private JLabel chicken; //ġŲ �޾ƿ���(Ŭ������ �������� �ֱ� ������ ���� �ҷ��;� �Ѵ�)
	private Thread chickenTh;
	public BulletThread(JLabel target, JLabel chicken, Thread chickenTh ) {
		this.target = target;
		this.chicken= chicken;
		this.chickenTh = chickenTh;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//�浹�� ���ǰɱ�
			if(hitChicken()) {//�浹�� �� ��� �Ѿ� �� ��ġ �̵�
				target.setLocation(250 - 5, 500 - 64 - 20);
				chickenTh.interrupt();//���� ����Ű��
				return;//�Ѿ� �� ��ġ �̵�
			} else {
				int x = target.getX();//���� ���θ� ���� ���� ����
				int y = target.getY() - 5;//���� �̵��� -5��(���� ��ġ���� -5�� ����� -5�Ǵ� ��ġ�� ������ �ٽ� ����)
				if(y < -10) {// �Ѿ� ũ�Ⱑ 10�̱� ������ -10�� ������ ��������� ����Ų��
					target.setLocation(250 - 5, 500 - 64 - 20);
					target.getParent().repaint();
					return;//���߰� return �� �ֱ�
				} else {
					target.setLocation(x,y);
				}
				target.getParent().repaint();
			}
		}
	}
	// �浹�Ǵ� �κ�
	//Rectangle rect = new Rectangle(); -> �̷� ��ü�� ���߿� ����ϰ� �ȴ�(�浹������ ����ϰ� �ȴ�(intersects(������))
	private boolean hitChicken() {
		if(targetContains( target.getX(),target.getY() ) ) {
			return true;
		} else {
			return false;
		}
	}
	private boolean targetContains(int x, int y) {
		if( 
			(( chicken.getX() <= x ) && ( chicken.getX()+ chicken.getWidth()  >= x )) &&//x�� ��ġ ��(ġŲ�� x�� �ȿ� ������ �۵�)
			(( chicken.getY() <= y ) && ( chicken.getY()+ chicken.getHeight() >= y )) //y�� ��ġ
		  ) return true;//�� ������ �� �ƴ� ��� false
		else return false;
	}
}

////////////////////////////////
//���� �г�
class GamePanel extends JPanel {
	private JLabel chicken;//JLabel�� �� �̹��� �ֱ�
	private JLabel spaceShip;//
	private JLabel bullet;//�Ѿ�
	//���� class�� ���� ������ ������ ���
	private ChickenThread chickenTh;
	private BulletThread bulletTh;
	public GamePanel() {
		this.setLayout(null);//������� �������� �ϱ⋚���� null��
		this.setPreferredSize(new Dimension(500, 500));//ũ�� ���ϱ�
		
		//�̹��� �ҷ��� �� ���̺� �ֱ�
		ImageIcon imgChicken = new ImageIcon("images/hen02.png");
		ImageIcon imgSpaceShip = new ImageIcon("images/spaceship.png");
		//���� �� �̹��� �ֱ�
		chicken = new JLabel(imgChicken);
		chicken.setSize(imgChicken.getIconWidth(), imgChicken.getIconHeight());//�̹��� ������ ũ��
		chicken.setLocation(500 - 64, 0);//�ϴ� �г� ������ �̵�
		spaceShip = new JLabel(imgSpaceShip);
		spaceShip.setSize(imgSpaceShip.getIconWidth(), imgSpaceShip.getIconHeight());
		spaceShip.setLocation(250 - 32, 500 - 64);//���� �ϴ� ���߾ӿ� ����
		//�Ѿ��� ���� �׷� ���
		bullet = new JLabel();
		bullet.setOpaque(true);
		bullet.setBackground(Color.RED);//����
		bullet.setSize(10, 10);//ũ��
		bullet.setLocation(250 - 5, 500 - 64 - 20);
		
		//�гο� �ֱ�
		this.add(chicken);
		this.add(spaceShip);
		this.add(bullet);
		
		//���� �� Ÿ�� ������ �־��ֱ�
		chickenTh = new ChickenThread(chicken);
		chickenTh.start();
		//Ű�̺�Ʈ�� ����ҽ� ��Ŀ�� ���� �ʼ�
		this.setFocusable(true);
		this.requestFocus();
		
		//����Ű�� �������� �۵�
		this.addKeyListener(new KeyAdapter() {
			BulletThread bulletTh = null; //���� �ѹ��� �����Ǳ� ������ Alive�� ������� ������ �۵� �Ұ�
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(bulletTh == null || !bulletTh.isAlive()) {//���� null�϶��� �۵��ϰ� �����
						//!bulletTh.isAlive() - ������� �ʴٸ��� ��
						bulletTh = new BulletThread(bullet,chicken,chickenTh);
						bulletTh.start();
						//System.out.println("Enter");
					}
				}
			}
		});
//		bulletTh = new BulletThread(bullet,chicken);
//		bulletTh.start();
	}
}

////////////////////
//���� ���� �Լ�
public class Chap1305 extends JFrame {
	public Chap1305() {
		this.setTitle("���� ��ƶ�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(new GamePanel());
		
		this.setSize(500, 500);
		this.setResizable(false);//ũ�� ���� ���ϰ� ����		
		this.pack();//Dimension �� �Բ� ��� ũ�⸦ �����ֱ� ���ؼ�
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Chap1305();
	}
}
