package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class SingleNumber {
	/**
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		if (null == nums || nums.length == 0) {
			return 0;
		}
		for (int i = 1; i < nums.length; i++) {
			nums[0] ^= nums[i];

		}
		return nums[0];
	}

	@Test
	public void testSingleNumber() {
		int nums[] = { 1, 2, 2, 3, 3 };
		Assert.assertEquals(1, singleNumber(nums));

		int nums1[] = {};
		Assert.assertEquals(0, singleNumber(nums1));

		int nums2[] = { 1 };
		Assert.assertEquals(1, singleNumber(nums2));

		int nums3[] = { 0 };
		Assert.assertEquals(0, singleNumber(nums3));

		int nums4[] = { 2, 1, 2, 3, 3 };
		Assert.assertEquals(1, singleNumber(nums4));

		int nums5[] = { 2, 2, 1, 1, 3 };
		Assert.assertEquals(3, singleNumber(nums5));

		int nums6[] = { 0, 0, 0, 1, 1 };
		Assert.assertEquals(0, singleNumber(nums6));

	}
}
