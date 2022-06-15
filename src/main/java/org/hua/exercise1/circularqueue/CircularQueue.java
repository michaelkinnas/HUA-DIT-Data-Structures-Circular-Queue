package org.hua.exercise1.circularqueue;

import java.util.NoSuchElementException;

/**
 * A circular array queue
 * 
 * @param <E> the element type
 */
public class CircularQueue<E> implements Queue<E> {
	public static final int INITIAL_CAPACITY = 32;	
	public E[] array;
	private int size;	
	private int f;
	private int r;
	
	
	/**
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public CircularQueue() {
		this.array = (E[]) new Object[INITIAL_CAPACITY];			
		this.f = 0;
		this.r = 0;		
		this.size = 0;
	}	
	/**
	 * Inserts an element into the queue
	 */
	@Override
	public void push(E elem) {
		if (size >= array.length - 1) {
			doubleCapacity();
		}		
		array[r] = elem;
		r = (r + 1) % array.length;
		calculateSize();		
	}	
	/**
	 * Removes an element from the queue and
	 * returns it to the user
	 * @return Returns an E element
	 * @throws Throws NoSuchElementException
	 */
	@Override
	public E pop() {
		if (array[f] == null) {
			throw new NoSuchElementException("Requested element is null");
		}
		E temp = array[f];
		f = (f + 1) % array.length;
		calculateSize();		
		if (4 * size < array.length) {
			halfCapacity();
		}		
		return temp;
	}	
	/**
	 * Returns the first element from the queue
	 * @return Returns an E element
	 * @throws Throws NoSuchElementException
	 */
	@Override
	public E first() {
		if (array[f] == null) {
			throw new NoSuchElementException("Requested element is null");
		}		
		return array[f];
	}	
	/**
	 * Returns true if queue is empty or false if not 
	 * @return Boolean
	 */
	@Override
	public boolean isEmpty() {
		return f == r;
	}
	/**
	 * Returns the size of the queue
	 * @return An integer
	 */
	@Override
	public int size() {
		return size;
	}
	/**
	 * Clears the queue by creating a new empty one and setting f and r to 0;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.array = (E[]) new Object[INITIAL_CAPACITY];				
		this.f = 0;
		this.r = 0;		
		this.size = 0;		
	}	
	/**
	 * Doubles the size of the array and recalculates the r value for the new array.
	 */
	@SuppressWarnings("unchecked")
	private void doubleCapacity() {
		int newCapacity = 2 * array.length;
		E[] newArray = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newArray[(f + i) % newCapacity] = array[(f + i) % array.length];			
		}		
		r = f + size;
		array = newArray;
	}	
	/**
	 * Halves the size of the array and recalculates the r and f values.
	 */
	@SuppressWarnings("unchecked")
	private void halfCapacity() {		
		if (array.length <= INITIAL_CAPACITY) {
			return;
		}		
		int newCapacity = array.length / 2;		
		E[] newArray = (E[]) new Object[newCapacity];
		for (int i = 0; i < Math.min(size, newCapacity); i++) {			
			newArray[(f + i) % newCapacity] = array[(f + i) % array.length];				
		}		
		f = f % newCapacity;
		r = r % newCapacity;
		array = newArray;		
	}	
	/**
	 * Calculates the size of the queue and assigns it to the size variable 
	 */
	private void calculateSize() {
		if (r < f ) {			
			size = array.length - f + r;			
		} else {			
			size = r - f;
		}		
	}	
}
