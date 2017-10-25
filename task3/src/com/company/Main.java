package com.company;
import java.util.Arrays;

public class Main {
    public static void printAr(int ar[]) {
        for (int i = 0; i < ar.length; i++)
            System.out.print(ar[i] + " ");
        System.out.println();
    }
    public static void printArRound(int ar[]) {
        for (int i = ar.length - 1; i>= 0; i--)
            System.out.print(ar[i] + " ");
        System.out.println();
    }

    public static void task1() {
        int ar[] = GenArray.getRandAr(10, 1, 7);
        int ar1[] = ar.clone();
        printAr(ar);
        Sort.BubbleSort(ar);
        Sort.SelectionSort(ar1);
        printAr(ar);
        printAr(ar1);

        int size = 1000;
        ar = GenArray.getRandAr(size, 1, 100);
        ar1 = ar.clone();
        int ar2[] = ar.clone();

        System.out.println("Bubble sort, size = " + size);
        TimeMeter.printTimeMicroSeconds(new Sort(), ar, 0);
        System.out.println("Selection sort, size = " + size);
        TimeMeter.printTimeMicroSeconds(new Sort(), ar1, 1);
        System.out.println("Default sort, size = " + size);
        TimeMeter.printTimeMicroSeconds(new Sort(), ar1, 2);
    }

    public static void task2() {
        Integer n = 5;
        System.out.println(n + "! = " + Factorial.circleF(n) + " by circle");
        System.out.println(n + "! = " + Factorial.recursionF(n) + " by recursion");
        n = 20;
        System.out.println("n = " + n + "  calculate n! by recursion");
        TimeMeter.printTimeMicroSeconds(new Factorial(), n, 0);
        System.out.println("n = " + n + " calculate n! by circle");
        TimeMeter.printTimeMicroSeconds(new Factorial(), n, 1);
    }

    static void f1()
    {
        int size = 5;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print('#');
            System.out.println();
        }
        System.out.println();
    }
    static void fa()
    {
        int size = 7;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print('#');
            System.out.println();
        }
        System.out.println();
    }
    static void fb()
    {
        int size = 7;
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++)
                System.out.print('#');
            System.out.println();
        }
        System.out.println();
    }
    static void fc()
    {
        int size = 7;
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++)
                System.out.print(' ');
            for (int j = i; j < size; j++)
                System.out.print('#');
            System.out.println();
        }
        System.out.println();
    }
    static void fd()
    {
        int size = 7;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++)
                System.out.print(' ');
            for (int j = size - i - 1; j < size; j++)
                System.out.print('#');
            System.out.println();
        }
        System.out.println();
    }
    static void fe()
    {
        int size = 7;
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1)
                for (int j = 0; j < size; j++)
                    System.out.print('#');
            else
                for (int j = 0; j < size; j++)
                    if (j == 0 || j == size - 1)
                        System.out.print('#');
                    else System.out.print(' ');

            System.out.println();
        }
        System.out.println();
    }
    static void fh()
    {
        int size = 7;
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1)
                for (int j = 0; j < size; j++)
                    System.out.print('#');
            else
                for (int j = 0; j < size; j++)
                    if (j == i || j == size - i - 1)
                        System.out.print('#');
                    else System.out.print(' ');

            System.out.println();
        }
        System.out.println();
    }
    public static void task3()
    {
       f1();
       fa();
       fb();
       fc();
       fd();
       fe();
       fh();
    }
    public static void task4()
    {
        int ar[] = GenArray.getRandOddAr(100, 1, 99);
        System.out.println("a");
        Sort.StandartSort(ar);
        printAr(ar);
        printArRound(ar);

        System.out.println("b");
        ar = GenArray.getRandAr(20, 1, 10);
        printAr(ar);
        int odd = 0, even = 0;
        for (int i = 1 ; i < 20; i++)
        {
            if (ar[i] % 2 == 1)
                odd++;
            else even++;
        }
        System.out.println("odd = "+odd + ", even = " + even);


        System.out.println("c");
        ar = GenArray.getRandAr(10, 1, 10);
        printAr(ar);
        for (int i = 1 ; i < 10; i+=2)
            ar[i] = 0;
        printAr(ar);

        System.out.println("d");
        ar = GenArray.getRandAr(15, -50, 50);
        printAr(ar);
        Sort.StandartSort(ar);
        System.out.println("min = "+ ar[0] + ", max = " + ar[14]);

        System.out.println("e");
        ar = GenArray.getRandAr(10, 0, 10);
        int ar1[] = GenArray.getRandAr(10, 0, 10);
        double average1 = 0, average2 = 0;
        for (int i = 0; i < 10; i++)
        {
            average1 += ar[i];
            average2 += ar1[i];
        }
        average1 /= 10;
        average2 /= 10;
        System.out.println("average of ar1 = "+average1 + "average of ar2 = " + average2);
        //find average

        System.out.println("f");
        ar = GenArray.getRandAr(20, -1, 1);
        printAr(ar);
        int rep[] = {0, 0, 0};
        for (int i = 0; i < 20;i++)
            rep[ar[i]+1]++;
        for (int i = 0; i < 3; i++)
         System.out.println("num of " +(i-1) +" = " + rep[i]);

    }
    public static void task5()
    {

    }
    public static void task6()
    {

    }
    public static void main(String[] args) {
       // task1();
       // task2();
       // task3();
       // task4();
    }
}
