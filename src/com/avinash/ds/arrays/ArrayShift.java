package com.avinash.ds.arrays;

import java.util.ArrayList;

public class ArrayShift {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
//		arr.add(5);
//		arr.add(14);
//		arr.add(34);
//		arr.add(42);
//		arr.add(63);
//		arr.add(17);arr.add(25);arr.add(39);arr.add(61);arr.add(97);arr.add(55);arr.add(33);arr.add(96);
//		arr.add(62);arr.add(32);arr.add(98);arr.add(77);arr.add(35);
		arr.add(28);arr.add(68);arr.add(100);arr.add(90);arr.add(46);arr.add(58);arr.add(54);arr.add(74);
		System.out.println(rotateArray(arr, 78));
		//expected 54 74 28 68 100 90 46 58 
	}

	public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        
        int size = B % A.size();
        int pointer = size;
        for (int i = 0; i < A.size(); i++) {
            while(pointer>=A.size()){
                pointer = pointer-A.size();
            }
            ret.add(A.get(pointer));
            ++pointer;
        }
        
        return ret;
    }
}
