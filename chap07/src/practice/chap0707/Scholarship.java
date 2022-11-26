package practice.chap0707;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Scholarship {
	private HashMap<String,Double> scoreMap = new HashMap<>();// <이름과 학점만 있으면 되는 문제>
	private Scanner scanner = new Scanner(System.in);
	private String title;

	public Scholarship(String title) {
		this.title = title;
	}
	
	//값 입력(5명)
	private void record() {
		System.out.println(title+" 장학금 관리 시스템입니다.");
		for(int i=0;i<5;i++) {
			System.out.print("이름과 학점을 입력하시오. >>");
			String name = scanner.next();
			double score = scanner.nextDouble();
			scoreMap.put(name, score);
		}
	}
	//출력
	private void select() {
		System.out.println("장학생 선발 기준 학점을 입력하시오. ex) 3.2");
		double min = scanner.nextDouble(); // 기준 값 설정
		System.out.println("장학생 명단은 아래와 같습니다..");
		//hashmap 반복
		Set<String> keys  = scoreMap.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();
			double score = scoreMap.get(name);
			if(score>=min) {
				System.out.print(name+"/");
			}
		}
		System.out.println();
	}
	public void run() {
		record();
		select();
	}
	//record
	//select
}






