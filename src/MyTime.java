

/* Command:
           time
           Action:
           the current time is displayed.
 */
import java.util.*;

public class MyTime{
	public MyTime(){
		f();
	}

	private void f(){

		// Create a calendar to get the date
		TimeZone tz = TimeZone.getTimeZone("America/New_York");
		GregorianCalendar cal = new GregorianCalendar(tz);
		
		// Example: 11:36:33 EST
		// Get hours, minutes, seconds and time zone letters
		int hours = cal.get(Calendar.HOUR_OF_DAY);
		int minutes = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		String tzStr = tz.getDisplayName();
		
		// Print it out
		System.out.format("%d:%d:%02d " + tzStr + "\n", hours, minutes, seconds);
	}
}
