package lecture;

import java.util.Scanner;

public class ArrayExample_02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr03[] = new int[5]; // �迭 ���� = �迭 ���� ����
		int total= arr03.length; //������ ������ �ٶ� ���
		int max =0;
		System.out.println("����"+total+"���� �Է��Ͻÿ�.");
		for(int i=0;i<total;i++) {
			arr03[i] = scanner.nextInt();
			if(arr03[i]>max) {
				max= arr03[i];
			}
		}
		System.out.println(arr03[2]); // ���� ū �� ������ϱ�
		System.out.println(max); 
	}

}
