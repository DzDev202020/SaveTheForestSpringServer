package util;

import java.util.Calendar;

public class MyTime {
	
	public static Long getTime() {
		return Calendar.getInstance().getTimeInMillis();
	}

}
