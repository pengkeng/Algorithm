package com.ucas.dji;

import java.util.ArrayList;

public class Dijkstra {


    public static int MAX = 100000;


    public static void main(String args[]) {

        int[][] weight = {
                {0, 4, MAX, 2, MAX},
                {4, 0, 4, 1, MAX},
                {MAX, 4, 0, 1, 3},
                {2, 1, 1, 0, 7},
                {MAX, MAX, 3, 7, 0}
        };
        djikstra(weight, 0);

    }

    private static void djikstra(int[][] weight, int start) {
        ArrayList<Edge> S = new ArrayList<>();
        S.add(new Edge(start, start, weight[start][start]));
        ArrayList<Edge> U = new ArrayList<>();
        for (int i = 0; i < weight.length; i++) {
            if (i != start) {
                U.add(new Edge(start, i, weight[start][i]));
            }
        }
        while (S.size() < weight.length) {
            Edge min = new Edge(MAX, MAX, MAX);
            for (Edge edge : U) {
                if (edge.value < min.value) {
                    min.start = edge.start;
                    min.end = edge.end;
                    min.value = edge.value;
                }
            }
            S.add(min);
            int i;
            for (i = 0; i < U.size(); i++) {
                if (U.get(i).end == min.end) {
                    break;
                }
            }
            U.remove(i);
            for (Edge edge : U) {
                edge.value = Math.min(edge.value, min.value + weight[min.end][edge.end]);
            }
        }
        for (Edge edge : S) {
            System.out.println(edge.start + ":" + edge.end + ":" + edge.value);
        }
    }
}
