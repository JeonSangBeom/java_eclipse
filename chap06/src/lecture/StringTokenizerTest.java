package lecture;
//StringTokenizer  설명 - 버퍼나 토큰이나 string로 할 수 있지만 더 편하게 쓰기 위해 사용하는 것들
import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		String query = "name=장성호&age=20&weight=80";
		StringTokenizer st = new StringTokenizer(query,"&"); // query를 &로 분리 하겠다
		//System.out.println(query.split("&")[0]); - 배열 생성 및 출력
		
		System.out.println(st.countTokens());//countTokens() - token이 몇개인지 확인 가능 - 3출력
		while(st.hasMoreTokens()) {// token은 반복문을 돌릴 수 있다 hasMoreTokens() - 갯수를 모를때 전부 출력시 사용(다음 토큰이 있으면 출력해라)
			System.out.println(st.nextToken());//.nextToken()을 해당 객체 뒤에 써 주어야 프린트되어 값이 나온(while방식 안에 조건이 만족이 되면 반복하여 계속 실행)
		}
		//System.out.println(st.nextToken()); / 단순히 이렇게 출력을 하면 naem=장성호만 뜬다 
		//System.out.println(st.nextToken()); / age=20 출력 - 배열처럼 순차적으로 출력 
	}
}
