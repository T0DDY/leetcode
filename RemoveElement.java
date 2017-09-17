package net.test.testng.leetcode;

import org.junit.Test;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		if (null == nums || nums.length == 0) {
			return 0;
		}

		int valid = 0;
		int notValid = nums.length - 1;
		int result = 0;
		while (valid <= notValid) {
			if (nums[valid] != val && nums[notValid] == val) {
				valid++;
				notValid--;
				result++;
			} else if (nums[valid] != val && nums[notValid] != val) {
				valid++;
				result++;
			} else if (nums[valid] == val && nums[notValid] == val) {
				notValid--;

			} else {// else if (nums[valid] == val && nums[notValid] != val) {
				nums[valid] = nums[notValid];
				result++;
				valid++;
				notValid--;
			}
		}

		return result;
	}

	@Test
	public void testRemoveElement() {
		int nums[] = { 3, 2, 4, 3 };
		int val = 3;
		int result = removeElement(nums, val);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

		System.out.println("result:" + result);
	}
}
