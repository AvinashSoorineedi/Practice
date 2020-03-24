package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NextPermutation {

	public static void main(String[] args) {

		ArrayList<Integer> input = new ArrayList<>();
		input.add(769);
		input.add(533);
//		input.add(50);
//		input.add(20);

		nextPermutation(input);
	}

	public static void nextPermutation(ArrayList<Integer> a) {
		if (a.size() == 2) {
			if (a.get(1) > a.get(0)) {
				swap(a, 1, 0);
			} else {
				a = (ArrayList<Integer>) a.parallelStream().sorted().collect(Collectors.toList());
			}
		} else if (a.size() > 2) {
			if (a.get(a.size() - 1) > a.get(a.size() - 2)) {
				swap(a, a.size() - 1, a.size() - 2);
			} else {
				int spikeIndex = 0;
				boolean spikeFound = false;
				for (int i = a.size() - 1; i >= 1; i--) {
					if (a.get(i) > a.get(i - 1)) {
						int minIndex = i - 1;
						int maxIndex = i;
						for (int k = i + 1; k < a.size(); k++) {
							if (a.get(k) > a.get(minIndex) && a.get(k) < a.get(maxIndex)) {
								maxIndex = k;
							}
						}
						swap(a, minIndex, maxIndex);
						spikeIndex = i;
						spikeFound = true;
						break;
					}
				}

				if (spikeFound) {
					sortArrayFromParticularIndex(a, spikeIndex);
				} else {
					a = (ArrayList<Integer>) a.parallelStream().sorted().collect(Collectors.toList());
				}
			}
		}
	}

	private static void sortArrayFromParticularIndex(ArrayList<Integer> a, int spikeIndex) {

		ArrayList<Integer> tempList = new ArrayList<>();
		for (int i = spikeIndex; i < a.size(); i++) {
			tempList.add(a.get(i));
		}

		tempList = (ArrayList<Integer>) tempList.parallelStream().sorted().collect(Collectors.toList());

		for (int i = spikeIndex, j = 0; i < a.size(); i++, j++) {
			a.set(i, tempList.get(j));
		}
	}

	public static void swap(ArrayList<Integer> a, int x, int y) {
		int temp = a.get(x);
		a.set(x, a.get(y));
		a.set(y, temp);
	}
}
