package org.hua.exercise1.circularqueue;


import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class CircularQueueThirdTest {

	@Test
	public void testCircularQueue() {
		Queue<String> testQueue = new CircularQueue<>();

		Random random = new Random();	

		assertTrue(testQueue.isEmpty());
		
		/**
		 * Testing queue with elements of type String
		 * Generate random alphanumeric Strings of length 0 to 20 and put them in the queue
		 * then pop them
		 */
		for (int i = 0; i < 100000; i++) {
			String randomString = random.ints(48, 122)
					.filter(j -> (j <= 57 || j >= 65) && (j <= 90 || j >= 97))
					.limit(random.nextInt(20))
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					.toString();
			testQueue.push(randomString);
			assertTrue(testQueue.size() == i + 1);			
		}
		
		int size = 100000;
		while (!testQueue.isEmpty()) {
			assert(testQueue.size() == size);
			testQueue.pop();
			size--;			
		}
	}
}
