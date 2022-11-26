package practice;
//반복하여 시간이 변하는것을 보여주기
import java.awt.Container;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

class ClockLabel extends JLabel implements Runnable {
	private int x = 100;
	private int y = 100;
	private Thread th;

	//생성자
	public ClockLabel() {
		this.setFont(new Font("맑은 고딕",Font.BOLD,48));//글 속성 설정
		this.setHorizontalAlignment(JLabel.CENTER);//위치 가운데 넣기
		this.setText(makeTime());//JLabel에 입력
		th = new Thread(this);
		th.start();
	}
	//한자리수로 떨어지면 0이 안생기기 때문에 필요
	private String addZero(int num) {
		if(num<10) return "0"+num;
		else return ""+num;
	}
	//글자얻어올 메서드 생성
	public String makeTime() {
		Calendar calendar = Calendar.getInstance();//calendar불러오기
		String hour = addZero(calendar.get(Calendar.HOUR_OF_DAY));
		String min = addZero(calendar.get(Calendar.MINUTE));//integer toString가 이제 필요 없다 String를 리턴하기 때문에
		String sec = addZero(calendar.get(Calendar.SECOND));
		
		String txt = hour+":"+min+":"+sec;
		return txt;
	}

	//반복하여 시간이 변하는것을 보여주기
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				//System.out.println("왜");
				this.setText(makeTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class Chap1303 extends JFrame {
	public Chap1303() {
		this.setTitle("Thread");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.add(new ClockLabel());
		//this.setContentPane(new ClockLabel()); //Label은 패널이 아니어서 이렇게 사용 불가

		this.setSize(500, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Chap1303();
	}
}
