package practice;
// ������ �ܾ ���� �̾� ���ϋ�
public class Chap0608 {

	public static void main(String[] args) {
		String str = "I LOVE YOU";
//		System.out.println(str.substring(0, 1)); // I ���
//		System.out.println(str.substring(1)); //LOVE YOU ���
		System.out.println("���� == "+str.length()); // 10��
		for(int i=0;i<str.length();i++) {
			String first = str.substring(0, 1);//str.substring(0(���� ����), 1(����)  - ù���� ���ڸ� ������ ���
			String rest = str.substring(1); 
			str = rest+first;
			System.out.println(str);
			
		}
	}
}
