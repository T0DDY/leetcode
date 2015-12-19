package net.test.testng.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		if (s == null)
			return null;

		if (s == "" || s.length() == 1 || numRows == 0 || numRows == 1
				|| numRows > s.length()) {
			return s;
		}

		int cycle = 2 * numRows - 2;
		List<StringBuilder> list = new ArrayList<StringBuilder>();
		for (int i = 0; i < numRows; i++) {
			StringBuilder sb = new StringBuilder();
			list.add(sb);
		}

		for (int i = 0; i < s.length(); i++) {
			int j = i;
			j = j % cycle;
			if (j >= numRows) {
				j = cycle - j;
			}
			list.get(j).append(s.charAt(i));
		}

		StringBuilder sbBuilder = new StringBuilder();
		for (StringBuilder stringBuilder : list) {
			sbBuilder.append(stringBuilder.toString());
		}

		return sbBuilder.toString();
	}

	@Test
	public void testConvert() {

		String s = "ABCDEF";

		System.out.println(convert(s, 4));
	}
}
