package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NBy3Integer {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(4);
		l.add(3);
		l.add(1);
		System.out.println(repeatedNumber(l));

	}

	public static int repeatedNumber(final List<Integer> a) {

		int result = -1;
		Map<Integer, Integer> intCount = new HashMap<>();
		for(Integer i:a) {
			intCount.computeIfPresent(i, (k,v)-> v+1);
			intCount.computeIfAbsent(i, k -> 1);
		}
		
		for(Entry<Integer, Integer> entry:intCount.entrySet()) {
			if((a.size()/3)<entry.getValue()) {
				result = entry.getKey();break;
			}
		}
		
		return result;
	}
}
