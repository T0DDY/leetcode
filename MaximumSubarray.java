package net.test.testng.leetcode;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class MaximumSubarray {

	// 其实是一个比较典型的计算最大收益的算法。
	public int maxSubArray(int[] nums) {

		if (null == nums || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		//  这是初始化赋值是个关键点，这个如果赋值为零，就不无法计算
		int globalMax = Integer.MIN_VALUE;
		int localMax = 0;
		for (int i = 0; i < nums.length; i++) {
			localMax += nums[i];
			if (globalMax < localMax) {
				globalMax = localMax;
			}
			// 金融领域比较常用，相当于是之前一段时间白干了，对于损失的部分 不计入最大收益。
			if (localMax <= 0) {
				localMax = 0;
			}
		}

		return globalMax;
	}

	@Test
	public void testMaxSub() {
		int nums[] = { -1 };
		System.out.println(maxSubArray(nums));
	}
}
