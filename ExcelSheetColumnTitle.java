package net.test.testng.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class ExcelSheetColumnTitle {
	/**
	 * @param n
	 * @return
	 */
	public String convertToTitle(int n) {
		String s = "";
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		for (int i = 0; i < 26; i++) {
			map.put(i, (char) ('A' + i - 1));
		}

		while (n / 26 != 0) {
			if (n == 26) {
				s = 'Z' + s;
				return s;
			} else if (n % 26 == 0) {
				s = 'Z' + s;
				n = n / 26 - 1;
			} else {
				s = map.get((n % 26)) + s;
				n = n / 26;
			}

		}
		return map.get(n).toString() + s;
	}

	@Test
	public void testConvertToTitle() {
		Assert.assertEquals("A", convertToTitle(1));
		Assert.assertEquals("B", convertToTitle(2));
		Assert.assertEquals("C", convertToTitle(3));
		Assert.assertEquals("D", convertToTitle(4));
		Assert.assertEquals("E", convertToTitle(5));
		Assert.assertEquals("F", convertToTitle(6));
		Assert.assertEquals("G", convertToTitle(7));
		Assert.assertEquals("H", convertToTitle(8));
		Assert.assertEquals("I", convertToTitle(9));
		Assert.assertEquals("J", convertToTitle(10));
		Assert.assertEquals("K", convertToTitle(11));
		Assert.assertEquals("L", convertToTitle(12));
		Assert.assertEquals("M", convertToTitle(13));
		Assert.assertEquals("N", convertToTitle(14));
		Assert.assertEquals("O", convertToTitle(15));
		Assert.assertEquals("P", convertToTitle(16));
		Assert.assertEquals("Q", convertToTitle(17));
		Assert.assertEquals("R", convertToTitle(18));
		Assert.assertEquals("S", convertToTitle(19));
		Assert.assertEquals("T", convertToTitle(20));
		Assert.assertEquals("U", convertToTitle(21));
		Assert.assertEquals("V", convertToTitle(22));
		Assert.assertEquals("W", convertToTitle(23));
		Assert.assertEquals("X", convertToTitle(24));
		Assert.assertEquals("Y", convertToTitle(25));
		Assert.assertEquals("Z", convertToTitle(26));

		Assert.assertEquals("AA", convertToTitle(27));
		Assert.assertEquals("AB", convertToTitle(28));
		Assert.assertEquals("AC", convertToTitle(29));
		Assert.assertEquals("AD", convertToTitle(30));

		Assert.assertEquals("AZ", convertToTitle(52));
		Assert.assertEquals("DG", convertToTitle(111));
		Assert.assertEquals("BZ", convertToTitle(78));
		
		Assert.assertEquals("YYZ",convertToTitle(17576));
		Assert.assertEquals("YZA",convertToTitle(17577));

	}
}
