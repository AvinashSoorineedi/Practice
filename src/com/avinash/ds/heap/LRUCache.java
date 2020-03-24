package com.avinash.ds.heap;

public class LRUCache {

    public static void main(String[] args) {
        Solution solution = new Solution(1);
        solution.set(2, 1);
        solution.set(2, 2);
       System.out.println(solution.get(2));
        solution.set(1, 1);
        solution.set(4,1);
        System.out.println(solution.get(2));
        
    }

   

   

}
