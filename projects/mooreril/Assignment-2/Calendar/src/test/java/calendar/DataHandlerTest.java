/** A JUnit test class to test the class DataHandler. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  DataHandler dataHandler;
	  dataHandler = new DataHandler();
	  Appt appt = new Appt(14,30,20,4,2018,"appointment", "description", "abc@xyz.com");
	  dataHandler.saveAppt(appt);
	  dataHandler.deleteAppt(appt);
  }
  
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  DataHandler dataHandler;
	  dataHandler = new DataHandler("file");	
	  Appt appt = new Appt (33,100,50,13,-1, "invalid", "invalid", "invalid@invalid.com");
	  dataHandler.saveAppt(appt);
	  dataHandler.deleteAppt(appt);
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable {
	  DataHandler dataHandler;
	  dataHandler = new DataHandler();
	  Appt appt1 = new Appt(14,30,20,4,2018,"appointment1", "description1", "abc@xyz.com");
	  Appt appt2 = new Appt(13,30,20,4,2018,"appointment2", "description2", "abc@xyz.com");
	  
	  
	  dataHandler.saveAppt(appt1);
	  dataHandler.saveAppt(appt2);
	  
      int[] recurDaysArr={2,3,4};

	  appt1.setRecurrence(recurDaysArr, Appt.RECUR_BY_MONTHLY, 1, 500);

	  
	  GregorianCalendar day1 = new GregorianCalendar(2017,4,20);
	  GregorianCalendar day2 = new GregorianCalendar(2018,4,25);
	  dataHandler.getApptRange(day1,day2,true);
  }
  @Test(timeout = 4000, expected=DateOutOfRangeException.class)
  public void test03() throws Throwable {
	  DataHandler dataHandler;
	  dataHandler = new DataHandler();
	  Appt appt1 = new Appt(14,30,20,4,2018,"appointment1", "description1", "abc@xyz.com");
	  
	  dataHandler.saveAppt(appt1);
	  GregorianCalendar day1 = new GregorianCalendar(2018,4,20);
	  dataHandler.getApptRange(day1,day1,true);
  }
  
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
	  DataHandler dataHandler;
	  dataHandler = new DataHandler("file");	
	  GregorianCalendar day1 = new GregorianCalendar(2017,4,20);
	  GregorianCalendar day2 = new GregorianCalendar(2018,4,25);
	  dataHandler.getApptRange(day1,day2,false);
  }
  @Test(timeout = 4000)
  public void test05() throws Throwable {
	  DataHandler dataHandler;
	  dataHandler = new DataHandler();
	  int [] recurday = {0};
	  Appt appt1 = new Appt(14,30,20,4,2018,"appointment1", "description1", "abc@xyz.com");
	  appt1.setRecurrence(recurday, Appt.RECUR_BY_MONTHLY, 1, 500);
	  dataHandler.saveAppt(appt1);
	  
	  GregorianCalendar day1 = new GregorianCalendar(2018,4,20);
	  GregorianCalendar day2 = new GregorianCalendar(2018,4,25);
	  dataHandler.getApptRange(day1,day2,false);
  }
  @Test(timeout = 4000)
  public void test06() throws Throwable {
	  DataHandler dataHandler;
	  dataHandler = new DataHandler();
	  int [] recurday = {0};
	  Appt appt1 = new Appt(14,30,20,4,2018,"appointment1", "description1", "abc@xyz.com");
	  appt1.setRecurrence(recurday, Appt.RECUR_BY_YEARLY, 1, 500);
	  dataHandler.saveAppt(appt1);
	  
	  GregorianCalendar day1 = new GregorianCalendar(2018,4,20);
	  GregorianCalendar day2 = new GregorianCalendar(2018,4,25);
	  dataHandler.getApptRange(day1,day2,true);
  }
}
