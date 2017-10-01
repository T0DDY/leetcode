package net.test.testng.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author T0DD
 *
 */
public class PascalsTriangle {
	
    public List<List<Integer>> generate(int numRows) {
    	
    	/*			1
    	 * 		   1 1
    	 *		  1 2 1 
    	 * 		1  3 3  1
    	 * 	  1   4 6  4 1
    	 *   1  5  10 10 5 1
    	 * 
    	 */
		if (numRows <= 0) {
			return Collections.emptyList();
		}
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		triangle.add(list1);
		if (1 == numRows) {
			return triangle;
		}

		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(1);
		triangle.add(list2);
		if (2 == numRows) {
			return triangle;
		}

		int size = numRows - 3;
		while (size >= 0) {

			List<Integer> element = new ArrayList<>();

			element.add(1);
			List<Integer> previous = triangle.get(triangle.size() - 1);
			for (int i = 0; i < previous.size() - 1; i++) {
				element.add(previous.get(i) + previous.get(i + 1));
			}
			element.add(1);

			triangle.add(element);
			size--;
		}

		return triangle;
    }	

    
    @Test
    public void testGenerate(){
    	System.out.println(generate(5));
    }
}
