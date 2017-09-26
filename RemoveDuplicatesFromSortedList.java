package net.test.testng.leetcode;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class RemoveDuplicatesFromSortedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null) {
			return null;
		}
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}

		}

		return head;
	}

	@Test
	public void testDeleteDuplicates() {

		ListNode list = new ListNode(1);
		list.next = new ListNode(1);
		list.next.next = new ListNode(2);
		list.next.next.next = new ListNode(2);
		list.next.next.next.next = new ListNode(3);
		list.next.next.next.next.next = new ListNode(4);
		ListNode another = list;
		while (list != null) {
			System.out.println(list.val);
			list = list.next;
		}

		System.out.println("Another:");
		deleteDuplicates(another);
		while (another != null) {
			System.out.println(another.val);
			another = another.next;
		}

	}

}
