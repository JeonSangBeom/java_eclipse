package lecture;
//HashMap���� - �ַ� �˻��Ҷ� ���
import java.util.HashMap;
import java.util.Scanner;
//{Ű:��}�� �ְ� Ű�� ���� ã�´�
public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String,String> dictionary = new HashMap<String,String>();//<Ű,��>
		dictionary.put("baby", "�Ʊ�");//���� �Է��Ҷ� put ��� / string�� �ޱ�� �Ͽ��� ������ �Ѵ� ���ڷ� �Է��� �Ͽ��� �Ѵ�
		dictionary.put("love", "���");
		dictionary.put("apple", "���");
		//System.out.println(dictionary.get("love")); // love��� Ű�� ������ ����� ���
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("ã�� �ܾ �Է����ּ���. exit ���� �����մϴ�.");
			String eng = scanner.nextLine(); // �Է� ���� ��(Ű)
			if(eng.equals("exit")) break;
			String kor = dictionary.get(eng);// eng�� ���� ���� �ֱ� ���� ������ ���� ������ ��� ���
			if(kor==null) System.out.println("���� �ܾ��Դϴ�.");   // eng�� ���� ���� �ٸ� ��� 
			else System.out.println(kor);
		}
	}
}
