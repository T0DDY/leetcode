package net.test.testng.leetcode;

import org.junit.Test;

public class TwoSum extends VerifyLeetCodeSolutions {

	public int[] twoSum(int[] nums, int target) {

		int result[] = new int[2];
		int i, j;
		for (i = 0; i < nums.length; i++) {

			for (j = i+1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				}

			}

		}
		return null;

	}

	@Test
	public void test() {
		int array[] = { 3, 2, 4 };
		int[] result = twoSum(array, 6);
		System.out.println(result[0] + "\n" + result[1]);
	}

}
