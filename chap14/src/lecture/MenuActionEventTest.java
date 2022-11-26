package lecture;
//�޴��� ���� - �׼� �̺�Ʈ
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuActionEventTest extends JFrame {
	private JLabel imgLabel = new JLabel(); //���� �ҷ��� ���� ��

	public MenuActionEventTest() {
		this.setTitle("�޴���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(imgLabel, BorderLayout.CENTER);// �߾ӿ� ���̱�
		createMenu();

		this.setSize(300, 300);
		this.setVisible(true);
	}
	//�޴��� ���� �޼��� (�ݺ��� ���)
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar(); // ���� �� ����
		JMenuItem menuItems[] = new JMenuItem[4];// �迭 �̿�
		String itemTitles[] = { "Load", "Hide", "Reshow", "Exit" };// JMenu�Ʒ� �� �� �迭�� �ֱ�
		JMenu screenMenu = new JMenu("Screen");//JMenu����� ������ �־��ֱ�
		MenuActionListener menuListener = new MenuActionListener();//�̺�Ʈ ����
		for (int i = 0; i < 4; i++) {
			menuItems[i] = new JMenuItem(itemTitles[i]);//�迭 �־��ֱ�
			menuItems[i].addActionListener(menuListener);//�޴� �����ۿ� �ִ�  i�� �����ʸ� �޾��ֱ�
			screenMenu.add(menuItems[i]);//JMenu�� �־��ֱ�
		}
		menuBar.add(screenMenu);//�޴��ٿ� ��ũ���޴� �߰����ֱ�
		setJMenuBar(menuBar);//�޴��� �ֱ�
	}
	//�̺�Ʈ �ޱ� / �������̽� �̿� / �ϳ��� �����Ͽ� ����Ͱ� ����
	class MenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// System.out.println(e.getActionCommand()); //���� � ��ɾ �ذ��� �� �� �ִ� (Load,Hide���)
			String command = e.getActionCommand();//���� ���� command�� �־��ֱ�
			switch (command) {
			//���� �̹��� �̿��Ͽ� �ҷ��� �̹���
			case "Load": //�ε���
				imgLabel.setIcon(new ImageIcon("images/nature02.jpg"));//������ �ҷ��ͼ� �̾� �־��ֱ�
				break;
			case "Hide":
				imgLabel.setVisible(false);
				break;
			case "Reshow":
				imgLabel.setVisible(true);
				break;
			case "Exit":
				System.exit(0);
				break;
			}
		}
	}

	public static void main(String[] args) {
		new MenuActionEventTest();
	}
}
