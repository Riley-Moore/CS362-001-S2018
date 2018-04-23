/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
 
      int[] recurDaysArr={2,3,4};
      appt0.setRecurrence(recurDaysArr,appt0.RECUR_BY_MONTHLY,3,4);
      assertEquals(appt0.getRecurDays(), recurDaysArr);
      assertEquals(appt0.getRecurBy(), 2);
      assertEquals(appt0.getRecurIncrement(), 3);
      assertEquals(appt0.getRecurNumber(), 4);
      assertEquals(appt0.isRecurring(), true);
      
      
      appt0.setStartMonth(0);
      appt0.setValid();
      appt0.setStartMonth(12);
      appt0.setValid();
      appt0.setStartMonth(6);
      appt0.setValid();
      
      appt0.setStartHour(0);
      appt0.setValid();
      appt0.setStartHour(24);
      appt0.setValid();
      appt0.setStartHour(12);
      appt0.setValid();
      
      appt0.setStartMinute(0);
      appt0.setValid();
      appt0.setStartMinute(60);
      appt0.setValid();
      appt0.setStartMinute(30);
      appt0.setValid();
      
      appt0.setValid();
      appt0.setStartYear(0);
      appt0.setValid();
      appt0.setStartYear(10000);
      appt0.setValid();
      appt0.setValid();      
      
      appt0.setStartDay(0);
      appt0.setValid();
      appt0.setStartDay(33);
      appt0.setValid();
      appt0.setStartDay(15);
      appt0.setValid();

      

      
      
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable {
	Appt appt1 = new Appt(14, 9, 2018, null, null, null);
	assertEquals(appt1.getEmailAddress(), "");
	appt1.setRecurrence(null, 0,0,appt1.RECUR_NUMBER_NEVER);
	assertEquals(appt1.isOn(14,9,2018),true);
	assertEquals(appt1.isOn(14,8,2018),false);
	assertEquals(appt1.isOn(10,9,2018),false);
	assertEquals(appt1.isOn(14,9,2010),false);	
	assertEquals(appt1.hasTimeSet(), false);
	appt1.getXmlElement();

}

}
