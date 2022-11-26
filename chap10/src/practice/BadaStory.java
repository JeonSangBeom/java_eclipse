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
		this.setTitle("�ٴ��̾߱�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JFrame�� �⺻ ������ JPanel�� �ϳ� ������ �ִµ�
		//���� ��� ����� Container contentPane = this.getContentPane(); = �⺻ �г� �������� 
		//���� ��İ� �ٲ㼭 ����� ���� �Ʒ� ����� ����̴�
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
			resultLabel.setSize(200,30);// Label ũ�� ����200 ����30�� ũ���� �簢�� ����
			resultLabel.setLocation(150,200);
			resultLabel.setOpaque(true);
			resultLabel.setBackground(Color.YELLOW);
			resultLabel.setHorizontalAlignment(JLabel.CENTER);//���� ��� ����
			this.add(resultLabel);
			for(int i=0;i<labelList.length;i++) {
				labelList[i] = new JLabel("0");
				labelList[i].setSize(100,50);//�簢�� ũ��
				labelList[i].setLocation(90+(100+10)*i,80); // ��ġ (ó���� 90���� ����, �״��� �ű⼭ + ���α��� 100 + ���� 10)
				labelList[i].setOpaque(true);//���̰� �ϱ�
				labelList[i].setBackground(Color.MAGENTA);//��� ����
				labelList[i].setForeground(Color.YELLOW);//���� ����
				labelList[i].setFont(new Font("Arial",Font.BOLD,36));//��Ʈ����
				labelList[i].setHorizontalAlignment(JLabel.CENTER);//���� ��� ����
				this.add(labelList[i]);
			}
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						int random01 = (int)(Math.random()*5);
						int random02 = (int)(Math.random()*5);
						int random03 = (int)(Math.random()*5);
						labelList[0].setText(Integer.toString(random01)); // toString�� Integer�� ���� �ִ�
						labelList[1].setText(Integer.toString(random02));
						labelList[2].setText(""+random03); 
						if(random01==random02 && random02==random03) {// ������ ������ GOOD LUCK �߰� �����
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
