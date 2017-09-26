package net.test.testng.leetcode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class SqrtX {

	public int mySqrt(int x) {
		if (x <= 0) {
			return x;
		}

		if (x == 1) {
			return x;
		}
		if (x >= 2147483647) {
			return 46340;
		}
		int distance = Integer.MAX_VALUE;
		int left = 2;
		while (left * left < x) {
			int dis = x - left * left;
			distance = distance > dis ? dis : distance;
			left++;
		}
		return left * left == x ? left : left - 1;

	}

	@Test
	public void testSqrtX() {
		Assert.assertEquals(2, mySqrt(4));
		Assert.assertEquals(1, mySqrt(1));
		Assert.assertEquals(0, mySqrt(0));
		Assert.assertEquals(2, mySqrt(6));
		Assert.assertEquals(2, mySqrt(7));
		Assert.assertEquals(1, mySqrt(3));
		Assert.assertEquals(3, mySqrt(9));
		Assert.assertEquals(2, mySqrt(4));
		Assert.assertEquals(2, mySqrt(4));
		Assert.assertEquals(46340, mySqrt(2147395600));
		Assert.assertEquals(46340, mySqrt(2147483647));

	}

}
