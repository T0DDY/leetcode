package net.test.testng.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class BinaryTreeLevelOrderTraversalII {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		if (null == root) {
			return Collections.emptyList();
		}

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		return levelReverse(root, res, 1);
	}

	public List<List<Integer>> levelReverse(TreeNode root,
			List<List<Integer>> resList, int level) {

		List<List<Integer>> resultList = new ArrayList<>();
		resultList = resList;
		if (null == root) {
			return resultList;
		}

		int size = resultList.size();
		if (size >= level) {
			resultList.get(size-level).add(root.val);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			resultList.add(0, list);// 这里还要判断是否已经在这个位子上存在list了 。size
									// 判断起到这个效果
		}

		levelReverse(root.left, resultList, level + 1);
		levelReverse(root.right, resultList, level + 1);

		return resultList;

	}

	@Test
	public void testLevelOrderBottom() {

		TreeNode root = new TreeNode(1);

		// System.out.println(levelOrderBottom(root));

		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(9);
		root.right.left.left = new TreeNode(8);
		root.right.left.right = new TreeNode(7);
		root.right.right.left = new TreeNode(3);
		root.right.right.right = new TreeNode(6);
		System.out.println(levelOrderBottom(root));

		// need : level , list<int> ,currentNode
		// return :isDeeperNeeded,
	}

	public boolean needDeepen(TreeNode node) {
		return node.left != null || node.right != null;
	}

}
