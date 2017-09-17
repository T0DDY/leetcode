package net.test.testng.leetcode;

import org.junit.Test;

public class ImplementStrStr {

	public int strStr(String haystack, String needle) {

		if (haystack == null || needle == null
				|| haystack.length() < needle.length()) {
			return -1;
		}
		char hay[] = haystack.toCharArray();
		char nee[] = needle.toCharArray();

		int i = 0;
		while (i <= hay.length - nee.length) {
			if (compareTwoArray(subArray(hay, i, i + nee.length - 1), nee)) {
				return i;
			} else {
				i++;
			}
		}

		return -1;
	}

	public boolean compareTwoArray(char[] array1, char[] array2) {
		if (array1 == null && array2 == null) {
			return true;
		}
		if (array1 == null || array2 == null || array1.length != array2.length) {
			return false;
		}
		int i = 0;
		while (i < array1.length && array1[i] == array2[i]) {
			i++;
		}
		return i == array1.length;
	}

	public char[] subArray(char[] array, int start, int end) {
		char[] sub = new char[end - start + 1];
		int i = start;
		int j = 0;
		while (i <= end) {
			sub[j] = array[i];
			i++;
			j++;
		}
		return sub;

	}

	@Test
	public void testStrStr() {
		String str = "abcdabdeeed";
		strStr("", str);
		char[] a = { 'b', 'b', 'c' };
		char[] b = { 'b', 'b', 'a' };
		System.out.println(compareTwoArray(a, b));

		System.out.println("sub:"
				+ String.valueOf(subArray(str.toCharArray(), 1, 3)));
		
		System.out.println("result:"+strStr(str, "abd"));
	}

}
