package org.hua.exercise1.circularqueue;

import java.util.Random;

public class App {
	public static final int ELEMENTS = 30;
	public static final int RANGE = 1000;

	public static void main(String args[]) {		
		Random rng = new Random();
		Queue<Integer> v = new CircularQueue<>();		

		for (int i = 0; i < ELEMENTS; i++) {
			v.push(rng.nextInt(RANGE));			
		}

		for (int i = 0; i < ELEMENTS; i++) {
			System.out.println(v.pop());
		}		
	}
}
