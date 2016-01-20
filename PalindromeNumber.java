package net.test.testng.leetcode;

import org.junit.Test;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {

		if (x == 0) {
			return true;
		}
		if (x < 0) {
			return false;
		}

		int len = 0;
		for (long i = 1;; i *= 10) {
			if (x / i == 0) {
				len = (int)(i/10);
				break;
			}
		}
		System.out.println(len);
		for (int left = len, right = 1; right < left;) {
			if (x == 0) {
				return true;
			}
			x = x - (x / left) * left - (x / left) * right;
			System.out
					.println("x:" + x + "  left:" + left + "  right:" + right);
			left = left / 10;
			right = right * 10;
			if (right == left) {
				x = x - (x / left) * left;
			}
		}
		if (x == 0) {
			return true;
		}

		return false;

	}

	@Test
	public void test() {
		System.out.println(isPalindrome(1000000001));
	}
}
