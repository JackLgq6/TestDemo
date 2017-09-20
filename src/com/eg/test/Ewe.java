package com.eg.test;

import java.util.Random;

public class Ewe extends Animal {

	private int mFeet = 4;
	private int mEweCount;// 母羊的数量
	private int mRamCount;// 公羊的数量
	private int mCount;// 总的羊的数量
	private int mSmallEweCount = 0;// 小母羊的数量
	private int mSmallRamCount = 0;//小公羊
	private int pro_small_ewe_count = 0;

	public Ewe(int eweCount, int ramCount) {
		this.mEweCount = eweCount;
		this.mRamCount = ramCount;
		mCount = mEweCount + mRamCount;
	}

	@Override
	public void procreate(int month, int year) {
		int pro_small_ram_count = 0;
		if (month == 10) {
			Random r = new Random();
			for (int i = 0; i < mEweCount * 5; i++) {
				int num = r.nextInt(100) + 1;
				if (num % 2 == 0) {
					if (year % 2 != 0) {
						mSmallEweCount++;
					}
					if (year % 2 == 0 ) {
						pro_small_ewe_count++;
					}
				} else {
					mRamCount++;
					pro_small_ram_count++;
					mSmallRamCount++;
				}
			}
			if (year % 2 != 0) {
				System.out.print("生了" + mSmallEweCount  + "只" + "小母羊， 生了" + pro_small_ram_count+ "只小公羊， ");
				
			} else {
				System.out.print("生了" + pro_small_ewe_count  + "只" + "小母羊， 生了" + pro_small_ram_count+ "只小公羊， ");
//				System.out.println();
//				System.out.println(mEweCount);
//				System.out.println(mRamCount);
//				System.out.println(pro_small_ewe_count);
			}
			mCount += mEweCount * 5;
			System.out.print("总的羊的数量：" + mCount + ", ");
		}
	}

	public void sell(int month, int year) {
		if (month == 2) {
			//Random r = new Random();
			int sellCount = (int) (mCount * 0.2);//卖掉的羊的总数
			int sell_ewe_count = 0;
			int sell_ram_count = 0;
			if (sellCount % 2 != 0) {
				mRamCount = mRamCount - ((sellCount - 1) / 2 + 1);
				sell_ram_count = (sellCount - 1) / 2 + 1;
				sell_ewe_count = (sellCount - 1) / 2;
				if (sell_ewe_count >= mEweCount) {
					sell_ewe_count = mEweCount;
					mEweCount = 0;
				} else {
					mEweCount = mEweCount -sell_ewe_count;
				}
				/*int sellEwe = ((sellCount - 1) / 2 - 1);
				for (int i = 0; i < sellEwe; i++) {
					int num = r.nextInt(100) + 1;
					if (num % 2 == 0) {
						mEweCount--;
						sell_ewe_count++;
					} else {
						mSmallEweCount--;
						sell_small_ewe_count++;
					}
				}*/
			} else {
				mRamCount = mRamCount - (sellCount / 2);
				sell_ram_count = sellCount / 2;
				sell_ewe_count = sellCount / 2;
				if (sell_ewe_count >= mEweCount) {
					sell_ewe_count = mEweCount;
					mEweCount = 0;
				} else {
					mEweCount = mEweCount - (sellCount / 2);
					sell_ewe_count = sellCount / 2;
				}
				//int sellEwe = (mEweCount + mSmallEweCount) - (sellCount / 2);
				/*for (int i = 0; i < sellCount / 2; i++) {
					int num = r.nextInt(100) + 1;
					if (num % 2 == 0) {
						mEweCount--;
						sell_ewe_count++;
					} else {
						mSmallEweCount--;
						sell_small_ewe_count++;
					}
				}*/
			}
			mCount = mRamCount + mEweCount + mSmallEweCount;
			System.out.print("， 卖掉"+sell_ewe_count + "只母羊" + ", " + "卖掉" + sell_ram_count + "只公羊， ");
			System.out.println("第" + year + "年" + "公羊的数量：" + mRamCount + ", 母羊的数量：" + mEweCount
					+ ",小母羊的数量：" + mSmallEweCount + ",羊的总数：" + mCount);
		}
	}

	public void toEwe(int year) {
		if (year % 2 != 0 && year != 1) {
			mEweCount += mSmallEweCount;
			mSmallEweCount = 0;
		}
		if (year % 2 == 0 && year != 2) {
			/*System.out.println(mEweCount);
			System.out.println(pro_small_ewe_count);*/
			mEweCount += pro_small_ewe_count;
			pro_small_ewe_count = 0;
		}
	}

}
