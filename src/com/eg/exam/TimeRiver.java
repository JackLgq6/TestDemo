package com.eg.exam;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TimeRiver implements Timer {

	private final Calendar mCalendar = Calendar.getInstance();

	private List<Timer> times = new  ArrayList<Timer>();
	
	public TimeRiver(int year, int mouth) {
		mCalendar.set(Calendar.YEAR, year);
		mCalendar.set(Calendar.MONTH, mouth);
	}
	public void addTimer(Timer t){
		times.add(t);
	}
	public void go() {
		int mouth = mCalendar.get(Calendar.MONTH);
		int year = mCalendar.get(Calendar.YEAR);
		oneMouthAgo(mouth + 1);
		oneYearAgo(year);

		mCalendar.set(Calendar.MONTH, ++mouth);

		if (isEnd()){
			return;	
		}
			
		go();
	}

	public boolean isEnd() {
		int mouth = mCalendar.get(Calendar.MONTH);
		int year = mCalendar.get(Calendar.YEAR);

		if (year == 2027 && mouth == 8) {
			return true;
		}
		
		System.out.println( "mouth =" + mouth + ";;; year == " + year);
		return false;
	}

	@Override
	public void oneMouthAgo(int mounth) {
		for(Timer t:times){
			t.oneMouthAgo(mounth);
		}
	}

	@Override
	public void oneYearAgo(int year) {
		for(Timer t:times){
			t.oneYearAgo(year);
		}

	}

}
