package lecture;

public class ForFor {
//°ö¼À½Ä
	public static void main(String[] args) {
		for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.print(i+"x"+j+"="+i*j);
				System.out.print('\t');
			}
			System.out.println();
//			System.out.println("2 &"+i+"="+2*i); //print·Î ÂïÀ¸¸é ÇÑÁÙ·Î ³ª¿À°Ô µÈ´Ù
//			System.out.println('\t'); // \t(ÅÇ ¿ªÇÒ)
		}
	}
}
