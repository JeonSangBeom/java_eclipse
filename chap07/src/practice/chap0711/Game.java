package practice.chap0711;

import java.util.Scanner;
import java.util.Vector;

public class Game {
	private Vector<Nation> countries = new Vector<>();
	private Scanner scanner = new Scanner(System.in);
	
	public Game() { // 생성자 - 생성되자 마자 7개가 만들어져 있게 설정
		countries.add(new Nation("한국","서울"));
		countries.add(new Nation("미국","워싱턴"));
		countries.add(new Nation("중국","베이징"));
		countries.add(new Nation("일본","도쿄"));
		countries.add(new Nation("영국","런던"));
		countries.add(new Nation("프랑스","파리"));
		countries.add(new Nation("호주","캔버라"));
	}
	
	private boolean contain(String country) { // 외부로 노출될 필요가 없으니 private로 생성
		for(int i=0;i<countries.size();i++) {
			String searchedCountry = countries.get(i).getCountry();//나라 이름을 찾는 코드
			if(searchedCountry.equals(country)) {
				return true; //찾은 것과 입력받은 country가 같으면 참
			}
		}
		return false;
	}
	//추가 될수 있게 
	public void record() {
		int total = countries.size();
		int count =  total; // 숫자 증가할때마다 사용
		System.out.println("현재 "+total+"개의 나라가 입력되어 있습니다.");
		while(true) {
			System.out.print("나라와 수도 입력"+count+">>");
			String country = scanner.next();// 글자만 입력시 next 사용 
			if(country.equals("그만")) break;
			String capital = scanner.next();
			//기존에 입력이 되어 있어 중복이 되면 안된다.
			//조건이 까다로워 메소드 하나 생성하여 사용
			if(contain(country)) { // 메서드 boolean사용 한 것 불러와 사용 참일 경우
				System.out.println(country+"기본에 입력되어 있는 나라입니다.");
				continue; // 건너띄기 역할
			}
			//아닐 경우에만 더해주기
			countries.add(new Nation(country,capital));
			count++;
		}
	}
	public void run() {
		System.out.println("*** 수도 맟추기 게임을 시작합니다 ***");
		while(true) {
			System.out.print("입력 : 1, 퀴즈 : 2, 종료 : 3");
			int selectMenu = scanner.nextInt();
			switch(selectMenu) { // 입력 받을게 정해져 있을 경우 switch가 좋다
				case 1:record(); break;
				case 2:quiz(); break;
				case 3:finish(); return;
				default : error();
			}
		}
	}
	private void quiz() {
		 //System.out.println(�굹�씪�씠由�+"�쓽 �닔�룄�뒗 ?");
		while(true) {
			int random = (int)(Math.random()*countries.size()); // 랜덤하여 뽑기 (int)로 형변환 필요
			Nation nation = countries.get(random); // 순서 불러와서 아래에 넣어서 출력
			String country = nation.getCountry();
			String capital = nation.getCapital();
			//문제 출제
			System.out.println(country+"수도는 ?");
			String userAnswer = scanner.next(); // 사용자가 값을 입력
			if(userAnswer.equals("그만")) break;
			if(userAnswer.equals(capital)) System.out.println("정답입니다.");
			else System.out.println("땡");
		}
	}
	private void error() {
		System.out.println("잘못 눌렀습니다. 1,2,3 중에 눌러 주세요");
		
	}
	private void finish() {
		 System.out.println("종료합니다.");
	}
	
	
}





