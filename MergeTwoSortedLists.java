package net.test.testng.leetcode;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class MergeTwoSortedLists {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		// defensive programming
		if (null == l1 || null == l2) {
			return null == l1 ? l2 : l1;
		}

		ListNode head = new ListNode(0);
		ListNode current = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				current.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			current = current.next;
		}

		if (l1 == null) {
			current.next = l2;
		} else {
			current.next = l1;
		}

		return head.next;
	}

	@Test
	public void testMerge() {
		ListNode list1 = null;//new ListNode(1);
//		list1.next = new ListNode(3);
		ListNode list2 = null;//new ListNode(2);
//		list2.next = new ListNode(7);
		// while (list1 != null) {
		// System.out.println(list1.val);
		// list1 = list1.next;
		// }
		ListNode lists = mergeTwoLists(list1, list2);
		while (lists != null) {
			System.out.println(lists.val);
			lists = lists.next;
		}
	}
}
