package net.test.testng.leetcode;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class RemoveDuplicatesfromSortedArray {

	/**
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {

		// defensive
		if (null == nums || nums.length == 0) {
			return 0;
		}
		int result = 0;
		int now = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 < nums.length && nums[i] != nums[i + 1]) {
				result++;
				nums[now + 1] = nums[i + 1];
				now++;
			} 
		}
		return result+1;

	}

	@Test
	public void testRemoveDuplicates() {
		int[] nums = { 1,1,2,3,3 };
		System.out.println("All length: "+removeDuplicates(nums));
//		removeDuplicates(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
