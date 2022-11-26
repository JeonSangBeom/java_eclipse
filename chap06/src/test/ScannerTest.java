package test;
//패키지 구현 설명(import)
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		char ch = 'a';
		int num = 10;
		//String str = "aaa";// String는 new라는 생성자를 통해 객체를 선엉하여 생성해야하지만 자주 사용하여 string는 스킵 가능
		Scanner scanner = new Scanner(System.in);
		//java.util.Scanner scanner = new Scanner(System.in); import를 안할 경우 이렇게 사용		
		Scanner scanner02 = new Scanner(System.in);
		Scanner scanner03 = scanner;
		//주요 기본 메서드 (Object 클래스에 포함된것) 
		System.out.println(scanner.hashCode()); // hashCode - 메모리 주소 값
		System.out.println(scanner03.hashCode());
		System.out.println(scanner.equals(scanner03));//equals - 비교 하는 법(클래스 비교시 사용)
	}
}
