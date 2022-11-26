package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CoffeeMachine extends JFrame {
	CoffeePanel coffeePanel = new CoffeePanel();
	CoffeeMachine() {
		this.setTitle("Coffee Machine");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		//패널 3개 만들어 사용
		contentPane.add(new TitlePanel(),BorderLayout.NORTH);
		contentPane.add(new ButtonPanel(),BorderLayout.SOUTH);
		contentPane.add(coffeePanel,BorderLayout.CENTER);
		
		this.setSize(500, 500);
		this.setVisible(true);
	}
	//제목 패널 생성
	class TitlePanel extends JPanel {
		private JLabel title = new JLabel("Welcome Hot Coffee");
		TitlePanel() {
			this.setBackground(Color.MAGENTA);
			title.setForeground(Color.WHITE);
			title.setFont(new Font("Arial",Font.BOLD,20));
			this.add(title);
		}
	}
	//버튼 패널 생성
	class ButtonPanel extends JPanel {
		private JButton btns[] = new JButton[4]; 
		private String coffeeTitles[] = 
			{"Black Coffee","Sugar Coffee","Dabang Coffee","Reset"};
		ButtonPanel() {
			for(int i=0;i<4;i++) {
				btns[i] = new JButton(coffeeTitles[i]);
				this.add(btns[i]);
				//이벤트 걸기
				btns[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//System.out.println(e.getActionCommand()); // 클릭 되는 명령어 호출
						coffeePanel.makingCoffee(e.getActionCommand());//액션을 취할때 작동
					}
				});
			}
		}
	}
	//커피 위치 패널 생성
	class CoffeePanel extends JPanel {
		private String coffeeTitles[] = {"Cup","Coffee","Water","Sugar","Cream"};
		private CoffeeBox coffeeBoxes[] =  new CoffeeBox[5];
		private JLabel coffeeImgLabel;
		private ImageIcon coffeeIcon = new ImageIcon("images/coffee.png");
		CoffeePanel() {
			this.setLayout(null);
			//라벨 및 박스라벨 넣어주기
			for(int i=0;i<5;i++) {
				coffeeBoxes[i] = new CoffeeBox();
				coffeeBoxes[i].setLocation(i*(50+10)+100, 50);//50위치에 10 여백/ 전체에 양쪽 100씩 여백
				coffeeBoxes[i].setSize(50, 120);
				JLabel label = new JLabel(coffeeTitles[i]);// 글 넣기
				label.setSize(50, 30);
				label.setLocation(i*(50+10)+100, 170);
				label.setHorizontalAlignment(JLabel.CENTER);
				this.add(coffeeBoxes[i]);
				this.add(label);
			}
			//커피 이미지 넣어주기
			coffeeImgLabel = new JLabel();
			coffeeImgLabel.setLocation(
					(500-coffeeIcon.getIconWidth())/2, 220);//coffeeIcon.getIconWidth() - 128(넓이) - 가운데 설정
			coffeeImgLabel.setSize(
					coffeeIcon.getIconWidth(),coffeeIcon.getIconHeight());
			//coffeeImgLabel.setIcon(coffeeIcon);
			this.add(coffeeImgLabel);
		}
		
		//커피 동작 메서드
		public void makingCoffee(String command) {
			//System.out.println("동작중..");
			//System.out.println(command); //이벤트에서 던진 매개변수 받아와서 사용 가능
			if(command=="Black Coffee") {
				//System.out.println("나는 블랙커피");
				//비어있을 경우 만들어둔 메서드 발동 // 0이 되면 에러 메시지와 리턴
				if(coffeeBoxes[0].isEmpty() || 
				   coffeeBoxes[1].isEmpty() || 
				   coffeeBoxes[2].isEmpty()) {
					errorMessage();
					return;
				}
				// 만들어둔 메서드 current --1씩 / blackcoffee클릭시 소모
				coffeeBoxes[0].consume();
				coffeeBoxes[1].consume();
				coffeeBoxes[2].consume();
				
			} else if(command=="Sugar Coffee") {
				if(coffeeBoxes[0].isEmpty() || 
			       coffeeBoxes[1].isEmpty() || 
				   coffeeBoxes[2].isEmpty() ||
				   coffeeBoxes[3].isEmpty()
				   ) {
					errorMessage();
					return;
				}
						
				coffeeBoxes[0].consume();
				coffeeBoxes[1].consume();
				coffeeBoxes[2].consume();
				coffeeBoxes[3].consume();
			} else if(command=="Dabang Coffee") {
				if(coffeeBoxes[0].isEmpty() || 
			       coffeeBoxes[1].isEmpty() || 
				   coffeeBoxes[2].isEmpty() ||
				   coffeeBoxes[3].isEmpty() ||
				   coffeeBoxes[4].isEmpty() 
						   ) {
					errorMessage();
					return;
				}
				coffeeBoxes[0].consume();//컵
				coffeeBoxes[1].consume();//커피
				coffeeBoxes[2].consume();//물
				coffeeBoxes[3].consume();//설탕
				coffeeBoxes[4].consume();//크림
			} else {
				//System.out.println("리셋");
				coffeeBoxes[0].reset();
				coffeeBoxes[1].reset();
				coffeeBoxes[2].reset();
				coffeeBoxes[3].reset();
				coffeeBoxes[4].reset();
				repaint();
				return;//infoMessage를 피하기 위해 내부에서 리턴
			}
			repaint();
			coffeeImgLabel.setIcon(coffeeIcon);// 클릭할때 이미지 나오게
			infoMessage(command);
			coffeeImgLabel.setIcon(null);//이미지 사라지게
			
		}
		public void infoMessage(String coffeeName) {
			JOptionPane.showMessageDialog(
					null,coffeeName+"나왔습니다.", "COFFEE",JOptionPane.INFORMATION_MESSAGE);
		}
		//에러메시지 메서드
		public void errorMessage() {
			JOptionPane.showMessageDialog(
					null,"부족한게 있습니다. 추가하여 주세요", "COFFEE",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	//커피박스 라벨 생성
	class CoffeeBox extends JLabel {
		private double total = 3;
		private double current = total;
		CoffeeBox() {			
		}
		//이미지 그리기
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.GRAY);
			int y = 120 - (int)((current/total*120));//120(높이) - 10으로 나눈 값
			//System.out.println(current/total);
			g.fillRect(0, y, this.getWidth(), this.getHeight() - y);//커피 패널의 값을 따라가게
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);//선 보이게 하기 위해 / 커지면 패널에 가려 안보인다
		}
		//커피 소비할때 발생할 메서드
		public void consume() {
			current--;
		}
		//리셋 메서드 
		public void reset() {
			current = total;
		}
		//비어있는지 확인할 메서드
		public boolean isEmpty() {
			if(current<=0) return true;//0이 되었을경우 참
			else return false;
		}
	}
	
	
	public static void main(String[] args) {
		new CoffeeMachine();
	}
}
