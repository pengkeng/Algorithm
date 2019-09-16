package com.ucas.sort;

public class Insert {

    /**
     * 插入排序
     *
     * @param a 待排序数组
     * @param n 数组长度
     * @return 排序后的数组
     */
    public static int[] InsertSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int t = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (t < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    a[j + 1] = t;
                    break;
                }
            }
        }
        return a;
    }
}
