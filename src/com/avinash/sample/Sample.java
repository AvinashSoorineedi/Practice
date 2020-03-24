package com.avinash.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sample {

    public static void main(String[] args) throws IOException {

        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(0);
        list1.add(0);
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
        list2.add(0);
        list2.add(0);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(0);
        list3.add(1);
        list3.add(0);
        list3.add(0);
        list3.add(0);
        list3.add(0);
        List<Integer> list4 = new ArrayList<>();
        list4.add(0);
        list4.add(0);
        list4.add(0);
        list4.add(1);
        list4.add(0);
        list4.add(0);
        list4.add(0);
        List<Integer> list5 = new ArrayList<>();
        list5.add(0);
        list5.add(0);
        list5.add(0);
        list5.add(0);
        list5.add(1);
        list5.add(0);
        list5.add(0);
        List<Integer> list6 = new ArrayList<>();
        list6.add(0);
        list6.add(0);
        list6.add(0);
        list6.add(0);
        list6.add(0);
        list6.add(1);
        list6.add(0);
        List<Integer> list7 = new ArrayList<>();
        list7.add(0);
        list7.add(0);
        list7.add(0);
        list7.add(0);
        list7.add(0);
        list7.add(0);
        list7.add(1);
        grid.add(list1);
        grid.add(list2);
        grid.add(list3);
        grid.add(list4);
        grid.add(list5);
        grid.add(list6);
        grid.add(list7);

        //        List<Integer> list1 = new ArrayList<>();
        //      list1.add(1);
        //      list1.add(1);
        //      list1.add(0);
        //      list1.add(0);
        //      List<Integer> list2 = new ArrayList<>();
        //      list2.add(0);
        //      list2.add(0);
        //      list2.add(0);
        //      list2.add(0);
        //      List<Integer> list3 = new ArrayList<>();
        //      list3.add(0);
        //      list3.add(0);
        //      list3.add(1);
        //      list3.add(1);
        //      List<Integer> list4 = new ArrayList<>();
        //      list4.add(0);
        //      list4.add(0);
        //      list4.add(0);
        //      list4.add(0);
        //      grid.add(list1);
        //    grid.add(list2);
        //    grid.add(list3);
        //    grid.add(list4);
        System.out.println(numberAmazonGoStores(7, 7, grid));

    }

    public static int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid) {
        int result = 0;

        Map<String, Set<String>> verticeVsEdge = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                int left = 0;
                if (j - 1 > 0) {
                    left = grid.get(i).get(j - 1);
                }
                int right = 0;
                if (j + 1 < column) {
                    right = grid.get(i).get(j + 1);
                }
                int top = 0;
                if (i - 1 > 0) {
                    top = grid.get(i - 1).get(j);
                }
                int down = 0;
                if (i + 1 < rows) {
                    down = grid.get(i + 1).get(j);
                }
                if (grid.get(i).get(j) == 1) {
                    if (left == 1) {
                        addVertice(String.valueOf(i) + String.valueOf(j), String.valueOf(i) + String.valueOf(j - 1),
                            verticeVsEdge);
                    }
                    if (right == 1) {
                        addVertice(String.valueOf(i) + String.valueOf(j), String.valueOf(i) + String.valueOf(j + 1),
                            verticeVsEdge);
                    }
                    if (top == 1) {
                        addVertice(String.valueOf(i) + String.valueOf(j), String.valueOf(i - 1) + String.valueOf(j),
                            verticeVsEdge);
                    }
                    if (down == 1) {
                        addVertice(String.valueOf(i) + String.valueOf(j), String.valueOf(i + 1) + String.valueOf(j),
                            verticeVsEdge);
                    }
                    if (left == 0 && down == 0 && right == 0 && top == 0) {
                        addVertice(String.valueOf(i) + String.valueOf(j), null, verticeVsEdge);
                    }
                }

            }
        }

        Set<String> visited = new HashSet<>();

        for (Map.Entry<String, Set<String>> vVsE : verticeVsEdge.entrySet()) {
            if (!visited.contains(vVsE.getKey())) {
                result++;
                visited.add(vVsE.getKey());
            }
            doBFS(vVsE.getValue(), visited, verticeVsEdge);
        }

        return result;
    }

    private static void doBFS(Set<String> edges, Set<String> visited, Map<String, Set<String>> verticeVsEdge) {

        for (String edge : edges) {
            if (!visited.contains(edge)) {
                visited.add(edge);
                if (verticeVsEdge.get(edge) != null) {
                    doBFS(verticeVsEdge.get(edge), visited, verticeVsEdge);
                }
            }
        }

    }

    private static void addVertice(String source, String destination, Map<String, Set<String>> verticeVsEdge) {
        if (!verticeVsEdge.containsKey(source)) {
            verticeVsEdge.put(source, new HashSet<>());
        }
        if (destination != null) {
            verticeVsEdge.get(source).add(destination);
        }
    }

}
