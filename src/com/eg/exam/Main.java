package com.eg.exam;

import java.util.ArrayList;
import java.util.List;

public class Main {

	
	public static void main(String[] argo){
		TimeRiver river = new  TimeRiver(2017,9);
		List<Chicken> oldCheick = new ArrayList<Chicken>();
		for(int i=0;i<40;i++){
			oldCheick.add(new Chicken());
		}
		Henhouse henhouse  = new Henhouse(oldCheick);
		
		river.addTimer(henhouse);
		river.go();
		
	}
}
