package com.company;

public class Picture {
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
}
