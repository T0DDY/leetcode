package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class BestTimeToBuyAndSellStockII {
	/**
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {

		if (null == prices || prices.length == 0) {
			return 0;
		}

		int sum = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			if (diff > 0) {
				sum += diff;
			}
		}

		return sum;
	}

	@Test
	public void testMaxProfit() {
		int cases[] = { 7, 1, 18, 3, 15, 4 };
		Assert.assertEquals(29, maxProfit(cases));

		int cases1[] = { 1, 2, 4, 5 };
		Assert.assertEquals(4, maxProfit(cases1));

		int cases2[] = { 5, 3, 2, 1 };
		Assert.assertEquals(0, maxProfit(cases2));

		int cases3[] = { 17, 10, 3, 9, 21 };
		Assert.assertEquals(18, maxProfit(cases3));

		int cases4[] = { 3, 10, 3, 9, 21 };
		Assert.assertEquals(25, maxProfit(cases4));

		int cases5[] = { 3, 10, 2, 9, 21 };
		Assert.assertEquals(26, maxProfit(cases5));

		int cases6[] = { 3, 10, 9, 4, 21 };
		Assert.assertEquals(24, maxProfit(cases6));

		int cases7[] = { 3, 2, 1, 9, 4 };
		Assert.assertEquals(8, maxProfit(cases7));

		int cases8[] = { 2, 1, 2, 1, 0, 1, 2 };
		Assert.assertEquals(3, maxProfit(cases8));

		int cases9[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
		Assert.assertEquals(8, maxProfit(cases9));

	}
}
