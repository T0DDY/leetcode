package net.test.testng.leetcode;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class MergeSortedArray {

	/**
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				i--;
			} else {
				nums1[k] = nums2[j];
				j--;
			}
			k--;
		}
		while (j > -1)
			nums1[k--] = nums2[j--];

	}

	@Test
	public void testMerge() {
		// int nums1 [] = {1,2,5,7,9,0,0,0};
		// int nums2 [] = {2,9,10};
		int nums1[] = { 4, 5, 6, 0, 0, 0 };
		int nums2[] = { 1, 2, 8 };
		int m = 3;
		int n = 3;
		merge(nums1, m, nums2, n);
		for (int i = 0; i < nums1.length; i++) {
			System.out.println(nums1[i]);
		}
		System.out.println("\n\nnums2");
		for (int i = 0; i < nums2.length; i++) {
			System.out.println(nums2[i]);
		}

	}

}
