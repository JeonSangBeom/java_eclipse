package practice;
// �Է��� �ܾ� ���� Ȯ��
import java.util.Scanner;
import java.util.StringTokenizer;

public class Chap060701 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println(">>");
			String str =  scanner.nextLine();
			if(str.equals("�׸�")) break; // ���ڿ��� �׸��� ������ ���߱�(equals - ���� ��)
			//StringTokenizer st = new StringTokenizer(str," "); / ���� StringTokenizer
			//System.out.println("�Է��Ͻ� ������ �ܾ� ������ "+st.countTokens()); - countTokens ���� Ȯ��
			
			//�ٸ� ���
			String words[] = str.split(" ");// ������ ���� ��ŭ ���ڸ� ���� ����
			System.out.println("�Է��Ͻ� ������ �ܾ� ������ "+words.length);
		}
	}
}
