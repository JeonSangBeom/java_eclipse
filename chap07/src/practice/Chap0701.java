package practice;
//연습문제 - 입력한 값 중에 제일 큰 숫자를 찾기
import java.util.Scanner;
import java.util.Vector;

public class Chap0701 {
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-1 입력할때까지 >>");
		while(true) {
			int num = scanner.nextInt();
			if(num==-1) break;// 빠져나갈 길
			vector.add(num); // -1이 아닐경우 계속 추가하여 넣어주기
		}
		
		int max = vector.get(0);
		for(int i=0;i<vector.size();i++) { //size vector 갯수만큼
			if(vector.get(i) > max) {
				max= vector.get(i);
			}
		}
		System.out.println("제일  큰 숫자는 "+max);
	}
}
