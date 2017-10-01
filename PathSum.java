package net.test.testng.leetcode;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import net.test.testng.leetcode.pub.TreeNode;

/**
 * @author T0DD
 * 
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {

		return everyPathSum(root, 0).contains(sum);

	}

	public Set<Integer> everyPathSum(TreeNode node, int currentSum) {
		Set<Integer> set = new HashSet<>();
		if (null == node) {
			return set;
		}
		if (null == node.left && null == node.right) {
			set.add(currentSum + node.val);
		}
		if (null != node.left) {
			set.addAll(everyPathSum(node.left, currentSum + node.val));
		}
		if (null != node.right) {

			set.addAll(everyPathSum(node.right, currentSum + node.val));
		}
		return set;
	}

	@Test
	public void testHasPathSum() {
		
		Assert.assertFalse(hasPathSum(null, 0));
		
		TreeNode tree = new TreeNode(1);
		Assert.assertTrue(hasPathSum(tree, 1));

		tree.left = new TreeNode(2);
		Assert.assertTrue(hasPathSum(tree, 3));
		Assert.assertFalse(hasPathSum(tree, 2));
		Assert.assertFalse(hasPathSum(tree, 1));

		tree.right = new TreeNode(5);
		Assert.assertTrue(hasPathSum(tree, 6));
		Assert.assertTrue(hasPathSum(tree, 3));
		Assert.assertFalse(hasPathSum(tree, 2));
		Assert.assertFalse(hasPathSum(tree, 1));
		Assert.assertFalse(hasPathSum(tree, 5));
		
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(8);
		Assert.assertTrue(hasPathSum(tree, 7));
		Assert.assertTrue(hasPathSum(tree, 11));
		Assert.assertTrue(hasPathSum(tree, 6));
		
		tree.left.left.left = new TreeNode(2);
		Assert.assertTrue(hasPathSum(tree, 9));
		
		tree.right=null;
		Assert.assertFalse(hasPathSum(tree, 6));
		Assert.assertTrue(hasPathSum(tree, 9));

	}
}
