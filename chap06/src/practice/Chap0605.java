package practice;

import java.util.Calendar;

public class Chap0605 {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();// calendarÀº new ´ë½Å ÀÌ·¸°Ô »ý¼º(ºÒ·¯¿À±â)
		int hour = now.get(Calendar.HOUR_OF_DAY); // 0~23½Ã±îÁö ¾ò¾î¿À±â
		if(hour>4 && hour<12) System.out.println("±» ¸ð´×");
		else if(hour>=12 && hour<18) System.out.println("±» ¾ÖÇÁÅÍ´«");
		else if(hour>=18 && hour<22) System.out.println("±» ÀÌºê´×");
		else System.out.println("±» ³ªÀÕ");
	}
}
