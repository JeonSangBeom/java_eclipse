package lecture;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {// �ڹ��� ���� ������ main�޼��尡 �־�� �Ѵ�
		
		//Book slamdunk = new Book(); -> ���� �߻� / Ŭ���� ��(Book.java)�� �����ڸ� �ϳ��� ���Ǹ� �صл��¿����� ����Ʈ�� ������ �ȵȴ�
		//������ �����ε� 
		Book noTitleBook = new Book(); // �ƹ��͵� ȣ����� �� �Ͽ� �������� ó���� ���� ȣ��ȴ�
		
		System.out.println(noTitleBook.author);
		
		//�ΰ��� �����ص� �Ű������� ����
		Book littlePrince = new Book("�����","�����㺣��");
		//littlePrince.author = "Sang DDaggi"; / ���߿� �Ӽ��� �ؿ��� �ٲ㼭 ���� �ִ�
		System.out.println("test===="+littlePrince); //test====lecture.Book@5e91993f �־���� title�� author�� �ƴ� ���յ� ���� ����ϸ� �ƹ��͵� ���� �ʴ´�
		System.out.println(littlePrince.title+"==="+littlePrince.author);
		Book chunHyangJun = new Book("������");
		System.out.println(chunHyangJun.title+"==="+chunHyangJun.author);
		
		
		//�Է��� å ���� ������ �ϱ�
		Book bookList[] = new Book[3];
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<bookList.length;i++) {
			System.out.println("������ ������.");
			String title = scanner.nextLine(); //nextLine ���� ������ �� ������ ���� �� ���
			System.out.println("���ڸ� �Է��ϼ���.");
			String author = scanner.nextLine();
			bookList[i] = new Book(title,author);
		}
		//������ �޼��� �̿�
		for(int i=0;i<bookList.length;i++) {
			bookList[i].showBookInfo();
		}
		int n = 10;
		bookList[2].methodTest(n); // 11 ���
		System.out.println("n���� 11�� �ٲ�������?==="+n); // ���� 10���� ���´�
		scanner.close();
	}

}





