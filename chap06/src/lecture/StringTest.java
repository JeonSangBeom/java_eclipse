package lecture;
//String�� ���� ����
public class StringTest {
	public static void main(String[] args) {
		String str01 = "abcd"; // ������ new ���� �ٷ� ����
		char strList [] = {'a','b','c','d'};
		String str02 =  new String(strList); //������ ��Ģ - �̷��� ����� �� ���� ���Ƶ� ��ü�� ������ �Ǿ� �� ������ ���� ���� ������� ����ҽ� �ΰ��� ���� �����ص� ���� ������ �����ϰ� ���
		String str03 = new String("a/b/cd"); // String ��� ��� 3����
		String str04 = "   abcd      ";
		String subject = "ũ���������� ���������ϴ�. �츮�� �� 1�� 3�� ���� �ʴ� �ɱ��....";
		
		//�񱳽�
		System.out.println("������" + str01.equals(str03)); //string�� �ȿ� ������ ������ ���� �ɷ� ����� �ȴ� �񱳽� equals��� �ʼ�
		
		System.out.println(str01.charAt(0)); //charAt()�ȿ� �Է��ϴ� ���ڿ� ���� String�� ������ ���� ��� / a ���
		System.out.println(str01.contains("ab"));//contains - ���� ����(ad���� ���� false ����� �ȴ� - �񿬰�) / true ���
		System.out.println(str01.length());// length - �Ѱ��� / 4 ���
		System.out.println(str03.split("/")[2]); //split("/") �ȿ� ���� ���ڿ� ���� �ɰ� �� �迭�� �����. �� �� [2] �� �ִ� ������ ���� ���/ cd ���
		System.out.println(str04.trim().charAt(0)); //trim - �� �ڰ����� ���� ���� ������ / trim�� ���ҽ� �ƹ��͵� ����� �ȵȴ� / a ���
		
		System.out.println(str01+str02); // abcdabcd ���
		System.out.println(str01.concat(str02)); // string ����Ǫ ��½� �� �ΰ��� ��� ��� //abcdabcd ���
		System.out.println(subject.substring(0,10)+"..."); //substring - ��� �ϴ� �ε��� ���� �� ����(���� ���� /ũ���������� ������... ���
		
	}
}
