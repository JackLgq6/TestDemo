package com.eg.exam;

import java.util.ArrayList;
import java.util.List;

public class Chicken implements Timer {

	private int mouthLive = 0;
	private List<Egg> mFlowEggs = new ArrayList<Egg>();
	
	public List<Egg> wasPickUpEggsByHouse(){
		ArrayList<Egg> result = new ArrayList<Egg>(mFlowEggs);
		mFlowEggs.clear();
		return result;
	}

	@Override
	public void oneMouthAgo(int mounth) {
		List<Egg> flowEggs = new ArrayList<Egg>();
		for (int i = 0; i < 5; i++) {
			flowEggs.add(new Egg());
		}
		mFlowEggs.addAll(flowEggs);
		
		mouthLive++;
		if(mouthLive == 36){
			oldKill();
		}
	}

	@Override
	public void oneYearAgo(int year) {
		// TODO Auto-generated method stub

	}
	
	public void oldKill(){
		Henhouse.getInstance().oldChickKill(this);
	}
}
