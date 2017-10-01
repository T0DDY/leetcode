package net.test.testng.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class ValidPalindrome {
	/**
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {

		if (null == s || s.length() == 0 || s.trim().length() == 0) {
			return true;
		}

		List<Character> list = new ArrayList<Character>();

		// for (int i = 0; i < list.size(); i++) {
		//
		// }
		for (Character character : s.toCharArray()) {
			if (Character.isLetter(character) || Character.isDigit(character)) {
				list.add(Character.toLowerCase(character));
			}
		}
		int i = 0;
		int size = list.size();
		if (size <= 1) {
			return true;
		}
		while (i <= size / 2 && list.get(i) == list.get(size - 1 - i)) {
			i++;
		}

		// System.out.println("i is :"+i);
		return i >= size / 2;
	}

	@Test
	public void testIsPalindrome() {
		String string = "A Man, A Plan, A Canal: Panama";
		List<Character> list = new ArrayList<Character>();
		for (Character character : string.toCharArray()) {
			if (Character.isLetter(character)) {
				list.add(Character.toLowerCase(character));
			}
		}

		System.out.println(list);
		System.out.println(isPalindrome(string));
		String s1 = " smile is beauty.";
		System.out.println(isPalindrome(s1));
		String s2 = " oooottoooo...";
		System.out.println(isPalindrome(s2));

		String s3 = " o~ anna O!";
		System.out.println(isPalindrome(s3));

		String s4 = " o~ 1anna 1O!";
		System.out.println(isPalindrome(s4));

		String s5 = "    ";
		System.out.println(isPalindrome(s5));

		String s6 = "  a ba ";
		System.out.println(isPalindrome(s6));

		String s7 = "...";
		System.out.println(isPalindrome(s7));

		String s8 = "1221";
		System.out.println(isPalindrome(s8));

		String s9 = "12.21";
		System.out.println(isPalindrome(s9));

		String s10 = "a";
		System.out.println(isPalindrome(s10));

		String s11 = "aa";
		System.out.println(isPalindrome(s11));
	}
}
