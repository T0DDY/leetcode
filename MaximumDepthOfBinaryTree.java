package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

import net.test.testng.leetcode.SameTree.TreeNode;

/**
 * @author T0DD
 * 
 */
public class MaximumDepthOfBinaryTree {

	/**
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {

		if (null == root) {
			return 0;
		}

		// if (root.left != null || root.right != null) {
		// int leftDepth = maxDepth(root.left);
		// int rightDepth = maxDepth(root.right);
		// return leftDepth > rightDepth ? 1 + leftDepth : 1 + rightDepth;
		// }

		// return 1;

		if (null == root.left && null == root.right) {
			return 1;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return left > right ? 1 + left : 1 + right;
	}

	@Test
	public void testMaxDepth() {

		TreeNode root = new SameTree().new TreeNode(5);
		Assert.assertEquals(1, maxDepth(root));

		root.left = new SameTree().new TreeNode(4);
		Assert.assertEquals(2, maxDepth(root));

		root.right = new SameTree().new TreeNode(1);
		Assert.assertEquals(2, maxDepth(root));

		// root.left.left = new SameTree().new TreeNode(3);
		root.left.right = new SameTree().new TreeNode(1);
		Assert.assertEquals(3, maxDepth(root));

		// root.right.left = new SameTree().new TreeNode(5);
		root.right.right = new SameTree().new TreeNode(4);
		Assert.assertEquals(3, maxDepth(root));

		// root.left.left.left = new SameTree().new TreeNode(2);
		// root.left.left.right = new SameTree().new TreeNode(2);
		root.left.right.left = new SameTree().new TreeNode(2);
		// root.left.right.right = new SameTree().new TreeNode(2);
		Assert.assertEquals(4, maxDepth(root));

		// root.right.left.left = new SameTree().new TreeNode(2);
		// root.right.left.right = new SameTree().new TreeNode(2);
		root.right.right.left = new SameTree().new TreeNode(2);
		// root.right.right.right = new SameTree().new TreeNode(2);
		Assert.assertEquals(4, maxDepth(root));

		root.left = null;
		root.right.right.left.right = new SameTree().new TreeNode(2);
		Assert.assertEquals(5, maxDepth(root));

	}

}
