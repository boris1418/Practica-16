package com.company;

public class Sorter {

    public static void insertionSort(Comparable[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int j = i;
            while (j > 0) {
                if (arr[j].compareTo(arr[j - 1]) > 0) {
                    swap(arr, j, j - 1);
                    j--;
                } else {
                    break;
                }
            }
        }
    }

    public static void quickSort(Comparable[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    public static void mergeLists (Comparable[] result, Comparable[] arr1, Comparable[] arr2) {

        int it1 = 0;
        int it2 = 0;
        while (it1 < arr1.length && it2 < arr2.length) {
            if (arr1[it1].compareTo(arr2[it2]) > 0) {
                result[it1 + it2] = arr1[it1];
                ++it1;
            } else {
                result[it1 + it2] = arr2[it2];
                ++it2;
            }
        }

        while (it1 < arr1.length) {
            result[it1 + it2] = arr1[it1];
            ++it1;
        }

        while (it2 < arr2.length) {
            result[it1 + it2] = arr2[it2];
            ++it2;
        }

    }

    private static void swap (Comparable[] arr, int i, int j) {
        Comparable t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    private static void qsort (Comparable[] arr, int l, int r) {
        if (l < r) {
            int position = partition(arr, l, r);
            qsort(arr, l, position);
            qsort(arr, position + 1, r);
        }
    }

    private static int partition (Comparable[] arr, int l, int r) {
        Comparable pivot = arr[(l + r) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (arr[i].compareTo(pivot) > 0) {
                ++i;
            }
            while (arr[j].compareTo(pivot) < 0) {
                --j;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            ++i;
            --j;
        }
        return j;
    }

}
