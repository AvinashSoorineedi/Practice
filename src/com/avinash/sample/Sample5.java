package com.avinash.sample;

import java.util.ArrayList;
import java.util.List;

public class Sample5 {

    public static void main(String[] args) {

        List<List<Integer>> grid = new ArrayList<>();
        //        List<Integer> list1 = new ArrayList<>();
        //        list1.add(1);
        //        list1.add(0);
        //        list1.add(0);
        //        list1.add(0);
        //        list1.add(0);
        //        list1.add(0);
        //        list1.add(0);
        //        List<Integer> list2 = new ArrayList<>();
        //        list2.add(0);
        //        list2.add(1);
        //        list2.add(0);
        //        list2.add(0);
        //        list2.add(0);
        //        list2.add(0);
        //        list2.add(0);
        //        List<Integer> list3 = new ArrayList<>();
        //        list3.add(0);
        //        list3.add(0);
        //        list3.add(1);
        //        list3.add(0);
        //        list3.add(0);
        //        list3.add(0);
        //        list3.add(0);
        //        List<Integer> list4 = new ArrayList<>();
        //        list4.add(0);
        //        list4.add(0);
        //        list4.add(0);
        //        list4.add(1);
        //        list4.add(0);
        //        list4.add(0);
        //        list4.add(0);
        //        List<Integer> list5 = new ArrayList<>();
        //        list5.add(0);
        //        list5.add(0);
        //        list5.add(0);
        //        list5.add(0);
        //        list5.add(1);
        //        list5.add(0);
        //        list5.add(0);
        //        List<Integer> list6 = new ArrayList<>();
        //        list6.add(0);
        //        list6.add(0);
        //        list6.add(0);
        //        list6.add(0);
        //        list6.add(0);
        //        list6.add(1);
        //        list6.add(0);
        //        List<Integer> list7 = new ArrayList<>();
        //        list7.add(0);
        //        list7.add(0);
        //        list7.add(0);
        //        list7.add(0);
        //        list7.add(0);
        //        list7.add(0);
        //        list7.add(1);
        //        grid.add(list1);
        //        grid.add(list2);
        //        grid.add(list3);
        //        grid.add(list4);
        //        grid.add(list5);
        //        grid.add(list6);
        //        grid.add(list7);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(0);
        list1.add(0);
        list1.add(0);
        list1.add(0);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(1);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(0);
        list3.add(1);
        list3.add(0);
        list3.add(0);
        List<Integer> list4 = new ArrayList<>();
        list4.add(0);
        list4.add(0);
        list4.add(0);
        list4.add(1);
        list4.add(0);
        List<Integer> list5 = new ArrayList<>();
        list5.add(0);
        list5.add(0);
        list5.add(0);
        list5.add(0);
        list5.add(1);
        grid.add(list1);
        grid.add(list2);
        grid.add(list3);
        grid.add(list4);
        grid.add(list5);
        System.out.println(minimumHours(5, 5, grid));

    }

    public static int minimumHours(int rows, int columns, List<List<Integer>> grid) {
        int result = 1;
        int totalCount = rows * columns;
        int totalOnes = findTotolOnes(rows, columns, grid);
        while (totalOnes < totalCount) {
            result++;
            List<List<Integer>> grid2 = new ArrayList<>(grid);
            updatesOnes(rows, columns, grid, grid2);

            totalOnes = findTotolOnes(rows, columns, grid2);
            grid =  grid2;
        }

        return result;
    }

    private static void updatesOnes(int rows, int columns, List<List<Integer>> grid, List<List<Integer>> grid2 ) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    if (j - 1 >= 0) {
                        grid2.get(i).set(j - 1, 1);
                    }
                    if (j + 1 < columns) {
                        grid2.get(i).set(j + 1, 1);

                    }
                    if (i - 1 >= 0) {
                        grid2.get(i - 1).set(j, 1);

                    }
                    if (i + 1 < rows) {
                        grid2.get(i + 1).set(j, 1);
                    }

                }
            }
        }

    }

    private static int findTotolOnes(int rows, int columns, List<List<Integer>> grid) {

        int oneCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    ++oneCount;
                }
            }
        }
        return oneCount;
    }
}
