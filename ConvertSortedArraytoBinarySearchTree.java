package net.test.testng.leetcode;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class ConvertSortedArraytoBinarySearchTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {

		if (null == nums || nums.length == 0) {
			return null;
		}

		return arrayToTree(nums, 0, nums.length - 1);
	}

	public TreeNode arrayToTree(int array[], int start, int end) {

		if (start > end) {
			return null;
		} else if (start == end) {
			return new TreeNode(array[start]);
		} else {

			int middle = (end + start) / 2;
			TreeNode node = new TreeNode(array[middle]);
			node.left = arrayToTree(array, start, middle - 1);
			node.right = arrayToTree(array, middle + 1, end);
			return node;
		}
	}

	@Test
	public void testSortedArrayToBST() {
		int nums[] = { 1, 2, 3 ,4,5};
		TreeNode tree = sortedArrayToBST(nums);
		System.out.println(tree);
	}

}
