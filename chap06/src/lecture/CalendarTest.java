 package lecture;
//Calendar - 추상클래스 / 날짜를 찍는 것
import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();// new를 쓰지 않고 getInstance를 써줘야 리턴을 해준다(Calendar로 접근해야 함)
		//Calendar은 추상 클래스(이면서 implements로 인터페이스가 되어 있다)로 정의가 되어 있다(추상클래스는 new를 통해서 생성할 수가 없다
		//getInstance static로 정의해서 함수로 내보내져 있는 상태이다
		// get - 얻어온다는 뜻
		
		// 값을 불러오는 법
		//보통은 now. 으로 시작해서 불러오지만 year = 으로 해서 변수에 그 값을 넣어주는 방식을 사용한다 
		int year = now.get(Calendar.YEAR); 
		int month = now.get(Calendar.MONTH);
		int date = now.get(Calendar.DAY_OF_MONTH); // 오늘 요일
		int hour = now.get(Calendar.HOUR_OF_DAY); // 24시 기준
		int hour02 = now.get(Calendar.HOUR); // 12시 기준 시간
		int ampm = now.get(Calendar.AM_PM);
		int am = now.get(Calendar.AM);
		int pm = now.get(Calendar.PM);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);

		int day = now.get(Calendar.DAY_OF_WEEK);// 날짜
		System.out.println("day===" + day); // 토요일이라면 7이 뜬다

		System.out.println(year + "==" + (month + 1) + "===" + date); // 날짜를 제대로 쓰고 싶을 경우 +1을 해줘야 한다 // 해당년도 ==== 해당 월 === 해당 일
		System.out.println(hour02 + "==" + minute + "===" + second);
		
//		if(ampm==am) System.out.println("오전");
//		else System.out.println("오후"); // 불확실 인터넷 검색 필요
		
				
		String days[] = {"일","월","화","수","목","금","토"};
		System.out.println(days[day-1]); // 배열로 만들었을때 (day는 1,2,3,4,5..로 시작하기 때문에)
		
		switch (day) { // 명확할때 switch를 사용한다 /  day는 숫자로 떨어진다
		case Calendar.SUNDAY:
			System.out.println("일요일");
			break;
		case Calendar.MONDAY:
			System.out.println("월요일");
			break;
		case Calendar.TUESDAY:
			System.out.println("화요일");
			break;
		case Calendar.WEDNESDAY:
			System.out.println("수요일");
			break;
		case Calendar.THURSDAY:
			System.out.println("목요일");
			break;
		case Calendar.FRIDAY:
			System.out.println("금요일");
			break;
		case Calendar.SATURDAY:
			System.out.println("토요일");
			break;
		}
		
	}
}
