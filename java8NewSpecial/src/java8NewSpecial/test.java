package java8NewSpecial;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           LocalDate today = LocalDate.now();
           LocalDate tomorrow = today.plus(1,ChronoUnit.DAYS);
           LocalDate yesterday = tomorrow.minusDays(2);
           
           LocalDate independenceDay = LocalDate.of(2016, Month.JULY, 4);
           DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
           System.out.println(dayOfWeek);
           
	}

}
