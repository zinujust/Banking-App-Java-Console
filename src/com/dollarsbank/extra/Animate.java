package com.dollarsbank.extra;

public class Animate extends Thread {

	public static void load() {

		System.out.print("+");
		for (int i = 0; i < 34; i++) {
			System.out.print("=");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("+\n");
	}
}
