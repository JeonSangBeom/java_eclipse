package Exec;

import java.util.Scanner;

public class Ex04_02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print(">> ");
		int num01 = scan.nextInt();
		int num02 = scan.nextInt();
		int num03 = scan.nextInt();

		int mid = 0;
		mid = num01 > num02 ? (num01 > num03 ? (num02 > num03 ? num02 : num03) : num01)
				: (num02 > num03 ? (num01 > num03 ? num01 : num03) : num02);
		System.out.println("dfg" + mid);
		scan.close();
	}

}
