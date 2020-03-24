package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class HotelBookingsPossible {

	public static void main(String[] args) {
		ArrayList<Integer> arrive = new ArrayList<>();
		arrive.add(1);
		arrive.add(3);
		arrive.add(5);
		ArrayList<Integer> depart = new ArrayList<>();
		depart.add(2);
		depart.add(6);
		depart.add(8);
		
		System.out.println(hotel(arrive,depart,1));
	}

	public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		int arriveSize = arrive.size();
		int i = 0, j = 0;
		int max=0, res=0;
		while (i < arriveSize && j < arriveSize) {
			if (arrive.get(i) < depart.get(j)) {
				res++;
				if(res>max) {
					max = res;
				}
				i++;
			} else if (arrive.get(i) > depart.get(j)) {
				res--;
				j++;
			}
		}
		
		return K>=max;
	}
}
