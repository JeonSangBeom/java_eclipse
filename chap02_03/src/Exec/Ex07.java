package Exec;

public class Ex07 {

	public static void main(String[] args) {
		int arr[] = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = (int)(Math.random()*10+1);
		}
		System.out.println("·£´ýÇÑ Á¤¼öµé :");
		double sum = 0;
		for(int i=0; i<10; i++) {
			System.out.println(arr[i]+"");
			sum+= arr[i];
		}
		System.out.println("\nÆò±ÕÀº"+sum/10);
	}

}
