package calendar;

import org.junit.Test;
import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		 try{ 
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis(); //10
		//			System.out.println(" Seed:"+randomseed );
					Random random = new Random(randomseed);
					
					 int startHoura=ValuesGenerator.getRandomIntBetween(random, -1, 25);
					 int startMinutea=ValuesGenerator.getRandomIntBetween(random, -1, 61);
					 int startHourb=ValuesGenerator.getRandomIntBetween(random, -1, 25);
					 int startMinuteb=ValuesGenerator.getRandomIntBetween(random, -1, 61);
					 int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 32);
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, -1, 13);
					 int startYear=ValuesGenerator.getRandomIntBetween(random, -1, 2018);
					 GregorianCalendar cal = new GregorianCalendar(startDay, startMonth, startYear);
					 String title="Birthday Party";
					 String description="This is my birthday party.";
					 String emailAddress="xyz@gmail.com";

					 //Construct a new Appointment object with the initial data	 
					 //Construct a new Appointment object with the initial data	 
			         Appt appta = new Appt(startHoura,
			                  startMinutea ,
			                  startDay ,
			                  startMonth ,
			                  startYear ,
			                  title,
			                 description,
			                 emailAddress);
			         Appt apptb = new Appt(startHourb,
			                  startMinuteb ,
			                  startDay ,
			                  startMonth ,
			                  startYear ,
			                  title,
			                 description,
			                 emailAddress);
			         appta.setValid();
			         apptb.setValid();

			         CalDay calday = new CalDay(cal);
			         
				for (int i = 0; i < NUM_TESTS; i++) {
					
					calday.addAppt(appta);
					calday.addAppt(apptb);
						
					}
					
					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				        if((iteration%10000)==0 && iteration!=0 )
				              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				 
				}
			}catch(NullPointerException e){
				
			}
		 
			 System.out.println("Done testing...");
		 
		 
		 
	 }


	
}
