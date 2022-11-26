package practice;
// 문장의 단어를 빼서 이어 붙일떄
public class Chap0608 {

	public static void main(String[] args) {
		String str = "I LOVE YOU";
//		System.out.println(str.substring(0, 1)); // I 출력
//		System.out.println(str.substring(1)); //LOVE YOU 출력
		System.out.println("갯수 == "+str.length()); // 10개
		for(int i=0;i<str.length();i++) {
			String first = str.substring(0, 1);//str.substring(0(부터 시작), 1(까지)  - 첫번쨰 글자를 뽑을때 사용
			String rest = str.substring(1); 
			str = rest+first;
			System.out.println(str);
			
		}
	}
}
