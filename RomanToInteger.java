package net.test.testng.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class RomanToInteger {

	public int romanToInt(String s) {

		int result = 0;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);

		if (null != map.get(s)) {
			return map.get(s);
		}

		int pos = 0;
		while (pos <= s.length()-1) {
			String crnt = String.valueOf(s.charAt(pos));
			if (pos+1==s.length()) {
				result += map.get(crnt);
			} else if (map.get(crnt) >= map.get(String.valueOf(s.charAt(pos+1)))) {
				result += map.get(crnt);
			} else {
				result -= map.get(crnt);
			}
			pos++;
		}
		return result;

	}

	@Test
	public void testRomanToInt() {
		System.out.println("XI:" + romanToInt("XI"));
		System.out.println("DXC:" + romanToInt("DXC"));
		System.out.println("CMXCIX:" + romanToInt("CMXCIX"));
//		System.out.println("XI:" + romanToInt("XI"));
//		System.out.println("XI:" + romanToInt("XI"));
//		System.out.println("XI:" + romanToInt("XI"));
	}
}
