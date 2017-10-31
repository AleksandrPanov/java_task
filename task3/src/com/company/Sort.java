package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort implements Functor {
    @Override
    public void calculate(Object o, int numMethod) {
        int ar[] = (int [])o;
        if (numMethod == 0)
            BubbleSort(ar);
        else if (numMethod == 1)
            SelectionSort(ar);
        else if (numMethod == 2)
            StandartSort(ar);
    }

    static int min(int a, int b)
    {
        return (a < b ? a : b);
    }
    static int max(int a, int b)
    {
        return (a > b ? a : b);
    }
    private static void swap(int ar[], int ind1, int ind2)
    {
        int tmp = ar[ind1];
        ar[ind1] = ar[ind2];
        ar[ind2] = tmp;
    }
    public static void BubbleSort(int ar[])
    {
        int n = ar.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++ )
                if (ar[j] > ar[j + 1])
                    swap(ar, j, j+1);

    }
    public static void SelectionSort(int ar[])
    {
        int n = ar.length;
        int tmp, ind;
        for (int i = 0; i < n; i++) {
            {
                ind = i;
                tmp = ar[i];
                for (int j = i + 1; j < n; j++) {
                    if (ar[j] < tmp) {
                        tmp = ar[j];
                        ind = j;
                    }
                }
            }
            swap(ar, i, ind);
        }
    }
    public static void StandartSort(int ar[]) {
        Arrays.sort(ar);
    }
}
