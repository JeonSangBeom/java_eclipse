package lecture;

public class Dowhile {

	public static void main(String[] args) {
		//a~z
				char ch = 'a';// ���� ����ǥ�� ��� 
				do {
//					System.out.println("���� dowhile�Դϴ�. �켱 �ѹ� �����մϴ�. �׸��� ������ ������ �ݺ����� �����մϴ�.");
					System.out.println(ch);
					ch= (char)(ch+1); //ū �ڽ��� ������ �־ ������ ������ ū �ڽ��� �ְ� �Ǹ� ĳ���� ������ ���� ��������Ѵ�
				}while(ch <= 'z'); //1.do ���� 2. ����(while)�� ������ �׵� ��� �����Ѵ�
			}
}
