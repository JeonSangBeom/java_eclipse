package test;

import lecture.Book;
 //접근 제한자 설명 
public class Test {

	public static void main(String[] args) {
		Book book = new Book(); // 패키지가 달라도 임폴트를 하면 불러다 쓸 수 있다(public)
		//패키지가 다른 상황에서 public가 아니면 가져다 쓸 수 없다
	}

}
