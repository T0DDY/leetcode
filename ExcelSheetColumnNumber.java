package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class ExcelSheetColumnNumber {

	/**
	 * @param s
	 * @return
	 */
	public int titleToNumber(String s) {

		char[] charArray = s.toCharArray();

		int res = (int) charArray[charArray.length - 1] - 64;
		int weight = 26;

		for (int i = charArray.length - 2; i >= 0; i--) {
			int temp = ((int) charArray[i] - 64) * weight;
			res = res + temp;
			weight = weight * 26;
		}

		return res;
	}

	@Test
	public void testTitleToNumber() {

		System.out.println((int) 'A');

		Assert.assertEquals(1, titleToNumber("A"));

		Assert.assertEquals(26, titleToNumber("Z"));

		Assert.assertEquals(2, titleToNumber("B"));

		Assert.assertEquals(52, titleToNumber("AZ"));

		Assert.assertEquals(78, titleToNumber("BZ"));

		Assert.assertEquals(728, titleToNumber("AAZ"));

		Assert.assertEquals(703, titleToNumber("AAA"));

	}
}
