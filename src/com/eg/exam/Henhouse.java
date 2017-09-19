package com.eg.exam;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

public class Henhouse implements Timer {
	
	public static Henhouse mInstance;
	private final List<Chicken> chickens;
	private List<SmallChicken> smallChickens = new ArrayList<SmallChicken>();

	private List<Egg> eggsInHouseEggs = new ArrayList<Egg>();
	private List<Egg> eggsInhatch = new ArrayList<Egg>();

	public Henhouse(List<Chicken> inChickens){
		chickens = inChickens;
		mInstance = this;
	}
	public static Henhouse getInstance(){
		return mInstance;
	}
	private void pickUpEggFromChicknes() {
		for (Chicken chicken : chickens) {
			eggsInHouseEggs.addAll(chicken.wasPickUpEggsByHouse());
		}
	}

	private void hatchEgg() {
		for (Egg egg : eggsInhatch) {
			smallChickens.add(egg.wasHatch());
		}
		eggsInhatch.clear();
	}

	private void killChickens() {
		chickens.subList(0, (int)(chickens.size()*0.2)).clear();;
	}
	
	public void oldChickenFlowEggEveryMouth(int mouth){
		for(Chicken oldChicken :chickens){
			oldChicken.oneMouthAgo(mouth);
		}
	}
	
	private void smallStartJoinChick(){
		for(SmallChicken smallChicken :smallChickens){
			chickens.add(smallChicken.growUp());
		}
		smallChickens.clear();
	}
	@Override
	public void oneMouthAgo(int mounth) {
		pickUpEggFromChicknes();
		if (mounth == 2) {
			//准备要孵化的蛋
			eggsInhatch.addAll(eggsInHouseEggs.subList(0,(int) (eggsInHouseEggs.size() * 0.02)));
			// 开始杀鸡
			killChickens();
			
			//小鸡长大准备下蛋
			smallStartJoinChick();
			
			hatchEgg();
			eggsInHouseEggs.clear();
		}
		oldChickenFlowEggEveryMouth(mounth);
		chickens.removeAll(preperOldChickens);
		preperOldChickens.clear();
	}

	@Override
	public void oneYearAgo(int year) {
	System.out.println( year + "后，拥有老母鸡 " +getOldChicken() + "只" );
	}
	public int getOldChicken(){
		return chickens.size();
	}
	public int getSmallChicken(){
		return smallChickens.size();
	}
	private List<Chicken> preperOldChickens = new ArrayList<Chicken>();
	public void oldChickKill(Chicken c){
		eggsInHouseEggs.addAll(c.wasPickUpEggsByHouse());
		preperOldChickens.add(c);
	}
}
