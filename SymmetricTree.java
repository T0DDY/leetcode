package net.test.testng.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SymmetricTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}

		TreeNode newone = reverseTree(root);

		// List<Integer> list = new ArrayList<>();
		// list = midOrderTraverse(root);
		// for (Integer integer : list) {
		// System.out.println(integer);
		// }
		//
		// int size = list.size();
		// if (size % 2 == 0) {
		// return false;
		// }
		// int mid = size / 2;
		// int j = 0;
		// while (j <= size - 1 - j && list.get(j) == list.get(size - 1 - j)) {
		// j++;
		// }
		// System.out.println("j is " + j);
		// return j >= mid;

		return isSame(root, newone);

	}

	public boolean isSame(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p != null && q != null && p.val == q.val) {
			return isSame(p.left, q.left) && isSame(p.right, q.right);
		}

		return false;
	}

	public TreeNode reverseTree(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode newone = new TreeNode(node.val);
		if (node.left == null && node.right == null) {
			return newone;
		} else {
			newone.left = reverseTree(node.right);
			newone.right = reverseTree(node.left);
		}
		return newone;
	}

	public List<Integer> midOrderTraverse(TreeNode tree) {

		List<Integer> list = new ArrayList<>();

		if (tree.left != null && tree.right != null) {
			list.addAll(midOrderTraverse(tree.left));
			list.add(tree.val);
			list.addAll(midOrderTraverse(tree.right));
		} else if (tree.left != null) {
			list.addAll(midOrderTraverse(tree.left));
			list.add(tree.val);
			list.add(null);
		} else if (tree.right != null) {
			list.add(null);
			list.add(tree.val);
			list.addAll(midOrderTraverse(tree.right));
		} else {
			list.add(tree.val);
		}

		return list;
	}

	@Test
	public void testIsSymmetric() {
		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(4);
		root.right = new TreeNode(1);

		// root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		// root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(4);

		// root.left.left.left = new TreeNode(2);
		// root.left.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(2);
		// root.left.right.right = new TreeNode(2);

		// root.right.left.left = new TreeNode(2);
		// root.right.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(2);
		// root.right.right.right = new TreeNode(2);

		Assert.assertFalse(isSymmetric(root));

		// [1,2,3,3,null,2,null] wrong case.
		// [5,4,1,null,1,null,4,2,null,2,null] wrong case
	}

	@Test
	public void testIsSymmetric2() {
		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(1);
		root.right = new TreeNode(1);

		// root.left.left = new TreeNode(3);
		// root.left.right = new TreeNode(1);
		// root.right.left = new TreeNode(5);
		// root.right.right = new TreeNode(4);

		// root.left.left.left = new TreeNode(2);
		// root.left.left.right = new TreeNode(2);
		// root.left.right.left = new TreeNode(2);
		// root.left.right.right = new TreeNode(2);

		// root.right.left.left = new TreeNode(2);
		// root.right.left.right = new TreeNode(2);
		// root.right.right.left = new TreeNode(2);
		// root.right.right.right = new TreeNode(2);

		Assert.assertTrue(isSymmetric(root));

		// [1,2,3,3,null,2,null] wrong case.
		// [5,4,1,null,1,null,4,2,null,2,null] wrong case
	}

	@Test
	public void testIsSymmetric3() {
		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(1);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(3);

		Assert.assertFalse(isSymmetric(root));

		root.left.right.val = 5;
		Assert.assertTrue(isSymmetric(root));

		TreeNode root1 = new TreeNode(5);

		Assert.assertTrue(isSymmetric(root1));
		root1.left = new TreeNode(1);
		Assert.assertFalse(isSymmetric(root1));

	}

}
