package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class BestTimeToBuyAndSellStock {

	/**
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {

		if (null == prices || prices.length == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int min_pos = 0;
		int max = 0;
		int max_pos = 0;
		int diff = 0;

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] <= min) {
				min = prices[i];
				min_pos = i;
				max =0;
			}

			if (prices[i] >= max && i > min_pos) {
				max = prices[i];
				max_pos = i;
			}

			if (min_pos < max_pos && diff < max - min) {
				diff = max - min;
			}
		}

		return diff;
	}

	@Test
	public void testMaxProfit() {
		int cases[] = { 7, 1, 18, 3, 15, 4 };
		Assert.assertEquals(17, maxProfit(cases));

		int cases1[] = { 1, 2, 4, 5 };
		Assert.assertEquals(4, maxProfit(cases1));

		int cases2[] = { 5, 3, 2, 1 };
		Assert.assertEquals(0, maxProfit(cases2));

		int cases3[] = { 17, 10, 3, 9, 21 };
		Assert.assertEquals(18, maxProfit(cases3));

		int cases4[] = { 3, 10, 3, 9, 21 };
		Assert.assertEquals(18, maxProfit(cases4));

		int cases5[] = { 3, 10, 2, 9, 21 };
		Assert.assertEquals(19, maxProfit(cases5));

		int cases6[] = { 3, 10, 9, 4, 21 };
		Assert.assertEquals(18, maxProfit(cases6));

		int cases7[] = { 3, 2, 1, 9, 4 };
		Assert.assertEquals(8, maxProfit(cases7));
		
		//  this case add >=
		int cases8[] = {2,1,2,1,0,1,2};
		Assert.assertEquals(2, maxProfit(cases8));

		// this case add max=0;
		int cases9[] = {3,3,5,0,0,3,1,4};
		Assert.assertEquals(4, maxProfit(cases9));

	}
}
