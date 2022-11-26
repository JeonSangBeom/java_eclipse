package lecture;
//stringBuffer 설명 - 줄바꿈 없이 자바스크립트에서의 `` 이 기능
public class StringBufferTest {
	public static void main(String[] args) {
		//String이랑 유사.... 가변 길이를 제공한다.
		String str01 = new String("String");
		StringBuffer sb = new StringBuffer("a");
		sb.append(" pencil"); // 값 추가
		sb.insert(2, "good "); // 두번째 값 위치에 입력
		System.out.println(sb);//StringBuffer은 계속해서 값을 추가하여 쓸 수 있다
	}
}
