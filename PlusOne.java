package net.test.testng.leetcode;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class PlusOne {

	// 其实是用十进制和数组实现加法。
	public int[] plusOne(int[] digits) {

		if (digits == null) {
			int[] res = { 1 };
			return res;
		}

		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
				if (i == 0) {
					int res[] = new int[digits.length + 1];
					res[0] = 1;
					digits = res;
				}
			} else {
				digits[i]++;
				return digits;
			}
		}
		return digits;
	}

	@Test
	public void testPlusOne() {
		int nums[] = { 9,9,9 };
		nums = plusOne(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
