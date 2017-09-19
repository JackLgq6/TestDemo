package com.eg.test;

import java.util.Random;


public class Ewe extends Animal {

	private int mFeet = 4;
	private int mEweCount;//母羊的数量
	private int mRamCount;//公羊的数量
	private int mCount;//总的羊的数量
	private int mSmallEweCount;//小母羊的数量
	
	public Ewe(int eweCount, int ramCount) {
		this.mEweCount = eweCount;
		this.mRamCount = ramCount;
	}
	
	@Override
	public void procreate() {
		Random r = new Random();
		for (int i = 0; i < mEweCount; i++) {
			int num = r.nextInt(100) + 1;
			if (num % 2 == 0) {
				mSmallEweCount++;
			} else {
				mRamCount++;
			}
		}
		mCount = mEweCount + mRamCount + mSmallEweCount;
	}
	
	public void sell() {
		Random r = new Random();
		int sellCount = (int)(mCount * 0.2);
		if (sellCount % 2 != 0) {
			mRamCount = mRamCount - ((sellCount - 1) / 2 + 1);
			int sellEwe = (mEweCount + mSmallEweCount) - ((sellCount - 1) / 2 - 1);
			for (int i = 0; i < sellEwe; i++) {
				int num = r.nextInt(100) + 1;
				if (num % 2 == 0) {
					mEweCount--;
				} else {
					mSmallEweCount--;
				}
			}
		} else {
			mRamCount = mRamCount - (sellCount / 2);
			int sellEwe = (mEweCount + mSmallEweCount) - (sellCount / 2);
			for (int i = 0; i < sellEwe; i++) {
				int num = r.nextInt(100) + 1;
				if (num % 2 == 0) {
					mEweCount--;
				} else {
					mSmallEweCount--;
				}
			}
		}
		mCount = mRamCount + mEweCount + mSmallEweCount;
		System.out.println("公羊的数量：" + mRamCount + ", 母羊的数量：" + mEweCount + ",小母羊的数量：" + mSmallEweCount + ",羊的总数：" + mCount);
	}
	
	public void toEwe() {
		mEweCount += mSmallEweCount;
	}

}
