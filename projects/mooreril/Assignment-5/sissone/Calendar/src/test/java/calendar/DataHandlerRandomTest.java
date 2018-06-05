package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	
    /**
     * Generate Random Tests that tests DataHandler Class.
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
					
					 int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 25);
					 int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 61);
					 int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 32);
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, -1, 13);
					 int startYear=ValuesGenerator.getRandomIntBetween(random, -1, 2018);
					 int endDay=ValuesGenerator.getRandomIntBetween(random, startDay, 32);
					 int endMonth=ValuesGenerator.getRandomIntBetween(random, startMonth, 13);
					 int endYear=ValuesGenerator.getRandomIntBetween(random, startYear, 2018);
					 String title="Birthday Party";
					 String description="This is my birthday party.";
					 String emailAddress="xyz@gmail.com";
					 
					 
					 
					 GregorianCalendar starDay = new GregorianCalendar(startDay, startMonth, startYear);
					 GregorianCalendar finDay = new GregorianCalendar(endDay, endMonth, endYear);
 

					 //Construct a new Appointment object with the initial data	 
					 //Construct a new Appointment object with the initial data	 
			         Appt appt = new Appt(startHour,
			                  startMinute ,
			                  startDay ,
			                  startMonth ,
			                  startYear ,
			                  title,
			                 description,
			                 emailAddress);
			         appt.setValid();
					 int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
					 int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);

			         appt.setRecurrence(recurDays,1,1,20);

			         CalDay calday = new CalDay(starDay);
			         
			         DataHandler data = new DataHandler("filname", true);
			         DataHandler dataa = new DataHandler("filename", false);
			         DataHandler dayab = new DataHandler("_badName.%$^&(!^#$%#@(&*^", false);
			         
				for (int i = 0; i < NUM_TESTS; i++) {
						data.saveAppt(appt);
						int rand = ValuesGenerator.getRandomIntBetween(random,0,1);
						if (rand==1)
							appt.setXmlElement(null);
						data.deleteAppt(appt);
						
						int diagn = ValuesGenerator.getRandomIntBetween(random,0,1);
						boolean diag = false;
						if (diagn==1)
							diag = true;
												
						dataa.saveAppt(appt);
						
						dataa.getApptRange(starDay, finDay);
												
						dataa.deleteAppt(appt);
						
						
						
				
					
					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				     if((iteration%1000)==0 && iteration!=0 )
				              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
					}
				try {
				dataa.getApptRange(finDay, starDay);
				}catch (DateOutOfRangeException DOOR) {
				}
				dayab.getApptRange(starDay, finDay);
				
				}
			}catch(NullPointerException e){
				
			}
		 
			 System.out.println("Done testing...");
		 
		 
	 }


	
}
