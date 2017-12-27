package net.test.testng.leetcode;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class MinStack {

	private int numbers[] = {};
	private int sorted[] = {};

	/** initialize your data structure here. */
	public MinStack() {

	}

	public void push(int x) {

		int newone[] = new int[numbers.length + 1];
		newone[newone.length - 1] = x;

		System.arraycopy(numbers, 0, newone, 0, numbers.length);
		numbers = newone;

		int newSorted[] = new int[numbers.length];
		System.arraycopy(sorted, 0, newSorted, 0, sorted.length);

		int i = 0;
		while (i < sorted.length && x > newSorted[i]) {
			i++;
		}

		int j = newSorted.length - 1;
		while (j > i) {
			newSorted[j] = newSorted[j - 1];
			j--;
		}
		newSorted[j] = x;
		sorted = newSorted;

	}

	public void pop() {

		// if null judge.
		int newone[] = new int[numbers.length - 1];
		System.arraycopy(numbers, 0, newone, 0, newone.length);

		// deal with sorted array.
		int i = 0;
		while (i < numbers.length && numbers[numbers.length - 1] != sorted[i]) {
			i++;
		}
		while (i <= numbers.length - 2) {
			sorted[i] = sorted[i + 1];
			i++;
		}
		numbers = newone;
		int newSorted[] = new int[sorted.length - 1];
		System.arraycopy(sorted, 0, newSorted, 0, newSorted.length);
		sorted = newSorted;
	}

	public int top() {
		if (null != numbers && numbers.length != 0) {
			return numbers[numbers.length - 1];

		}
		return 0;// TODO empty?
	}

	public int getMin() {
		if (null != numbers && numbers.length != 0) {
			return sorted[0];
		}
		return 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(numbers) + "," + Arrays.toString(sorted);
	}

	 @Test
	public void testMinStack() {

		MinStack stack = new MinStack();

		System.out.println(stack.top());
		System.out.println(stack.getMin());

		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(4);
		stack.push(-1);
		System.out.println(stack);

		stack.pop();
		System.out.println(stack);
		System.out.println(stack.getMin());
		System.out.println(stack.top());

		stack.push(-6);
		System.out.println(stack.getMin());
		System.out.println(stack.top());

		stack.push(-8);
		stack.push(-7);
		System.out.println(stack.getMin());
		System.out.println(stack.top());

		// Make sure that if the stack is empty, what is the minimum value?

		// Test if getMin() will pop a element?

		// How to make sure that minimum value is correct when pop a value?

		// other test cases?

		// what will top return if the stack is empty?
	}

	// @Test
	public void testArraysToString() {
		int a[] = { 3, 2, 1 };
		char b[] = { 'a', 'b', 'c' };
		System.out.println(Arrays.toString(a) + " , " + Arrays.toString(b));

		System.out.println(new MinStack().top());
	}

	// @Test
	public void testStack() {
		Stack<Integer> stack = new Stack<>();
		System.out.println("empty stack is :" + stack.pop());
	}

	//
	// ["MinStack","push","push","push","getMin","pop","top","getMin"]
	// [[],[-2],[0],[-3],[],[],[],[]]

	// ["MinStack","pop","top","getMin"]
	// [[],[],[],[],[]]

	// ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
	// [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
//	@Test
	public void testAFailedCase() {
		MinStack stack = new MinStack();
		stack.push(2);
		stack.push(0);
		stack.push(3);
		stack.push(0);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}
}
