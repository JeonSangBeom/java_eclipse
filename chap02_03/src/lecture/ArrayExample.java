package lecture;

import java.util.Scanner;

public class ArrayExample { //public - ���� ������(�ܺο� ������ �ϴ��ĸ� ������ ��)
	//class�� �⺻ Ÿ��(�������� Ÿ��(int ���)���� �־�δ� ������ ���� �ǰ� �� �ȿ� int���� �Լ� �� ������ �� �� �ִ�(���� �ٲٰ� �;� �� �� �ִ� �ൿ���� ������ ���� ��
	//class ���ο� ����� �������� �Ӽ�(�ʵ�), ���ο��� ����� �Լ����� �޼���� �Ѵ� �̷��� �͵��� ���߿� new(��ü�� ������ ȣ��)��� �����ڸ� ���� �� �� �ִ�
	//Ŭ���� ������ �빮�ڰ� ��Ģ�̴�
	//Ÿ���� ������ ���� ������ ���� �ٲٰ� �Ͱų� �ൿ���� �����ص� ��
	
//�迭
	public static void main(String[] args) {//�����̶�� �Լ�(�޼���)�� args��� �Ű������� String��� �迭(�Ӽ�)�� ������ �ִ� 
		//void �Լ��� ������ ������ �Ұ�� �ٸ� int()���� ���� �� �ξ�� �Ѵ� �׷��� ���� ��� void���
		int arr[] = new int[10];// �迭 ����� �� []�� ���̳� �ڳ� ��� ���� �ڿ������� ArrayList(�ְ� ���⿡ �����ϴ�)�� �� ���� �� ��
		// �̸� ���صθ� �� �̻��� �� ���� ����
		//������ ������ ���ǵǾ� �ִ� ������ new�� �̿��ϸ� ó�� ��Ÿ���� ��
		arr[0] = 10;
		arr[1] = 15;
		arr[2] = 17;
		arr[3] = 32;
		arr[4] = 80;
		System.out.println(arr[5]);// 0~9������ �� �� �ִ�, ���ص��� ���� ���� �Է½� 0�� ���´�
		int arr02[] = { 1, 2, 3, 100, 5, 4, 50 };// ������ �����Ӱ� �� �� �ִ�{}�ȿ� ������ �Ἥ ��� ����
		System.out.println(arr02[3]);
		
		Scanner scanner = new Scanner(System.in);//new Scanner(System.in)��ĳ�ʸ� ����(������ ��)
		int arr03 [] = new int[5];
		int total = arr03.length;
		int max = 0;
		System.out.println("���� "+total+"���� �Է��Ͻÿ�.");
		for(int i=0;i<5;i++) {
			arr03[i] = scanner.nextInt();
			if(arr03[i] > max) {
				max = arr03[i];
			}
		}
		System.out.println(arr03[2]); // �� ��° �� ����ϱ�
		System.out.println(max);// ���� ū �� ����ϱ�
		
	}

}
