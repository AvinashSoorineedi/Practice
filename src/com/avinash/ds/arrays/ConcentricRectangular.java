package com.avinash.ds.arrays;

import java.util.ArrayList;

public class ConcentricRectangular {

	public static void main(String[] args) {
		
		concentricRectangular(4);

	}

	private static ArrayList<ArrayList<Integer>> concentricRectangular(int A) {
		
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		
		int totalSize = A + (A-1);
		
		int[][] arr = new int[totalSize][totalSize];
		
		int startRow=0,endRow=totalSize-1,startColumn=0,endColumn=totalSize-1;
		int value=A;
		
		while(startRow<endRow) {
			
			for(int x=startColumn;x<endColumn+1;x++) {
				arr[startRow][x] = value;
			}
			++startRow;
			
			for(int x=startRow;x<endRow+1;x++) {
				arr[x][endColumn] = value;
			}
			--endColumn;
			
			for(int x=endColumn;x>=startColumn;x--) {
				arr[endRow][x] = value;
			}
			--endRow;
			
			for(int x=endRow;x>=startRow;x--) {
				arr[x][startColumn] = value;
			}
			++startColumn;
			
			--value;
		}
		
		arr[totalSize/2][totalSize/2] = 1;
		
		for(int a=0;a< totalSize;a++) {
			ArrayList<Integer> lst= new ArrayList<Integer>();
			for(int b=0;b<totalSize;b++) {
				lst.add(arr[a][b]);
			}
			output.add(lst);
		}
		return output;
	}

}
