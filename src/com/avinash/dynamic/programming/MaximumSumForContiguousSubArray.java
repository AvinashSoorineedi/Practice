package com.avinash.dynamic.programming;

public class MaximumSumForContiguousSubArray {

	public static void main(String[] args) {

		int[] arr = { 81, 1, 2,-10, 3, 4, -5, 6, -6,-8, 70};
		//int[] arr = {};
		System.out.println(printMaximumSumForContiguousSubArray(arr));

	}

	private static int printMaximumSumForContiguousSubArray(int[] arr) {
		
		int result = 0;
		int start=0;int end = 0;
		
		if(arr==null || arr.length<1) {
			result = 0;
		}else {
			if(arr.length==1) {
				result = arr[0];
			}
			int sum = arr[0];
			int maxSum = arr[0];
			for(int i=1;i<arr.length;i++) {
				sum = sum+arr[i];
				if(sum>maxSum) {
					maxSum = sum;
					end = i;
				}else if(sum<0){
					sum = 0;
					start=i+1;
					
				}
			}
			result = maxSum;
		}
		
		System.out.println("Sub Array is");
		for(int k=start;k<=end;k++) {
			System.out.print(arr[k]+" ");
		}
		System.out.println("");
		return result;
	}

}
