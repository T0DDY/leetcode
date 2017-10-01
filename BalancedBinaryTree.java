package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class BalancedBinaryTree {

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
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if (null == root) {
			return true;
		}

		int diff = maxDepth(root.left) - maxDepth(root.right);
		if (diff > 1 || diff < -1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);

	}

	public int maxDepth(TreeNode node) {
		if (null == node) {
			return 0;
		}
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		return left > right ? 1 + left : 1 + right;
	}

	@Test
	public void testIsBalanced() {
		TreeNode root = new TreeNode(5);

		Assert.assertTrue(isBalanced(root));

		root.right = new TreeNode(1);
		Assert.assertTrue(isBalanced(root));

		root.right.right = new TreeNode(4);
		Assert.assertFalse(isBalanced(root));

		root.right.right.left = new TreeNode(2);
		Assert.assertFalse(isBalanced(root));

		root.left = null;
		root.right.right.left.right = new TreeNode(2);
		Assert.assertFalse(isBalanced(root));
		
		root.left = new TreeNode(4);
		Assert.assertFalse(isBalanced(root));
		
		root.left.left = new TreeNode(4);
		Assert.assertFalse(isBalanced(root));

		root.right.right.left = null;
		Assert.assertTrue(isBalanced(root));

		root.right.right.left = new TreeNode(2);
		Assert.assertFalse(isBalanced(root));

	}
}
