package net.test.testng.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {

		char[] array = s.toCharArray();
		int maxLength = 0;
		int leftLength = array.length;
		if (s == null || s.equals("")) {
			return maxLength;
		}
		Set<Character> currentChars = new HashSet<>();
		if (maxLength > leftLength) {
			return maxLength;
		}
		int i, j = 0;
		for (i = 0; i < array.length; i++) {
			for (j = i; j < array.length; j++) {
				if ((!currentChars.contains(array[j]))
						&& maxLength < leftLength) {
					System.out.println("add:" + array[j]);
					currentChars.add(array[j]);
					maxLength = maxLength > (j - i + 1) ? maxLength
							: (j - i + 1);
				} else {
					break;
				}
			}
			System.out.println("loop end:" + i);
			System.out.println("max length:" + maxLength);
			leftLength--;
			currentChars.clear();
			System.out.println("Set Clear.\n\n");
		}

		return maxLength;
	}

	public int lengthOfLongestSubstring2(String s) {

		Map<Character, Integer> maxLengthMap = new HashMap<>();
		Map<Character, Integer> lastCharPosition = new HashMap<>();
		Set<Character> occuredChar = new HashSet<>();

		char[] array = s.toCharArray();

		for (int i = 0; i < array.length; i++) {
			if (occuredChar.contains(array[i])) {
				if (maxLengthMap.get(array[i]) == null) {
					maxLengthMap.put(array[i], i);
					lastCharPosition.put(array[i], i);
				} else {
					maxLengthMap
							.put(array[i],
									maxLengthMap.get(array[i]) > i
											- lastCharPosition.get(array[i]) ? maxLengthMap
											.get(array[i]) : i
											- lastCharPosition.get(array[i]));
					lastCharPosition.put(array[i], i);
				}
			} else {
				maxLengthMap.put(array[i], i);
				lastCharPosition.put(array[i], i);
			}
		}

		return 0;
	}

	@Test
	public void testLentghOfLongestSubstring() {
		String s = "";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
