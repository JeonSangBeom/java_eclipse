package Exec;

public class Ex01 {

	public static void main(String[] args) {
		int sum=0, i=0;
//		while(i<100) {
//			sum=sum+i;      //while 规过
//			i+=2;
//		}
		
//		for(i=0; i<100; i+=2) {
//			sum=sum+i;           //for 规过
//		}
		
		do {
			sum=sum+i;
			i+=2;            //dowhile规过
		}while(i<100);
		System.out.println(sum);
	}

}
