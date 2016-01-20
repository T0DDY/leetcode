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
		Set<Character> currentChars = new HashSet<Character>();
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

	/**
	 * The longest substring would appear among <b>Each</b> character's next.
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring2(String s) {

		Map<Character, Integer> maxLengthMap = new HashMap<Character, Integer>();
		Map<Character, Integer> lastCharPosition = new HashMap<Character, Integer>();
		Set<Character> occuredChar = new HashSet<Character>();

		char[] array = s.toCharArray();

		// over read the string.
		for (int i = 0; i < array.length; i++) {
			// if a character appear, but not exist in maxLength ,
			// it should be appear the second time.
			if (occuredChar.contains(array[i])) {
				if (maxLengthMap.get(array[i]) == null) {
					maxLengthMap.put(array[i], i);
					lastCharPosition.put(array[i], i);
				} else {
					//  it should appear more than 2 times,
					//	so, compare the existing two length
					maxLengthMap
							.put(array[i],
									maxLengthMap.get(array[i]) > i
											- lastCharPosition.get(array[i]) ? maxLengthMap
											.get(array[i]) : i
											- lastCharPosition.get(array[i]));
					// record the last position
					lastCharPosition.put(array[i], i);
				}
			} else {
				// record
				maxLengthMap.put(array[i], i);
				lastCharPosition.put(array[i], i);
			}
		}

		// should return the max length of maxLengthMap.
		return 0;
	}

	@Test
	public void testLentghOfLongestSubstring() {
		String s = "";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
