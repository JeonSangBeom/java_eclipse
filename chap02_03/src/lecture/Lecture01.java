package lecture;

public class Lecture01 {
	public static void main(String[] args) {
		//Ŭ������ �ݵ�� ù������ �빮�ڷ� ����Ͽ��� �Ѵ�
		//�ڹ� �ݺ��� for, while, do while
		//System.out.println("Hello World"); / sysout�� ġ�� ����ġ�� ���´�
		//�ڷ��� - int num = 10;, double = 10.0;(����) , char = 'a' , boolean(true,false), String ="sdfsd
		int sum = 0;
		for (int i = 0; i <= 10; i++) {
			sum = sum + i; // 1, 3, 6, 10, 15, 21 
			System.out.print(i);
			if(i==10) {
				System.out.print("=");
			}else {
				System.out.print("+");
			}//1+2+3+4+5+6+7+8+9+10=55
		}
		System.out.println(sum);
	}

}

