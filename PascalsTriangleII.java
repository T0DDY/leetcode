package net.test.testng.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author T0DD
 *
 */
public class PascalsTriangleII {

	
    public List<Integer> getRow(int rowIndex) {
    	
		if (rowIndex < 0) {
			return Collections.emptyList();
		}

		List<Integer> list = new ArrayList<>();
		list.add(1);
		if (0==rowIndex) {
			return list;
		}
		if (1 == rowIndex) {
			list.add(1);
			return list;
		}

		list = getRow(rowIndex-1);
		for (int i = 0; i < list.size()-1; i++) {
			list.set(i,list.get(i)+list.get(i+1));
		}
		list.add(0, 1);
		
		return list;
    }
    
    @Test
    public void testGetRow(){
    	System.out.println(getRow(0));
    	System.out.println(getRow(1));
    	System.out.println(getRow(2));
    	System.out.println(getRow(3));
    	System.out.println(getRow(4));
    	System.out.println(getRow(5));
    	System.out.println(getRow(6));
    	System.out.println(getRow(7));    	System.out.println(getRow(8));
    }
}
