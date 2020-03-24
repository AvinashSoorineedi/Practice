package com.avinash.ds.arrays;

import java.util.ArrayList;

public class MergeIntervals {

	public static void main(String[] args) {

		Interval interval1 = new Interval(1, 2);
		Interval interval2 = new Interval(8, 9);
//		Interval interval3 = new Interval(7, 8);
//		Interval interval4 = new Interval(10, 11);
//		Interval interval1 = new Interval(6037774, 6198243);
//		Interval interval2 = new Interval(6726550, 7004541);
//		Interval interval3 = new Interval(8842554, 10866536);
//		Interval interval4 = new Interval(11027721, 11341296);
//		Interval interval5 = new Interval(11972532, 14746848);
//		Interval interval6 = new Interval(16374805, 16706396);
//		Interval interval7 = new Interval(17557262, 20518214);
//		Interval interval8 = new Interval(22139780, 22379559);
//		Interval interval9 = new Interval(27212352, 28404611);
//		Interval interval10 = new Interval(28921768, 29621583);
//		Interval interval11 = new Interval(29823256, 32060921);
//		Interval interval12 = new Interval(33950165, 36418956);
//		Interval interval13 = new Interval(37225039, 37785557);
//		Interval interval14 = new Interval(40087908, 41184444);
//		Interval interval15 = new Interval(41922814, 45297414);
//		Interval interval16 = new Interval(48142402, 48244133);
//		Interval interval17 = new Interval(48622983, 50443163);
//		Interval interval18 = new Interval(50898369, 55612831);
//		Interval interval19 = new Interval(57030757, 58120901);
//		Interval interval20 = new Interval(59772759, 59943999);
//		Interval interval21 = new Interval(61141939, 64859907);
//		Interval interval22 = new Interval(65277782, 65296274);
//		Interval interval23 = new Interval(67497842, 68386607);
//		Interval interval24 = new Interval(70414085, 73339545);
//		Interval interval25 = new Interval(73896106, 75605861);
//		Interval interval26 = new Interval(79672668, 84539434);
//		Interval interval27 = new Interval(84821550, 86558001);
//		Interval interval28 = new Interval(91116470, 92198054);
//		Interval interval29 = new Interval(96147808, 98979097);
//		
		Interval interval = new Interval(3, 4);

		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(interval1);
		intervals.add(interval2);
//		intervals.add(interval3);
//		intervals.add(interval4);
//		intervals.add(interval5);
//		intervals.add(interval6);
//		intervals.add(interval7);
//		intervals.add(interval8);
//		intervals.add(interval9);
//		intervals.add(interval10);
//		intervals.add(interval11);
//		intervals.add(interval12);
//		intervals.add(interval13);
//		intervals.add(interval14);
//		intervals.add(interval15);
//		intervals.add(interval16);
//		intervals.add(interval17);
//		intervals.add(interval18);
//		intervals.add(interval19);
//		intervals.add(interval20);
//		intervals.add(interval21);
//		intervals.add(interval22);
//		intervals.add(interval23);
//		intervals.add(interval24);
//		intervals.add(interval25);
//		intervals.add(interval26);
//		intervals.add(interval27);
//		intervals.add(interval28);
//		intervals.add(interval29);

		System.out.println(insert(intervals, interval));
	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		ArrayList<Interval> result = new ArrayList<>();
		if (intervals.isEmpty()) {
			result.add(newInterval);
			return result;
		}
		for (int i = 0; i < intervals.size()-1; i++) {
			if (intervals.get(i + 1) != null && intervals.get(i).end < newInterval.start
					&& intervals.get(i + 1).start > newInterval.end) {
				intervals.add(i+1, newInterval);
				return intervals;
			}
		}
		if (intervals.get(0).start > newInterval.end) {
			intervals.add(0, newInterval);
			return intervals;
		}
		if (intervals.get(intervals.size() - 1).end < newInterval.start) {
			intervals.add(newInterval);
			return intervals;
		} else {
			Interval temp = newInterval;
			boolean isMerged = false;
			for (int i = 0; i < intervals.size(); i++) {
				if ((intervals.get(i).start > temp.start && intervals.get(i).start < temp.end)
						|| (intervals.get(i).end > temp.start && intervals.get(i).end < temp.end)) {
					temp.start = Math.min(intervals.get(i).start, temp.start);
					temp.end = Math.max(intervals.get(i).end, temp.end);
					isMerged = true;
				} else {
					if (isMerged) {
						result.add(new Interval(temp.start, temp.end));
						isMerged = false;
					}
					result.add(intervals.get(i));
				}
			}
			if (isMerged) {
				result.add(new Interval(temp.start, temp.end));
			}

		}
		return result;
	}

	private static boolean isIntervalMerging(Interval actual, Interval temp) {
		return ((actual.start > temp.start && actual.start < temp.end)
				|| (actual.end > temp.start && actual.end < temp.end));
	}

}

class Interval {
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
