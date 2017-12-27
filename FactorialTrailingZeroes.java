package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class FactorialTrailingZeroes {

	/**
	 * @param n
	 * @return
	 */
	public int trailingZeroes(int n) {
		if (n < 5) {
			return 0;
		}
		int res = 0;
		while (n / 5 != 0) {
			res += n / 5;
			n = n / 5;
		}

		return res;
	}

	@Test
	public void testTrailingZeroes() {
		Assert.assertEquals(0, trailingZeroes(4));
		Assert.assertEquals(1, trailingZeroes(5));
		Assert.assertEquals(1, trailingZeroes(6));
		Assert.assertEquals(1, trailingZeroes(9));
		Assert.assertEquals(2, trailingZeroes(10));
		Assert.assertEquals(2, trailingZeroes(11));
		Assert.assertEquals(24, trailingZeroes(100));
		Assert.assertEquals(26, trailingZeroes(110));

	}

}
