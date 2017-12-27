package net.test.testng.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class CompareVersionNumbers {
	/**
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion(String version1, String version2) {
		if (version1 == version2) {
			return 0;
		}
		// version2 > version1 , then return -1.

		String array1[] = version1.split("\\.");
		String array2[] = version2.split("\\.");
		int i = 0;
		while (i < array1.length && i < array2.length) {
			Integer valueOfV1 = Integer.valueOf(array1[i]);
			Integer valueOfV2 = Integer.valueOf(array2[i]);
			if (valueOfV1 < valueOfV2) {	
				return -1;
			} else if (valueOfV1 > valueOfV2) {
				return 1;
			}
			i++;
		}
		if (array1.length < array2.length) {
			while (i < array2.length && Integer.valueOf(array2[i]) == 0) {
				i++;
			}
			return i == array2.length ? 0 : -1;
		} else if (array1.length > array2.length) {
			while (i < array1.length && Integer.valueOf(array1[i]) == 0) {
				i++;
			}
			return i == array1.length ? 0 : 1;
		}

		return 0;
	}

	@Test
	public void testCompareVersion() {

		// 1
		Assert.assertEquals(-1, compareVersion("1", "2"));
		Assert.assertEquals(0, compareVersion("1", "1"));
		Assert.assertEquals(0, compareVersion("0", "0"));

		// 1.1
		Assert.assertEquals(-1, compareVersion("1.1", "1.2"));
		Assert.assertEquals(-1, compareVersion("1.1", "1.10"));
		Assert.assertEquals(-1, compareVersion("1.0", "1.10"));

		// 1.10

		// 1.1.1
		Assert.assertEquals(-1, compareVersion("1.0", "1.1.0"));
		Assert.assertEquals(-1, compareVersion("1.0", "1.0.1"));
		Assert.assertEquals(0, compareVersion("1.0", "1.0.0"));

		//
		Assert.assertEquals(1, compareVersion("1.1", "1"));
	}
}
