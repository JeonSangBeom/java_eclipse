package lecture;
//stringBuffer ���� - �ٹٲ� ���� �ڹٽ�ũ��Ʈ������ `` �� ���
public class StringBufferTest {
	public static void main(String[] args) {
		//String�̶� ����.... ���� ���̸� �����Ѵ�.
		String str01 = new String("String");
		StringBuffer sb = new StringBuffer("a");
		sb.append(" pencil"); // �� �߰�
		sb.insert(2, "good "); // �ι�° �� ��ġ�� �Է�
		System.out.println(sb);//StringBuffer�� ����ؼ� ���� �߰��Ͽ� �� �� �ִ�
	}
}
