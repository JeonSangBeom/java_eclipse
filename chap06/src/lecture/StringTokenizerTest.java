package lecture;
//StringTokenizer  ���� - ���۳� ��ū�̳� string�� �� �� ������ �� ���ϰ� ���� ���� ����ϴ� �͵�
import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		String query = "name=�强ȣ&age=20&weight=80";
		StringTokenizer st = new StringTokenizer(query,"&"); // query�� &�� �и� �ϰڴ�
		//System.out.println(query.split("&")[0]); - �迭 ���� �� ���
		
		System.out.println(st.countTokens());//countTokens() - token�� ����� Ȯ�� ���� - 3���
		while(st.hasMoreTokens()) {// token�� �ݺ����� ���� �� �ִ� hasMoreTokens() - ������ �𸦶� ���� ��½� ���(���� ��ū�� ������ ����ض�)
			System.out.println(st.nextToken());//.nextToken()�� �ش� ��ü �ڿ� �� �־�� ����Ʈ�Ǿ� ���� ����(while��� �ȿ� ������ ������ �Ǹ� �ݺ��Ͽ� ��� ����)
		}
		//System.out.println(st.nextToken()); / �ܼ��� �̷��� ����� �ϸ� naem=�强ȣ�� ��� 
		//System.out.println(st.nextToken()); / age=20 ��� - �迭ó�� ���������� ��� 
	}
}
