package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {

		ArrayList<Interval> intervals = new ArrayList<>();

//		intervals.add(new Interval(1, 10));
//		intervals.add(new Interval(2, 9));
//		intervals.add(new Interval(3, 8));
//		intervals.add(new Interval(4, 7));
//		intervals.add(new Interval(5, 6));
//		intervals.add(new Interval(6, 6));
		
		intervals.add(new Interval(1, 41));
		intervals.add(new Interval(1, 100));

//		intervals.add(new Interval(8, 10));
//		intervals.add(new Interval(15, 18));

		System.out.println(merge(intervals));

	}

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		ArrayList<Interval> result = new ArrayList<>();
		Stack<Interval> stack = new Stack();
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		stack.add(intervals.get(0));
		
		for (int i = 1; i < intervals.size(); i++) {
			
			Interval temp = stack.pop();
			if (isIntervalsMerge(temp, intervals.get(i))) {
				stack.add(new Interval(Math.min(intervals.get(i).start, temp.start),
						Math.max(intervals.get(i).end, temp.end)));
			} else {
				stack.add(temp);
				stack.add(intervals.get(i));
			}
		}

		for(Interval i:stack) {
			result.add(i);
		}
		
		return result;
	}

	private static boolean isIntervalsMerge(Interval interval1, Interval interval2) {
		return ((interval2.start >= interval1.start && interval2.start <= interval1.end)
				|| (interval2.end >= interval1.start && interval2.end <= interval1.end));
	}

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "[" + this.start + "," + this.end + "]";
		}
	}

}
