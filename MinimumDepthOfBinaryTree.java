package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class MinimumDepthOfBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {

		// 必须判断是不是叶子节点
		if (null == root) {
			return 0;
		}

		if (null == root.left && null == root.right) {
			return 1;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		if (null != root.left && null != root.right) {

			return left < right ? left + 1 : right + 1;
		}
		return null != root.left ? left + 1 : right + 1;
	}

	@Test
	public void testMinDepth() {

		TreeNode root = new TreeNode(5);
		Assert.assertEquals(1, minDepth(root));

		root.left = new TreeNode(4);
		Assert.assertEquals(2, minDepth(root));

		root.right = new TreeNode(1);
		Assert.assertEquals(2, minDepth(root));

		// root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		Assert.assertEquals(2, minDepth(root));

		// root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		Assert.assertEquals(3, minDepth(root));

		// root.left.left.left = new TreeNode(2);
		// root.left.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(2);
		// root.left.right.right = new TreeNode(2);
		Assert.assertEquals(3, minDepth(root));

		// root.right.left.left = new TreeNode(2);
		// root.right.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(2);
		// root.right.right.right = new TreeNode(2);
		Assert.assertEquals(4, minDepth(root));

		root.left = null;
		root.right.right.left.right = new TreeNode(2);
		Assert.assertEquals(5, minDepth(root));

		root.left = new TreeNode(4);
		root.left.right = new TreeNode(2);
		Assert.assertEquals(3, minDepth(root));

	}

}
