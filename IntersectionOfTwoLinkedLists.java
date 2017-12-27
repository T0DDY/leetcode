package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

import net.test.testng.leetcode.pub.ListNode;

/**
 * @author T0DD
 * 
 */
public class IntersectionOfTwoLinkedLists {
	/**
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int lenA = lenOfList(headA);
		int lenB = lenOfList(headB);
		if (lenA == 0 || lenB == 0) {
			return null;
		}
		if(headA==headB){
			return headA;
		}

		ListNode a = headA;
		ListNode b = headB;
		while (lenA > lenB) {
			a = a.next;
			lenA--;
		}
		while (lenB > lenA) {
			b = b.next;
			lenB--;
		}
		while (a != null && b != null && a != b) {
			a = a.next;
			b = b.next;
		}
		return a;

	}

	public int lenOfList(ListNode list) {
		if (null == list) {
			return 0;
		}
		int len = 0;
		while (list != null) {
			len++;
			list = list.next;
		}
		return len;
	}

	@Test
	public void testGetIntersectionNode() {
		System.out.println("Tests begin.");

		ListNode a1 = new ListNode(4);
		ListNode a2 = new ListNode(1);
		ListNode a3 = new ListNode(8);
		ListNode a4 = new ListNode(9);
		ListNode a5 = new ListNode(7);
		ListNode b1 = new ListNode(3);
		ListNode b2 = new ListNode(2);
		ListNode b3 = new ListNode(10);
		ListNode b4 = new ListNode(5);
		ListNode c1 = new ListNode(6);

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;

		b1.next = b2;
		b2.next = b3;
		b3.next = b4;
		Assert.assertNull(getIntersectionNode(a1, b1));

		b4.next = c1;
		a5.next = c1;
		Assert.assertEquals(c1, getIntersectionNode(a1, b1));

		Assert.assertEquals(c1, getIntersectionNode(a2, b1));
		Assert.assertEquals(c1, getIntersectionNode(a4, b1));
		Assert.assertEquals(c1, getIntersectionNode(a2, b3));
		Assert.assertEquals(c1, getIntersectionNode(a1, b4));
		Assert.assertEquals(c1, getIntersectionNode(a5, b4));

		Assert.assertEquals(c1,getIntersectionNode(c1, b1));
		Assert.assertEquals(c1,getIntersectionNode(c1, a1));

		Assert.assertNull(getIntersectionNode(null, null));

		b4.next = null;
		a5.next = null;
		Assert.assertNull(getIntersectionNode(a1, b1));

		b4.next = a3;
		Assert.assertEquals(a3, getIntersectionNode(a1, b1));

		b4.next = null;
		a5.next = b2;

		Assert.assertEquals(b2, getIntersectionNode(a1, b1));

	}

}
