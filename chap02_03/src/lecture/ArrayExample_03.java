package lecture;

import java.util.Scanner;

public class ArrayExample_03 {
	//�迭�� 5��¥�� �迭�� �Է¹޾Ƽ� ����� ��� ����غ���
	public static void main(String[] args) {
		int arr[] = new int[5];
		int sum = 0;
		int total = arr.length;
		double avg = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println(total + "�ټ��� ���� ���� �Է��� �ֽø� ����� ���ص帳�ϴ�.");
		for (int i = 0; i < total; i++) {
			arr[i] = scanner.nextInt();
		} // �߰�ȣ�� ������ ������ �Ƚᵵ �ȴ�
//		for (int j = 0; j < total; j++) {
//			sum += arr[j]; //  �ϳ��� ���ϱ� ���� ������ �迭 ����
//		}
		for(int k : arr) { //forEach(�ڹٽ�ũ��Ʈ�� �ִ�) �� ���� ����̴� k(���Ƿ� ���� ����)
			sum+=k;
		}
		avg = sum / total;
		System.out.println("�����" + avg);
		scanner.close();
		
		//string �ݺ� ����
		String fruits[] = {"apple","orange","banana","kiwi"};
		for(String item : fruits) {
			System.out.println(item+"=="); // ���� ���
		}
	}
}
