package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class SearchInsertPosition {

	/**
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums, int target) {
		if (target <= nums[0]) {
			return 0;
		}
		if (target > nums[nums.length - 1]) {
			return nums.length;
		}
		int head = 0;
		int tail = nums.length - 1;
		int mid = 0;
		while (head <= tail) {
			mid = (head + tail) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (nums[mid] < target) {
				head = mid + 1;
			} else {
				tail = mid - 1;
			}

		}
		return head;
	}

	@Test
	public void testSearchInsert() {
		int[] array = { 1, 3, 5 };

		Assert.assertEquals(searchInsert(array, 1), 0);
		Assert.assertEquals(searchInsert(array, 3), 1);
		Assert.assertEquals(searchInsert(array, 4), 2);
		Assert.assertEquals(searchInsert(array, 5), 2);
		Assert.assertEquals(searchInsert(array, 6), 3);
		Assert.assertEquals(searchInsert(array, 0), 0);
		Assert.assertEquals(searchInsert(array, 4), 2);
		Assert.assertEquals(searchInsert(array, 2), 1);

	}
}
