package net.test.testng.leetcode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class AddBinary {

	public String addBinary(String a, String b) {
		if (a == null || b == null) {
			return a == null ? b : a;
		}

		int carry = 0;
		int lenA = a.length();
		int lenB = b.length();
		int i = 0;
		String res = "";
		while (i < lenA || i < lenB || carry != 0) {
			int tA = i < lenA ? (a.charAt(lenA - 1 - i) == '1' ? 1 : 0) : 0;
			int tB = i < lenB ? (b.charAt(lenB - 1 - i) == '1' ? 1 : 0) : 0;
			res = (tA + tB + carry) % 2 + res;
			carry = (tA + tB + carry) / 2;
			i++;
		}
		return res;
	}

	@Test
	public void testAddBinary() {
		// System.out.println("0123".substring(0, 4));
		System.out.println(addBinary("11", "1"));
		Assert.assertEquals("100", addBinary("11", "1"));
		Assert.assertEquals("11", addBinary("10", "1"));
		Assert.assertEquals("10", addBinary("1", "1"));
		Assert.assertEquals("110", addBinary("101", "1"));
		Assert.assertEquals("111", addBinary("110", "1"));
		Assert.assertEquals("1000", addBinary("111", "1"));
		Assert.assertEquals("1000", addBinary("1", "111"));
		Assert.assertEquals("100", addBinary("11", "1"));
		Assert.assertEquals("100", addBinary("11", "1"));
	}
}
