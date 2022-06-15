package org.hua.exercise1.circularqueue;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CircularQueueSecondTest {

	@Test
	public void testCircularQueue() {
		Queue<Integer> q = new CircularQueue<>();

		assertTrue(q.isEmpty());		

		/**
		 * A test that puts and pops items one by one to
		 * test the correct function of r and f.
		 */
		int count = 100000;
		for (int i = 0; i < count; i++) {			
			q.push(i);
			assertTrue(q.size() == 1);
			assertTrue(q.first() == i);
			q.pop();
			assertTrue(q.size() == 0);
		}
		assertTrue(q.isEmpty());
	}
}
