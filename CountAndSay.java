package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class CountAndSay {
	public String countAndSay(int n) {

		if (n == 1) {
			return "1";
		} else if (n == 2) {
			return "11";
		}

		String previous = countAndSay(n - 1);

		return count(previous);

	}

	private String count(String previous) {
		char[] array = previous.toCharArray();
		String result = new String();
		int i = 0;
		int count = 1;
		while (i < array.length - 1) {
			if (array[i] == array[i + 1]) {
				count++;
			} else {
				result = result + count + array[i];
				count = 1;
			}
			i++;
		}
		return result + count + array[i];
	}

	@Test
	public void testCountAndSay() {
		Assert.assertEquals("312211", countAndSay(6));
	}

	// @Test
	public void testPreviousCount() {
		Assert.assertEquals("21", count("11"));
	}
}
