package com.eg.test;

import java.util.Calendar;

/*
 有一家农场，养了一群小动物。养的有鸡40只，羊10只，牛2头。
 其中鸡全是母鸡，每只母鸡每个月有20天下蛋，每次下蛋1颗，其余时间休息。
 每年2月份农夫会人工孵化鸡蛋剩余数的20%，其余鸡蛋全部出售，并且会出售或宰杀20%母鸡。
 孵化出来的小鸡全是母鸡，小鸡一年之后开始下蛋。

 羊群里面有8只母羊，2只公羊。每只母羊每年10月生产5只小羊，性别随机。
 每年2月农夫出售20%羊，公羊母羊各一半（若为20%的羊数为奇数，多的那一头羊为公羊）。
 小羊2年后开始生产，性别随机。
 公牛和母牛各1头，每2年生产1只小牛。小牛2年会后开始生产，小牛的性别随机。

 现在是2017年9月1日，请问10年后农产有多少只鸡，多少头养，多少头牛？
 请问10年后动物的头和脚的数量各是多少。同时请注意闰年天数。
 */

public class Test {

	public static void main(String[] args) {
		Ewe ewe = new Ewe(8, 2);
		/*
		 * for (int i = 1; i <= 10; i++) { if (i % 2 != 0) { ewe.toEwe();
		 * ewe.procreate(); ewe.sell(); } else { ewe.procreate(); ewe.sell(); }
		 * }
		 */
		Test t = new Test();
		t.execute(ewe);
	}

	public void execute(Ewe ewe) {
		/*
		 * Calendar calendar = Calendar.getInstance(); int year =
		 * calendar.get(Calendar.YEAR); int month = calendar.get(Calendar.MONTH)
		 * + 1;
		 * 
		 * if (isEnd(year, month)) { return; } ewe.procreate(month);
		 * ewe.sell(month); calendar.set(Calendar.MONTH, ++month);
		 */
		// calendar.set(Calendar.YEAR, ++year);
		int year = 1;
		int month = 9;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				ewe.procreate(month, year);
				ewe.sell(month, year);
				month++;
				if (month >= 13) {
					month = month - 12;
				}
			}
			year++;
			if (year % 2 != 0 && year != 1) {
				ewe.toEwe(year);
				ewe.procreate(month, year);
				ewe.sell(month, year);
			}
			if (year % 2 == 0 && year != 2) {
				ewe.toEwe(year);
				ewe.procreate(month,year);
				ewe.sell(month, year);
			}
		}
	}

	public boolean isEnd(int year, int month) {
		if (year == 2027 && month == 8) {
			return true;
		}
		return false;
	}
}
