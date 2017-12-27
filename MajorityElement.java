package net.test.testng.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author T0DD
 * 
 */
public class MajorityElement {
	/**
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		int i = 0;
		int pos = 0;
		for (java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer integer = map.get(key);
			if (integer > i) {
				i = integer;
				pos = key;
			}
		}
		return pos;
	}

	@Test
	public void testMajorityElement() {

		int nums[] = { 1,1,2,3,1};

		System.out.println(majorityElement(nums));
	}
}
