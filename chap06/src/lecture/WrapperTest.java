package lecture;
//Wrapper ��ü ���� - �⺻ Ÿ���� Ŭ����ȭ�� 9���� Ŭ���� (�� 8���� ��ü�� �ְ� �⺻ Ÿ���� ���� ��ü�� �ٷ� �� �ְ� ��)

public class WrapperTest {
	
	public static void main(String[] args) {
		char ch01 = 'A';
		char ch02 = '4';
		char ch03 = 'F';
		String num = "10";
		
		
		//�빮�ڸ� �ҹ��ڷ� �������ִ� ��ü
		System.out.println("ch01 == "+Character.toLowerCase(ch01));
		//wrapper��ü(Ŭ����)�� static �޼���(parseInt)�� int�� �ٲ㼭 ����Ҷ� ���
		//static �޼���� Ŭ���� �����̱� ������ �տ� �ٷ� Integer��� Ŭ������ �ٷ� �ٿ� ����Ҽ� �ִ�
		System.out.println("num == "+Integer.parseInt(num) + 10);
		//isDigit - ���� Ÿ�� ������ �´��� �ƴ��� true false �� ǥ��
		System.out.println("ch02 == "+Character.isDigit(ch02)); 
		
		
		Integer ten = 10; //Boxing (�⺻ Ÿ��(10)�� ���� Ÿ��(�ڽ� - ten)���� ���δ� ��) - ten.���� �ؼ� Ŭ������ �ִ� static�޼���(��ü)�� �ҷ��� �� �� �ִ�(ex)parsiInt ���� �������� ��ü ��� ����)
		int intTen = ten;//un Boxing - �ٽ� �ڽ��� Ǯ���ִ°� Ŭ���� ��ü�� �ҷ��� ����� �� ����
		int age = Integer.parseInt("10");//�ڵ����� auto un boxing�� ���ִ� ��  
		//age��� ���� �Ѱܹ޾Ҵٰ� ������ string�� ������ ���� ������ �̷��� �ٷ� ��ȯ�� �����ϴ�

		
		int num02 = 10;
		Integer num02Obj = num02;  //boxing
		System.out.println("num02Obj=="+num02Obj);// 10 ���
		int sum = 10 + num02Obj;  //unboxing
		System.out.println("sum==="+sum);// 20 ���
		
		
	}
}
