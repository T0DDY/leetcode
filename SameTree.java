package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 *
 */
public class SameTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}

		return false;
	}

	@Test
	public void testIsSameTree() {

		TreeNode a = new TreeNode(1);
		TreeNode a1 = new TreeNode(3);
		TreeNode a2 = new TreeNode(4);
		a.left = a1;
		a.right = a2;

		TreeNode b = new TreeNode(1);
		TreeNode b1 = new TreeNode(3);
		TreeNode b2 = new TreeNode(4);
		b.left = b1;
		b.right = b2;

		Assert.assertTrue(isSameTree(a, b));

		a.left = null;
		Assert.assertFalse(isSameTree(a, b));

		b.left = null;
		Assert.assertTrue(isSameTree(a, b));

		a.right.left = new TreeNode(7);
		Assert.assertFalse(isSameTree(a, b));

		b.right.left = new TreeNode(8);
		Assert.assertFalse(isSameTree(a, b));

		b.right.left.val = 7;
		Assert.assertTrue(isSameTree(a, b));
		
		a.val=0;
		Assert.assertFalse(isSameTree(a, b));
		
		a = null;
		b = null;
		Assert.assertTrue(isSameTree(a, b));

	}

}