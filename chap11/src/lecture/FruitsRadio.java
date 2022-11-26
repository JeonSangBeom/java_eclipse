package lecture;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

class FruitsRadio extends JFrame {
	//제네릭 사용 - 이렇게 콜렉션 배열을 이용하여 내가 받을 것을 미리 써두면 형변환을 굳이 일일이 하지 않아도 된다
	private ArrayList<JRadioButton> fruits = new ArrayList<>();
	private ArrayList<ImageIcon> images = new ArrayList<>();
	private JLabel imageLabel = new JLabel();
	public FruitsRadio() {
		this.setTitle("라디오 테스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		//패널 하나 생성
		JPanel radioPanel = new JPanel();
		
		//이미지 불러오기
		ImageIcon appleIcon = new ImageIcon("images/apple.png");
		ImageIcon lemonIcon = new ImageIcon("images/lemon.png");
		ImageIcon berryIcon = new ImageIcon("images/strawberry.png");
		
		//배열에 추가
		images.add(appleIcon);
		images.add(berryIcon);
		images.add(lemonIcon);
		
		// 라디오 버튼 생성
		JRadioButton apple = new JRadioButton("사과");
		JRadioButton berry = new JRadioButton("딸기");
		JRadioButton lemon = new JRadioButton("레몬");
		
		// 만들어둔 패널에 넣어주기
		radioPanel.add(apple);
		radioPanel.add(berry);
		radioPanel.add(lemon);
		//라디오를 만들땐 이렇게 그룹을 생성해둬야 한다 / 다른거 체크시 기존 체크 사라지기
		ButtonGroup radioGroup = new ButtonGroup();
		//재등록
		radioGroup.add(apple);
		radioGroup.add(berry);
		radioGroup.add(lemon);
		
		contentPane.add(radioPanel,BorderLayout.NORTH);// 만들어둔 패널에 정보 입력후 레이아웃에 넣어주기
		contentPane.add(imageLabel,BorderLayout.CENTER);
		
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);// 가운데 정렬
		imageLabel.setIcon(images.get(0)); // 시작하자마자 이미지 넣어두기(사과) / 제네릭을 이용하여 배열에 미리 선언해두었기 때문에 여기서 형 봔환을 굳이 하지 않아도 된다
		
		fruits.add(apple);
		fruits.add(berry);
		fruits.add(lemon);
		
		this.setSize(250,300);
		this.setVisible(true);
		
		//반복문 돌려서 fruits에 있는 것들 전부 꺼내서 listener 달아보기
		MyItemListener listener = new MyItemListener();//선언
		for(int i=0;i<fruits.size();i++) {
			JRadioButton radio = fruits.get(i);
			radio.addItemListener(listener);
		}
	}
	class MyItemListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {//선택 되었다면				
				if(fruits.get(0).isSelected()) imageLabel.setIcon(images.get(0));
				//0번인 사과가 맞으면(isSelected 뜻) imageLabel 패널의 이미지를 0번으로 얻어오겠다
				else if(fruits.get(1).isSelected()) imageLabel.setIcon(images.get(1));
				else if(fruits.get(2).isSelected()) imageLabel.setIcon(images.get(2));
			} else {
				
			}
		}
	}
	
	public static void main(String[] args) {
		new FruitsRadio();
	}
}
