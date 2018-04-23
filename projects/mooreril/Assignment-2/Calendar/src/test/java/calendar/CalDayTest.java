/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import calendar.Appt;
import calendar.CalDay;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  CalDay calDay;
	  calDay = new CalDay();
	  assertNull(calDay.iterator());
	  calDay.toString();
	  calDay.isValid();
  }
  
  
  
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  GregorianCalendar day = new GregorianCalendar(2018,4,20);
	  CalDay calDay;
	  calDay = new CalDay(day);
	  String str = calDay.getFullInfomrationApp(calDay);
	  System.out.println(str);
	  
	  calDay.toString();
	  Appt appt1 = new Appt(1, 5, 20, 4, 2018, "title", "descripition", "email");
	  calDay.addAppt(appt1);
	  
	  Appt appt2 = new Appt(0, 5, 20, 4, 2018, "title", "descripition", "email");
	  calDay.addAppt(appt2);
	  
	  calDay.getFullInfomrationApp(calDay);
  }

  
  @Test(timeout = 4000)
  public void test02() throws Throwable {
	  int year = 2018;
	  int month = 4;
	  int day = 20;
	  GregorianCalendar today = new GregorianCalendar(year,month,day);
	  CalDay calDay;
	  calDay = new CalDay(today);
	  DataHandler dataHandler = new DataHandler();
	  
	  Appt appt1 = new Appt(14, 30, day, month, year, "title", "descripition", "email");
	  Appt appt2 = new Appt(15, 30, day, month, year, "title2", "desc2", "email2");
	  dataHandler.saveAppt(appt1);
	  dataHandler.saveAppt(appt2);
	  calDay.addAppt(appt1);
	  calDay.addAppt(appt2);
	  calDay.getFullInfomrationApp(calDay);
	  calDay.getSizeAppts();  
  }
}
