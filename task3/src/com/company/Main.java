package com.company;


public class Main {
    public static void printAr(int ar[])
    {
        for (int i = 0; i < ar.length; i++)
            System.out.print(ar[i] + " ");
        System.out.println();
    }
    public static void task1()
    {
        int ar[] = GenArray.getRandAr(10,1, 7);
        int ar1[] = ar.clone();
        printAr(ar);
        Sort.BubbleSort(ar);
        Sort.SelectionSort(ar1);
        printAr(ar);
        printAr(ar1);

        ar = GenArray.getRandAr(1000,1, 100);
        ar1  = ar.clone();
        int ar2[] = ar.clone();

        TimeMeter.printTimeMicroSeconds(new Sort(), ar, 0);
        TimeMeter.printTimeMicroSeconds(new Sort(), ar1, 1);
        TimeMeter.printTimeMicroSeconds(new Sort(), ar1, 2);
    }
    public static void task2()
    {
        Integer n = 20;
        TimeMeter.printTimeMicroSeconds(new Factorial(), n, 0);
        TimeMeter.printTimeMicroSeconds(new Factorial(), n, 1);
    }
    public static void main(String[] args) {
        task1();
        task2();
    }
}
