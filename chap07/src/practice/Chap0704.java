package practice;
// 입력한 강슈량 숫자만큼 평균 구하기
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Chap0704 {
	//함수를 불러와 쓰고 싶을때 static안에 static이 있어야만 사용 가능
	public static void showRainAvg(Vector<Integer> vector) { // 이 매개변수로 지정한 vector에서 값을 뽑아서 평균 내기
		int sum = 0;
		//벡터에 들어가 있는 값 다 더해서 갯수만큼 나누기
		Iterator <Integer> it = vector.iterator();//utill에 있는 iterator 받아오기
//		for(int i=0;i<vector.size();i++) { // iterator 말고 다른 방법
//			int num = vector.get(i);
//			sum+=num;
//		}
		while(it.hasNext()) {
			int num = it.next();
			sum+=num;
		}		
		System.out.println("강수량 평균은 "+ (sum/vector.size()));// 만든 합계의 값 나누기/ 전체 갯수
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<Integer> vector = new Vector<>();
		while(true) {
			System.out.println("강수량을 입력하시면 평균을 알려드립니다. (0 입력시 종료) >>");
			int rainAmount = scanner.nextInt();
			if(rainAmount==0) break;
			vector.add(rainAmount);
			showRainAvg(vector); // 0 입력 전까지 계속 출력해주는 함수(static으로 선언)
		}
		System.out.println("종료 되었습니다");
	}
}

