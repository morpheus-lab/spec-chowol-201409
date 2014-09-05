package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
	
	public static void main(String[] args) {
		
//		Calendar c = new GregorianCalendar();
		
		Calendar c = Calendar.getInstance();
		
		int year = c.get(Calendar.YEAR);				// 년
		int month = c.get(Calendar.MONTH) + 1;			// 월 (1월: 0, 2월: 1, ...)
		int day = c.get(Calendar.DAY_OF_MONTH);			// 일
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);	// 요일 (일: 1, 월:2, 화:3, ...)
		
		System.out.println(year + "년");
		System.out.println(month + "월");
		System.out.println(day + "일");
//		System.out.println(dayOfWeek);
		switch (dayOfWeek) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		default:
			break;
		}
		
		int hour = c.get(Calendar.HOUR);
		// int hour = c.get(Calendar.HOUR_OF_DAY);
		int amPm = c.get(Calendar.AM_PM);
		int minute = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		
		System.out.println(amPm == Calendar.AM ? "오전" : "오후");
		System.out.println(hour + "시");
		System.out.println(minute + "분");
		System.out.println(sec + "초");
		
		System.out.println(c);
		
	}
	
}
