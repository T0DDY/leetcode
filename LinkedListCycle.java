package net.test.testng.leetcode;

import net.test.testng.leetcode.pub.ListNode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class LinkedListCycle {

	/**
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {

		if (null == head) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (slow.next != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void testHasCycle() {

		Assert.assertFalse(hasCycle(null));

		ListNode node1 = new ListNode(1);
		Assert.assertFalse(hasCycle(node1));

		ListNode node2 = new ListNode(2);
		node1.next = node2;
		Assert.assertFalse(hasCycle(node1));

		ListNode node3 = new ListNode(3);
		node2.next = node3;
		Assert.assertFalse(hasCycle(node1));

		ListNode node4 = new ListNode(4);
		node3.next = node4;
		Assert.assertFalse(hasCycle(node1));

		ListNode node5 = new ListNode(5);
		node4.next = node5;
		node5.next = node1;
		Assert.assertTrue(hasCycle(node1));
		node5.next = node2;
		Assert.assertTrue(hasCycle(node1));

		ListNode node6 = new ListNode(6);
		node5.next = node6;
		node6.next = node5;
		Assert.assertTrue(hasCycle(node1));

		node2.next = node1;
		Assert.assertTrue(hasCycle(node1));

	}
}
