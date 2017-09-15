package net.test.testng.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class LongestCommonPrefix {

	/**
	 * 用矩阵的方式解决问题。 判断每一列是否都一样。
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {

		//defensive programming
		if(null == strs || strs.length == 0){
			return "";
		}
		List<Set<Character>> matrix = new ArrayList<Set<Character>>();
		int shortestStrLength = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {

			// defensive programming
			if(null == strs[i] || strs[i].length() == 0){
				return "";
			}
			// 计算当前字符串长度，与最小值进行比较
			int wordLength = strs[i].length();
			if (shortestStrLength > wordLength) { // 如果已经结束，则最长前缀就是这个长度。
				shortestStrLength = wordLength;
			}
			//对一个单词进行循环
			for (int j = 0; j < wordLength; j++) {
			// 如果已经超过前面记录的最短长度，就没必要继续计算了
				if(j>shortestStrLength){
					// 跳出本次循环
					break;
				}
			// 如果在相应的位置已经有存在set，则直接加入该单词在这个位置的字符，否则要new一个
				if(j+1 > matrix.size()){
					Set<Character> innerSet = new HashSet<>();
					matrix.add(innerSet);
				}
				matrix.get(j).add(strs[i].charAt(j));
			}
		}
		
		int longestCommonPrefixLen =0;
		while (longestCommonPrefixLen < shortestStrLength) {
			if (matrix.get(longestCommonPrefixLen).size() == 1 ) {
				longestCommonPrefixLen++;
			}else {
				break;
			}
		}
		String result = "";
		for(int i = 0;i<longestCommonPrefixLen;i++){
			result += matrix.get(i).toArray()[0].toString();
		}

		return result;

	}

	@Test
	public void testLongestCommonPrefix() {
		String[] testCase = { null, "abce", "abcd" };
		
		// String[] testCase = { "a", "abcccccccccccccc" };

		System.out.println(longestCommonPrefix(testCase));
	}
}
