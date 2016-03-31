

import java.util.*;

import java.util.GregorianCalendar;

public class MyDate extends Command {
	/* Command:
           date
           Action:
           the current date is displayed.
	 */

	public MyDate(){
		f();
	}

	protected void f(){
		// Create a calendar to get the date
		GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("America/New_York"));
		// Set the style, for instance, short = "Jan" or "Feb"
		int style = Calendar.SHORT;
		// Set the locale, in this case, US
		Locale locale = Locale.US;
		
		// Get the day of the week, month, day number and year
		// Example: Thu Feb 11 2016
		String dayOfWeek = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
		String month = cal.getDisplayName(Calendar.MONTH, style, locale);
		int dayNum = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		
		// Print out the date
		System.out.println(dayOfWeek + " " + month + " " + dayNum + " " + year + "\n");
	}
}
