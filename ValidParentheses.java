package net.test.testng.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;
/**
 * to be improved.
 * @author ThinkPad
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {

		// defensive programming
		if (null == s || s.length() == 0) {
			return true;
		}
		// 如果是奇数长度 一定不能匹配，节省时间的情况下，只判断长度可排除很多错误情况
		if (1 == s.length() % 2) {
			return false;
		}
		// 用栈的数据结构进行。
		Stack<Character> allCharacters = new Stack<>();
		Set<Character> allRight = new HashSet<>();
		allRight.add('}');
		allRight.add(']');
		allRight.add(')');
		Map<Character, Character> couple = new HashMap<Character, Character>();
		couple.put('}', '{');
		couple.put(']', '[');
		couple.put(')', '(');

		char[] array = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (allRight.contains(array[i])) {
				if (allCharacters.isEmpty() || ! allCharacters.pop().equals(couple.get(array[i])) ) {
					return false;
				}
			} else {
				allCharacters.push(array[i]);
			}
		}

		// 遇到左括号入栈，遇到右括号出栈，并将该左括号和出栈的元素进行比较。
		return allCharacters.isEmpty();
	}
	
	@Test
	public void testIsValid() {
		String s = "{}}}";
		System.out.println(isValid(s));
	}
}
