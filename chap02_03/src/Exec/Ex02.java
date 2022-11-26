package Exec;

public class Ex02 {

//	public static void main(String[] args) {
//		int n[][] = { { 1 }, { 1, 2, 3 }, { 1 }, { 1, 2, 3, 4 }, { 1, 2 } };
//		for (int i = 0; i < n.length; i++) {
//			for (int j = 0; j < n[i].length; j++) {
//				System.out.println(n[i][j] + "");
//			}
//			System.out.println();
//		}
//	}
	//각 열의 평균을 구할 때
	
	public static void main(String[] args) {
		int n[][] = { { 1 }, { 1, 2, 3 }, { 1 }, { 1, 2, 3, 4 }, { 1, 2 } };
		for (int i = 0; i < n.length; i++) {
			int sum = 0;
			for (int j = 0; j < n[i].length; j++) {
				System.out.print(n[i][j] + "\t");
				sum += n[i][j];
			}
			System.out.println((double) sum / n[i].length);
		}
	}
}

