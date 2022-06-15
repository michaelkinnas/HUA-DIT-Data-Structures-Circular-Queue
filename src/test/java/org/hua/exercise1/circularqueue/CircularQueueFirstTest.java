package org.hua.exercise1.circularqueue;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CircularQueueFirstTest {
	
	@Test
	public void testCircularQueue() {
		Queue<Integer> q = new CircularQueue<>();
		
		assertTrue(q.isEmpty());		
		
		/**
		 * Test of basic functionality
		 * add 100000 elements of type integer in the queue
		 * and then pop them
		 */
		int count = 100000;
		for (int i = 0; i < count; i++) {			
			q.push(i);
			assertTrue(q.size() == i + 1);
			assertTrue(q.first() == 0);
		}
		int current = 0;
		
		
		while (!q.isEmpty()) {
			assertTrue(q.first() == current);
			assertTrue(q.pop() == current);
			current++;
			
		}
		
		assertTrue(q.isEmpty());
	}
}
