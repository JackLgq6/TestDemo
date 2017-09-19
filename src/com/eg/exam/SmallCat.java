package com.eg.exam;

/*public class SmallCat extends Cat {

}*/

public class SmallCat {
	
	static class TaskThread extends Thread {
		
		private int mCount;
		
		TaskThread(int count) {
			this.mCount = count;
		}
		
		@Override
		public void run() {
			System.out.println(mCount + " ");
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new TaskThread(i).start();
		}
	}
}
