package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chap1311 extends JFrame {
	//전역변수로 선언
	GamePanel gamePanel;
	InputPanel inputPanel;
//////////기본 생성자 
	public Chap1311() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setContentPane();
		//컨테이너 패널 생성
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		//만든 패널 선언
		gamePanel = new GamePanel();
		inputPanel = new InputPanel(gamePanel);
		//만들고 선언한 패널 넣기
		contentPane.add(gamePanel, BorderLayout.NORTH);
		contentPane.add(inputPanel, BorderLayout.SOUTH);
		
		
		this.setSize(500, 500);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}
/////////게임패널 생성
	class GamePanel extends JPanel {
		private JLabel resultLabel = new JLabel();//레이블 생성(결과 알려줄)
		private JLabel wordLabel = new JLabel();//내려갈 글자 
		private Words words;// 클래스로 만들어둔 words 가져오기
		private WordsThread wordTh;//스레드 가져오기
		//게임 패널 생성자
		GamePanel() {
			//기본 속성 옵션 설정
			this.setPreferredSize(new Dimension(400, 500));
			this.setLayout(null);
			this.setOpaque(true);
			this.setBackground(Color.LIGHT_GRAY);
			//레이블 추가 및 설정 입력
			this.add(resultLabel);
			resultLabel.setText("");//처음 공백 결과에 따라 글 나오게 하기 위해
			resultLabel.setLocation(10, 10);
			resultLabel.setSize(300, 30);
			resultLabel.setForeground(Color.WHITE);
			resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			//선언
			words = new Words();
			//내려갈 레이블 생성
			this.add(wordLabel);
			wordLabel.setText(words.getRandomWord());//words(얻어온 글자)에서 랜덤하게 입력받아 레이블에 쓰기
			wordLabel.setSize(200, 40);
			wordLabel.setLocation(300, -50);
			wordLabel.setForeground(Color.MAGENTA);
			wordLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
			
			wordTh = new WordsThread(this, resultLabel);
			wordTh.start();
			// System.out.println(words.getRandomWord());
		}
		//참 거짓 리턴할 메서드 생성 - wordLabel와 입력한 텍스트가 같으면 참
		public boolean matchWord(String txt) {
			if (wordLabel.getText().equals(txt))
				return true;
			return false;
		}
		//여러군데에서 사용할 것은 메서드를 만들어 사용하면 좋다(인풋,게임패널)
		public void printResult(String txt) {
			resultLabel.setText(txt);// 입력한 값으로 변환
		}
		//게임 멈추는 메서드(스레드 정지)
		public void gameStop() {
			if(wordTh==null) return;//스레드가 null일 경우는 반환(기존 스레드 없애기)
			wordTh.interrupt();//스레드를 멈춰라 catch 적용
		}
		//게임 시작 메서드
		public void gameStart() {
			//게임 재시작
			wordLabel.setText(words.getRandomWord());
			wordLabel.setSize(200, 40);
			wordLabel.setLocation(300, -50);
			wordLabel.setForeground(Color.MAGENTA);
			wordLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
			gameStop();
			//스레드 재생성
			wordTh = new WordsThread(this, resultLabel);
			wordTh.start();
		}
		
		//////떨어질 스레드 생성
		class WordsThread extends Thread {
			private GamePanel gamePanel;
			private JLabel resultLabel;

			WordsThread(GamePanel gamePanel, JLabel resultLabel) {
				this.gamePanel = gamePanel;
				this.resultLabel = resultLabel;
			}

			public void run() {
				while (true) {
					try {
						Thread.sleep(10);//속도 설정
						int y = wordLabel.getY() + 2;
						wordLabel.setLocation(wordLabel.getX(), y);//위치값을 이동시켜주기 아래로 내려가는 효과
						if (y >= gamePanel.getHeight() - 40) {//만약 y값이 게임패널 높이보다 40이 적을 경우
							gamePanel.printResult("Time Over!!!");//만들어둔 메서드 사용
							gamePanel.gameStart();
						}
						repaint();//다시 그려줘라
					} catch (InterruptedException e) {
						return;//스레드 종료
					}
				}
			}
		}
		
		// 1. words.txt 파일읽기
		// 2. Vector에 넣기
		// 3. 랜덤하게 글자 뽑기
		// 텍스트 파일 읽고 글자 뽑을 클래스 생성
		class Words {
			private Vector<String> wordVector = new Vector<>();//글자 넣을 백터 생성
			//생성자 생성
			public Words() {
				try { //파일을 읽어오면 IO이기 때문에 무조건 try catch를 해줘야 한다
					Scanner scanner = new Scanner(new FileReader("src/words.txt"));//파일 읽어오기
					while (scanner.hasNext()) {//읽어온 파일 다음게 있을 경우 반복
						wordVector.add(scanner.nextLine());//백터에 추가 (한줄씩)
					}
//					for(int i=0;i<100;i++) {
//						System.out.println(getRandomWord());
//					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			//랜덤하게 뽑을 메서드 생성
			public String getRandomWord() {
				int total = wordVector.size();// 백터에 있는것 전부 변수에 담기
				String selectedWord = wordVector.get((int) (Math.random() * total));// wordVector에 있는 값을 랜덤하게 얻어와 변수에 담기
				return selectedWord;
			}
			
		}

	}
////////글자 입력하는 인풋패널
	class InputPanel extends JPanel {
		private JTextField input = new JTextField(); // 입력할 필드 생성
		private GamePanel gamePanel; // 게임 패널에 있는 메서드를 사용하기 위해 가져오기

		InputPanel(GamePanel gamePanel) {
			this.gamePanel = gamePanel;
			this.setPreferredSize(new Dimension(500, 50));
			this.setOpaque(true);
			this.setBackground(Color.GRAY);
			this.setLayout(null);
			this.add(input);// 필드 추가
			//텍스트 필드 설정해주기
			input.setSize(400, 30);
			input.setLocation(50, 10);
			input.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));//텍스트 필드안 여백 설정
			//텍스트 필드 이벤트 달아주기
			input.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String txt = input.getText();// 필드에 있는 텍스트 값 얻어오기
					if (txt.equals("그만"))//그만을 치면
						System.exit(0);//게임 종료(패널 창 자체가 꺼진다)
					input.setText("");//입력 후 공백 처리
					if (gamePanel.matchWord(txt)) {// 조건이 맞으면(리턴값 불린- 참)
						gamePanel.printResult("Success");//이 단어 출력
						input.setText("");//입력한 곳 공백 후 
						gamePanel.gameStop();//게임 종료(스레드 정지)
						gamePanel.gameStart();//다시 게임 시작
					} else {//틀렸을 경우 재도전
						gamePanel.printResult("Try Again!!!");
					}
				}
			});
		}
	}
/////////////실행 함수
	public static void main(String[] args) {
		new Chap1311();
	}
}
