package net.test.testng.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class IntegerToRoman {

	public String intToRomanOrignal(int num) {

		// first ,define the mapping
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "I");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");

		List<Integer> list = new ArrayList<Integer>();
		list.add(1000);
		list.add(900);
		list.add(500);
		list.add(100);
		list.add(90);
		list.add(50);
		list.add(10);
		list.add(9);
		list.add(5);
		list.add(1);

		StringBuilder result = new StringBuilder();
		int index = 0;
		// parse a number
		while (num != 0) {
			// parse each digit
			int number = num / list.get(index);
			while (number != 0) {
				if (number < 4) {
					result.append(map.get(list.get(index)));
					number--;
				} else {
					// IV = 5
					result.append(map.get(list.get(index)));
					result.append(map.get(list.get(index - 1)));
					number = 0;
				}
			}
			num = num % list.get(index);
			index++;
		}

		return result.toString();
	}

	public String intToRomanFull(int num) {
		String result = new String();

		for (int i = 0; i < num / 1000; i++) {
			result += 'M';
		}
		num = num % 1000;
		int zeros = 100;
		String tens = "MCX";
		String fives = "DLV";
		String ones = "CXI";
		int n = 0;
		while (zeros != 0) {
			int digit = num / zeros;
			if (digit >= 1 && digit <= 3) {
				for (int i = 0; i < digit; i++) {
					result += ones.charAt(n);
				}
			} else if (digit == 4) {
				result += ones.charAt(n);
				result += fives.charAt(n);
			} else if (digit <= 8 && digit > 4) {
				result += fives.charAt(n);
				for (int i = 5; i < digit; i++) {
					result += ones.charAt(n);
				}
			} else if (digit == 9) {
				result += ones.charAt(n);
				result += tens.charAt(n);
			}
			num = num % zeros;
			zeros /= 10;
			n++;
		}
		return result;
	}

	public String intToRoman(int num) {

		// first ,define the mapping
		String[] heavy = { "M", "CM", "D", "C", "XC", "L", "X", "IX", "V", "I" };

		int[] list = { 1000, 900, 500, 100, 90, 50, 10, 9, 5, 1 };

		StringBuilder result = new StringBuilder();
		int index = 0;
		// parse a number
		while (num != 0) {
			// parse each digit
			int number = num / list[index];
			while (number != 0) {
				if (number < 4) {
					result.append(heavy[index]);
					number--;
				} else {
					// IV = 5
					result.append(heavy[index]);
					result.append(heavy[index - 1]);
					number = 0;
				}
			}
			num = num % list[index];
			index++;
		}

		return result.toString();
	}

	@Test
	public void test() {
		System.out.println("8:" + intToRoman(8));
		System.out.println("10:" + intToRoman(10));
		System.out.println("100:" + intToRoman(100));
		System.out.println("1994:" + intToRoman(1994));
		System.out.println("1000:" + intToRoman(1000));
		System.out.println("1:" + intToRoman(1));
		System.out.println("9:" + intToRoman(9));
		System.out.println("3999:" + intToRoman(3999));
	}

}
