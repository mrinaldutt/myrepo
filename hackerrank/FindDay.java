package hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class FindDay {
	
	public static void main(String args[]) throws ParseException {
		/*Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayofweek = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayofweek);*/
		String input_date="12/08/2020";
		SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		Date dt1=format1.parse(input_date);
		String dayWeekText = new SimpleDateFormat("EEEE").format(dt1);
        System.out.println("Day of week in text:"+dayWeekText);
        
        LocalDate currDate = LocalDate.of(2020, 8, 12);
        System.out.println(currDate.getDayOfWeek().name().toUpperCase());
        
        //A prints out the full day of the week.
        //B is for the full month name.
       // Y outputs a year in four digits.
        System.out.printf("%1$tA, %1$tB %1$tY %n", currDate);
        
        //H, M, S characters are responsible for extracting the hours, minutes and seconds from the input Date.
        Date date = new Date();
        System.out.printf("%tT%n", date);
        
        System.out.printf("hours %tH: minutes %tM: seconds %tS%n", date, date, date);
        
        
	}

}
