package net.test.testng.leetcode;

import org.junit.Test;

public class AddTwoNumbers {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// (2 -> 4 -> 3) + (5 -> 6 -> 4)
	// 7 -> 0 -> 8
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 != null && l2 != null) {
			int tmp = 0;
			tmp = l1.val + l2.val;
			ListNode tmpnoNode = new ListNode(0);
			if (tmp < 10) {
				tmpnoNode.val = tmp;
			} else {
				tmpnoNode.val = tmp - 10;
				if (l1.next != null) {
					l1.next.val += 1;
				} else if (l2.next != null) {
					l2.next.val += 1;
				} else {
					l1.next = new ListNode(1);
				}
			}
			tmpnoNode.next = addTwoNumbers(l1.next, l2.next);
			return tmpnoNode;
		}
		if (l1 != null && l2 == null) {
			if (l1.val >= 10) {
				if (l1.next == null) {
					l1.next = new ListNode(1);
				} else {
					l1.next.val += 1;
				}
				l1.val = l1.val - 10;
			}
			l1.next = addTwoNumbers(null, l1.next);
			return l1;
		}
		if (l1 == null && l2 != null) {
			if (l2.val >= 10) {
				if (l2.next == null) {
					l2.next = new ListNode(1);
				} else {
					l2.next.val += 1;
				}
				l2.val = l2.val - 10;
			}
			l2.next = addTwoNumbers(null, l2.next);
			return l2;
		}
		return null;
		// return addTwoNumbersWithCarry(l1, l2, 0);
	}

	@Test
	public void testAddTwoNumbers() {
		ListNode l1 = new ListNode(8);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(7);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(2);

		ListNode l3 = new ListNode(0);
		l3.next = new ListNode(1);
		ListNode l4 = new ListNode(2);
		//
		// System.out.println("l1:\n");
		// while(l1!=null){
		//
		// System.out.println(" -> "+l1.val);
		// l1 = l1.next;
		//
		// }
		//
		// System.out.println("\nl2:\n");
		// while(l2!=null){
		//
		// System.out.println(" -> "+l2.val);
		// l2 = l2.next;
		// }
		// addTwoNumbers(l1, l2);

		ListNode resultListNode = addTwoNumbers(l1, l4);

		// System.out.println("\nresult:\n");
		// while (l2 != null) {
		//
		// System.out.println(" -> " + l2.val);
		// l2 = l2.next;
		// }

		System.out.println("\nresult:\n");
		while (resultListNode != null) {

			System.out.println(" -> " + resultListNode.val);
			resultListNode = resultListNode.next;
		}
	}

	public ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0)
			return null;
		int sum = 0;
		sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
		if (sum >= 10) {
			sum = sum - 10;
			carry = 1;
		} else {
			carry = 0;
		}
		ListNode tmp = new ListNode(sum);
		tmp.next = addTwoNumbersWithCarry(l1 == null ? null : l1.next,
				l2 == null ? null : l2.next, carry);
		return tmp;
	}
}
