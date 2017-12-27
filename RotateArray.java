package net.test.testng.leetcode;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class RotateArray {
	/**
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {

		int res[] = new int[nums.length];
		if (k <= 0) {
			return;
		}
		k = k % nums.length;
		System.arraycopy(nums, 0, res, k, nums.length - k);
		System.arraycopy(nums, nums.length - k, res, 0, k);

		System.arraycopy(res, 0, nums, 0, nums.length);

		nums = res;

		System.out.println(Arrays.toString(nums));

	}

	@Test
	public void testRotate() {
		int a[] = { 1, 2 };
		rotate(a, 3);
	}
}
