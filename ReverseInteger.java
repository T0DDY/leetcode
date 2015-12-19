package net.test.testng.leetcode;

import org.junit.Test;

public class ReverseInteger {

	public int reverse(int x) {
		int a = x >= 0 ? 1 : -1;
		String s = String.valueOf(Math.abs(x));
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		sb.reverse();
		try {
			return a * Integer.valueOf(sb.toString());
		} catch (Exception e) {
			return 0;
		}

	}

	@Test
	public void testReverse() {
		System.out.println(reverse(1534236469));
	}
}
