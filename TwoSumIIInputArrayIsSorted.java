package net.test.testng.leetcode;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class TwoSumIIInputArrayIsSorted {
	/**
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
		if (null == numbers || numbers.length == 0 || numbers.length < 2) {
			throw new IllegalArgumentException("No two sum solution");
		}
		if (numbers[numbers.length - 2] + numbers[numbers.length - 1] < target
				|| numbers[0] > target) {
			throw new IllegalArgumentException("No two sum solution");
		}
		int result[] = new int[2];
		int i = 0, j = numbers.length - 1;
		while (i < j && i < numbers.length && j >= 0) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				result[0] = i + 1;
				result[1] = j + 1;
				return result;
			} else if (sum > target) {
				j--;
			} else {
				i++;
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	@Test
	public void testTwoSumII() {
		int numbers[] = { 2, 3, 4, 6, 10 };
		int target = 7;
		int[] result = { 0, 2 };
		// Assert.assertEquals(result, twoSum(numbers, target));
		int[] twoSum = twoSum(numbers, target);
		for (int i = 0; i < result.length; i++) {
			System.out.println(twoSum[i]);
		}
	}
}
