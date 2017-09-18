package net.test.testng.leetcode;

import org.junit.Test;

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {

		if (null == s || s.length() == 0) {
			return 0;
		}

		String[] words = s.split(" ");
		try {
			return words[words.length - 1].length();
		} catch (Exception e) {
			return 0;
		}

	}

	@Test
	public void testLengthOfLastWord() {
		String str = "     ";
		System.out.println(lengthOfLastWord(str));
	}
}
