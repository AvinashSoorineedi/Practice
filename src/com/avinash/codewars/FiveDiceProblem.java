package com.avinash.codewars;

import java.util.HashMap;
import java.util.Map;

public class FiveDiceProblem {

	public static void main(String[] args) {
		int[] arr = {1,1,5,1,2};
		//greedy(arr);
		System.out.println(greedy(arr));
	}

	
	public static int greedy(int[] dice){
		Map<Integer, Integer> numCount = new HashMap<>();
		
		int total = 0;
		for(Integer i:dice) {
			numCount.putIfAbsent(i, new Integer(0));
			numCount.put(i, numCount.get(i)+1);
		}
		
		int threeCountNum = checkForThreeCount(numCount);
		
		int threeCount = 0;
		switch(threeCountNum) {
		 case 1 : threeCount = 1000;break;
		 case 2 : threeCount = 200;break;
		 case 3 : threeCount = 300;break;
		 case 4 : threeCount = 400;break;
		 case 5 : threeCount = 500;break;
		 case 6 : threeCount = 600;break;
		 default : break;
		}
		
		total = threeCount + checkForSingleCount(numCount);
		
		return total;
 	}


	private static int checkForSingleCount(Map<Integer, Integer> numCount) {
		
		int returnCount = 0;
		if(numCount.get(1)!=null) {
			System.out.println("Module Number is "+(numCount.get(1)%3));
			returnCount = returnCount + ((numCount.get(1)>=3)?((numCount.get(1)%3)*100):(numCount.get(1))*100);
		}
		if(numCount.get(5)!=null) {
			returnCount = returnCount + ((numCount.get(5)>=3)?((numCount.get(5)%3)*50):(numCount.get(5))*50);
		}
		
		return returnCount;
	}


	private static int checkForThreeCount(Map<Integer, Integer> numCount) {
		
		for(Map.Entry<Integer, Integer> val:numCount.entrySet()) {
			if(val.getValue()>=3) {
				return val.getKey();
			}
		}
		
		return 0;
	}
}
