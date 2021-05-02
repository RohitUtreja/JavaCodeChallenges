package com.exp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class WeeksBWDates {

	public static void main(String[] args) throws ParseException {
		String A="April";
		String B="May";
		String Y="2014";
		
		 try{
		        Date d1 = new SimpleDateFormat("dd-MMMM-yyyy").parse("1-"+A+"-"+Y);
		        Calendar cal1 = Calendar.getInstance();
		        cal1.setTime(d1);
		        Date d2 = new SimpleDateFormat("dd-MMMM-yyyy").parse("1-"+B+"-"+Y);
		        Calendar cal2 = Calendar.getInstance();
		        cal2.setTime(d2);
		        LocalDate da1 = LocalDate.of(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), 01);
		        LocalDate da2 = LocalDate.of(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), 01);

		        LocalDate m = da1.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		        LocalDate s = da2.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
		        Long t =  ChronoUnit.WEEKS.between(m,s);
		        System.out.println(t.intValue());



		        }catch(Exception e){
		            e.printStackTrace();
		        }
	}

}
