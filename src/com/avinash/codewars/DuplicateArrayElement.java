package com.avinash.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateArrayElement {

	public static void main(String[] args) {
		
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(3);
		arr.add(4);
		arr.add(1);
		arr.add(4);
		arr.add(1);
		
		System.out.println(repeatedNumber(arr));

	}

	public static int repeatedNumber(final List<Integer> a) {
		
		Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		
		for(Integer i:a) {
			if(numberMap.containsKey(i)) {
				return i;
			}else {
				numberMap.put(i, 1);
			}
		}
		
		return -1;
		
    }
}
