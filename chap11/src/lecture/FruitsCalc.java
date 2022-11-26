package lecture;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class FruitsCalc extends JFrame {
	private JLabel sumLabel;
	private ArrayList fruits = new ArrayList(); // 배열 생성
	
	public FruitsCalc() {
		this.setTitle("체크박스 테스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		ImageIcon appleIcon = new ImageIcon("images/apple.png");
		ImageIcon lemonIcon = new ImageIcon("images/lemon.png");
		ImageIcon berryIcon = new ImageIcon("images/strawberry.png");
		
		// 이미지만 넣는 방식
		JCheckBox apple = new JCheckBox(appleIcon);
		JCheckBox berry = new JCheckBox(berryIcon);
		JCheckBox lemon = new JCheckBox(lemonIcon);
		
		//상단 라벨 생성 및 추가
		contentPane.add(new JLabel("사과 : 5000 / 딸기 : 7000 / 레몬 : 3000"));
		//그 아래로 과일 그림 추가
		contentPane.add(apple);
		contentPane.add(berry);
		contentPane.add(lemon);
		
		//배열에 넣어주기
		fruits.add(apple);
		fruits.add(berry);
		fruits.add(lemon);
		MyItemListener listener = new MyItemListener();// 아래 만든 클래스 선언
		for(int i = 0;i<fruits.size();i++) { // arrayList는 size 사용
			//System.out.println(fruits.get(i)); // checkBox로 뭔가가 줄지어 출력된다
			JCheckBox checkBox = (JCheckBox) fruits.get(i);// JCheckBox로 형변환
			checkBox.setBorderPainted(true); // 테두리 생성
			checkBox.addItemListener(listener);// 선언한 listener 넣어줘서 한번에 사용
		}
		
		// 하단 가격표시 레이블 생성
		sumLabel = new JLabel("====PRICE : 0====");
		contentPane.add(sumLabel);
		
		this.setSize(250,300);
		this.setVisible(true);
	}
	
	//하나만 있는건 Adaptetr 없음...
	class MyItemListener implements ItemListener {
		private int sum = 0;
		@Override
		public void itemStateChanged(ItemEvent e) {
			System.out.println(e.getStateChange()); // getStateChange(int리턴) - 눌러지면(눌린상태) 1 , 아니면(다시 눌러서 원상태) 2  
			if(e.getStateChange()==ItemEvent.SELECTED) { // 선택된 것 = 1로 표시 되는 것
				//System.out.println(e.getItem());// 클릭한 것의 정보 출력
				if(e.getItem()==fruits.get(0)) sum+=5000; //선택된 것과 사과가 같으면 sum에 5000 플러스
				else if(e.getItem()==fruits.get(1)) sum+=7000; //딸기
				else  sum+=3000; //레몬
			} else {
				if(e.getItem()==fruits.get(0)) sum-=5000; //사과
				else if(e.getItem()==fruits.get(1)) sum-=7000; //딸기
				else  sum-=3000; //레몬
			}
			sumLabel.setText("====PRICE : "+sum+"===="); // 클래스가 내부에 있어서 sumLabel 사용 가능(전역변수)
		}
	}
	public static void main(String[] args) {
		new FruitsCalc();
	}
}
