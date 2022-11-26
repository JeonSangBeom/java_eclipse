package lecture;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {// 자바의 실행 파일은 main메서드가 있어야 한다
		
		//Book slamdunk = new Book(); -> 오류 발생 / 클래스 안(Book.java)에 생성자를 하나라도 정의를 해둔상태에서는 디폴트로 생성이 안된다
		//생성자 오버로딩 
		Book noTitleBook = new Book(); // 아무것도 호출않을 시 북에 공백으로 처리한 값이 호출된다
		
		System.out.println(noTitleBook.author);
		
		//두가지 정의해둔 매개변수로 예습
		Book littlePrince = new Book("어린왕자","생떽쥐베리");
		//littlePrince.author = "Sang DDaggi"; / 나중에 속성을 밑에서 바꿔서 쓸수 있다
		System.out.println("test===="+littlePrince); //test====lecture.Book@5e91993f 넣어놓은 title나 author이 아닌 통합된 값을 출력하면 아무것도 뜨지 않는다
		System.out.println(littlePrince.title+"==="+littlePrince.author);
		Book chunHyangJun = new Book("춘향전");
		System.out.println(chunHyangJun.title+"==="+chunHyangJun.author);
		
		
		//입력한 책 세권 나오게 하기
		Book bookList[] = new Book[3];
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<bookList.length;i++) {
			System.out.println("제목을 쓰세요.");
			String title = scanner.nextLine(); //nextLine 띄어쓰기 가능한 줄 단위로 받을 떄 사용
			System.out.println("저자를 입력하세요.");
			String author = scanner.nextLine();
			bookList[i] = new Book(title,author);
		}
		//만들어둔 메서드 이용
		for(int i=0;i<bookList.length;i++) {
			bookList[i].showBookInfo();
		}
		int n = 10;
		bookList[2].methodTest(n); // 11 출력
		System.out.println("n값은 11로 바뀌었을까요?==="+n); // 답은 10으로 나온다
		scanner.close();
	}

}





