package com.ucas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    private static int counter = 0;

    public static void main(String[] args) {

//        Point A = new Point("A");
//        Point B = new Point("B");
//        Point C = new Point("C");
//        Point D = new Point("D");
//        Point E = new Point("E");
//        Point F = new Point("F");
//        Point G = new Point("G");
//        Point H = new Point("H");
//        Point I = new Point("I");
//        Point J = new Point("J");
//        Point K = new Point("K");
//        Point L = new Point("L");
//        Point M = new Point("M");
//
//        A.setChildren(new ArrayList<>(Arrays.asList(L, F, C, B)));
//        B.setChildren(new ArrayList<>(Arrays.asList(A, C, G, H, M, E, D)));
//        C.setChildren(new ArrayList<>(Arrays.asList(A, B)));
//        D.setChildren(new ArrayList<>(Arrays.asList(B, E)));
//        E.setChildren(new ArrayList<>(Arrays.asList(B, D)));
//        F.setChildren(new ArrayList<>(Collections.singletonList(A)));
//        G.setChildren(new ArrayList<>(Arrays.asList(I, K, H, B)));
//        H.setChildren(new ArrayList<>(Arrays.asList(G, K, B)));
//        I.setChildren(new ArrayList<>(Collections.singletonList(G)));
//        J.setChildren(new ArrayList<>(Arrays.asList(L, M)));
//        K.setChildren(new ArrayList<>(Arrays.asList(G, H)));
//        L.setChildren(new ArrayList<>(Arrays.asList(A, M)));
//        M.setChildren(new ArrayList<>(Arrays.asList(J, L, B)));

        Point A = new Point("A");
        Point B = new Point("B");
        Point C = new Point("C");
        Point D = new Point("D");
        Point E = new Point("E");
        Point F = new Point("F");
        Point G = new Point("G");
        A.setChildren(new ArrayList<>(Arrays.asList(B, C, D)));
        B.setChildren(new ArrayList<>(Arrays.asList(C, A)));
        C.setChildren(new ArrayList<>(Arrays.asList(G, D)));
        D.setChildren(new ArrayList<>(Arrays.asList(A, E, F)));
        E.setChildren(new ArrayList<>(Arrays.asList(D, F)));
        F.setChildren(new ArrayList<>(Arrays.asList(D, E)));
        G.setChildren(new ArrayList<>(Collections.singletonList(C)));

        DFS(A, null);
    }

    private static void DFS(Point current, Point parent) {
        int childNum = 0;
        current.isVisited = true;
        counter++;
        current.dfn = counter;
        current.low = counter;
        for (Point child : current.getChildren()) {
            if (!child.isVisited) {
                childNum++;
                child.setParent(current);
                DFS(child, current);
                current.low = Math.min(current.low, child.low);
                if (parent == null && childNum > 1) {
                    System.out.println("节点：" + current.getName() + " 是割点");
                }
                if (parent != null && child.low > parent.dfn) {
                    System.out.println("节点：" + current.getName() + " 是割点");
                }
            } else if (child != current.getParent()) {
                current.low = Math.min(current.low, child.dfn);
            }
        }
    }
}
