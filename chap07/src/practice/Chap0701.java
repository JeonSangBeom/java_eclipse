package practice;
//�������� - �Է��� �� �߿� ���� ū ���ڸ� ã��
import java.util.Scanner;
import java.util.Vector;

public class Chap0701 {
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-1 �Է��Ҷ����� >>");
		while(true) {
			int num = scanner.nextInt();
			if(num==-1) break;// �������� ��
			vector.add(num); // -1�� �ƴҰ�� ��� �߰��Ͽ� �־��ֱ�
		}
		
		int max = vector.get(0);
		for(int i=0;i<vector.size();i++) { //size vector ������ŭ
			if(vector.get(i) > max) {
				max= vector.get(i);
			}
		}
		System.out.println("����  ū ���ڴ� "+max);
	}
}
