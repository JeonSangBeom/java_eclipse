package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Chap0703 {
	public static void main(String[] args) {
		HashMap<String,Integer> nations = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("나라이름과 인구를 입력하세요. ex) 한국 5000");
		//나라이름과 인구 hashmap에 넣어주기
		while(true) {
			System.out.println("나라 이름, 인구");
			String nation = scanner.next();
			if(nation.equals("그만")) break;
			int num = scanner.nextInt();// 하나씩 입력 받아서
			nations.put(nation, num); //HashMap에 넣어주기
		}	
		//HashMap 반복문 - 한번에 전부 나오게
		Set<String> keys = nations.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name+"의 인구는 "+nations.get(name));
		}
		//검색할때
		while(true) {
			String nation = scanner.next();
			if(nation.equals("그만")) break;
			Integer num = nations.get(nation);// 키 값으로 뒤에 있는 것을 출력
			if(num==null) System.out.println("입력하신 나라는 없어요.");
			else System.out.println(nation+"의 인구는 "+nations.get(nation));
		}
	}
}




