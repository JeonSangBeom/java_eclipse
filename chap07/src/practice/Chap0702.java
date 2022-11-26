package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Chap0702 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("6개의 학점ㅇ르 빈칸으로 입력하시오. abcdef >>");		
		
		ArrayList<Character> scoreList = new ArrayList<>();//리턴타입 Character
		String str = scanner.next();
		
		for (int i = 0; i < 6; i++) {
			char ch = str.charAt(i); //charAt(0) 0번 위치에 있는 것을 뽑는 것
			scoreList.add(ch);
		}
		System.out.println(scoreList.get(5));// 불러올수 있는 것은 6개 초과되면 무효
		
		double sum = 0;//평균을 내야 하기 때문에 sum 미리 선언
		for (int i = 0; i < 6; i++) {
			char ch = scoreList.get(i);
			switch (ch) {// ch를 받았을때
				case 'a':sum += 4.0;break; //소문자 a라면 sum에 4 더하기
				case 'b':sum += 3.0;break;
				case 'c':sum += 2.0;break;
				case 'd':sum += 1.0;break;
				case 'f':sum += 0.0;break;
			}
		}
		System.out.println(sum/scoreList.size());
	}
}
