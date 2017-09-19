package com.eg.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Produce extends Thread {
	
	private int ewe = 8;//母羊
	
	private int ram = 2;//公羊
	private  int count = ewe + ram; //总的羊数量
	private int x_ewe; //新的小母羊
	private int x_ram; //新的小公羊
	private int sell_ewe; //卖掉的母羊数
	private int sell_count;
	private List<Integer> list_j = new ArrayList<Integer>();
	private List<Integer> list_o = new ArrayList<Integer>();
	private List<Integer> list_sell_ewe = new ArrayList<Integer>();//卖掉的原来的母鸡
	
	
	@Override
	public void run() {
		
	}
	
	public void pro() {
		Random r = new Random();
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < (ewe - sell_ewe); j++) {
					
				}
			} else {
				for (int j = 0; j < ewe * 5; j++) {
					int k = r.nextInt(40) + 1;
					if (k % 2 == 0) {
						list_o.add(k);
					} else {
						list_j.add(k);
					}
				}
				x_ewe = list_o.size();
				x_ram = list_j.size();
				count = x_ewe + x_ram;
				ewe += x_ewe;
				ram += x_ram;
			}
		}
	}
	
	public void cus() {
		for (int i = 0; i < 10; i++) {
			Random r = new Random();
			sell_count = (int)(count * 0.2f);
			if (sell_count % 2 != 0) {
				ram = ram - ((int)(sell_count * 0.5f) + 1);
			} else {
				sell_ewe = (int)(sell_count * 0.5f);
				for (int j = 0; j < sell_ewe; j ++) {
					int t = r.nextInt(sell_ewe) + 1;
					list_sell_ewe.add(t);
				}
				sell_ewe = list_sell_ewe.size();
				ram = ram - (int)(sell_count * 0.5f);
			}
			ewe = ewe - (int)(ewe * 0.5f);
		}
	}

}
