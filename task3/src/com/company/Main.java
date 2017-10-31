package com.company;
import java.util.Arrays;
import java.util.Scanner;

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

    public static void task3()
    {
       Picture.f1();
       Picture.fa();
       Picture.fb();
       Picture.fc();
       Picture.fd();
       Picture.fe();
       Picture.fh();
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
        String s = " - this number occurs most often";
        if (rep[0] >= rep[1] && rep[0] >= rep[2])
            System.out.println(-1 + s);
        else if (rep[1] >= rep[2] && rep[1] >= rep[0])
            System.out.println(0 + s);
        else if (rep[2] >= rep[1] && rep[2] >= rep[0])
            System.out.println(1 + s);


    }
    public static void task5()
    {
        int row = 8, col = 8;
        //a
        System.out.println("task 5.a");
        int ar[][] = GenArray.getRandAr(row,col, 1, 99);
        long multM = 1, sumM = 0, multC = 1, sumC = 0;
        for (int i = 0; i < row; i++)
        {
            sumM += ar[i][i];
            multM *= ar[i][i];
        }
        for (int i = 0; i< row; i++)
        {
            sumC  += ar[i][row - i - 1];
            multC *= ar[i][row - i - 1];
        }
        System.out.println("sum of elements main diagonal " + sumM + " product of the elements main diagonal " + multM);
        System.out.println("sum of elements secondary diagonal " + sumC + " product of the elements secondary diagonal " + multC);
        System.out.println();
        //b
        System.out.println("task 5.b");
        row = 8; col = 5;
        ar = GenArray.getRandAr(row, col, -99, 99);
        int max = -1000;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(ar[i][j]+ " ");
                max = Sort.max(ar[i][j], max);
            }
            System.out.println();
        }
        System.out.println("max value = "+max);
        System.out.println("indices of max");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (ar[i][j] == max)
                    System.out.print("("+i+","+j+")");
        System.out.println();
        System.out.println();
        //c
        System.out.println("task 5.c");
        ar = GenArray.getRandAr(row, col, -10, 10);

        int ind = 0;
        for (int i = 0; i < row; i++)
        {
            int tmp = 1;
            for (int j = 0; j < col; j++)
            {
                System.out.print(ar[i][j] + " ");
                tmp *= ar[i][j];
            }
            tmp = Math.abs(tmp);
            if (i == 0)
                max = tmp;
            else
                {
                    if (max < tmp)
                    {
                        max = tmp;
                        ind = i;
                    }
            }
            System.out.println();
        }
        System.out.println("max product in row " + ind + " and = "+max);
        System.out.println();
        //d
        System.out.println("task 5.d");
        row = 10;
        col = 7;
        ar = GenArray.getRandAr(row, col, 0, 100);
        for (int i = 0; i < row; i++)
            printAr(ar[i]);
        System.out.println("sorted:");
        for (int i = 0; i < row; i++)
        {
            Sort.SelectionSort(ar[i]);
            printAr(ar[i]);
        }
    }
    enum Test  {
        q, w, e, r, t, y, u, i, o, p, a, s, d, f;
    };
    static Test test1(Test t)
    {
     if (t == Test.q) return t;
     else if (t == Test.w) return t;
     else if (t == Test.e) return t;
     else if (t == Test.r) return t;
     else if (t == Test.t) return t;
     else if (t == Test.y) return t;
     else if (t == Test.u) return t;
     else if (t == Test.i) return t;
     else if (t == Test.o) return t;
     else if (t == Test.p) return t;
     else if (t == Test.a) return t;
     else if (t == Test.s) return t;
     else if (t == Test.d) return t;
     else if (t == Test.f) return t;
     else return t;
    }
    static Test test2(Test t)
    {
        switch (t) {
            case q:
                return t;
            case w:
                return t;
            case e:
                return t;
            case r:
                return t;
            case t:
                return t;
            case y:
                return t;
            case u:
                return t;
            case i:
                return t;
            case o:
                return t;
            case p:
                return t;
            case a:
                return t;
            case s:
                return t;
            case d:
                return t;
            default:
                return t;
        }
    }
    public static void task6()
    {
        String s = "";
        Scanner in = new Scanner(System.in);
        s = in.next();
        Test t = Test.valueOf(s);

        long startTime = System.nanoTime();
        test1(t);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("if-else-f "+estimatedTime);

        startTime = System.nanoTime();
        test1(t);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("switch-case "+estimatedTime);
    }
    public static void main(String[] args) {
        //task1();
        //task2();
        task3();
        //task4();
        //task5();
        //task6();
    }
}
