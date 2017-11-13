package com.company;
import com.company.TestCollections.GenArray;
import com.company.TestCollections.*;
import com.company.TestCollections.Collections.*;

import java.util.*;

public class Main {
    public static void task2A() {
        int n = 2500000;
        int ar[] = GenArray.getRandAr(n, -1000, 1000);

        Functor<Integer> arrayList = new TestArrayList<>();
        Functor<Integer> linkedList = new TestLinkedList<>();

        TimeMeter.printTimeOfOperation(arrayList, ar, Operations.Add);
        TimeMeter.printTimeOfOperation(linkedList, ar, Operations.Add);
    }
    public static void task2B() {
        int n = 10000;
        long startTime ;
        long estimatedTime;
        int ar[] = GenArray.getRandAr(n, -1000, 1000);
        HashSet<Integer> c3 = new HashSet<>();
        LinkedHashSet<Integer> c4 = new LinkedHashSet<>();
        TreeSet<Integer> c5 = new TreeSet<Integer>();

        for (int i = 0; i < n; i++)
            c3.add(ar[i]);

        for (int i = 0; i < n; i++)
            c4.add(ar[i]);

        for (int i = 0; i < n; i++)
            c5.add(ar[i]);
    }
    public static void task2C() {
        int n = 10000;
        long startTime ;
        long estimatedTime;
        int val[] = GenArray.getRandAr(n, -1000, 1000);
        int key[] = GenArray.getRandAr(n, -1000, 1000);
        HashMap<Integer, Integer> c6 = new HashMap<Integer, Integer>();
        LinkedHashMap<Integer, Integer> c7 = new  LinkedHashMap<Integer, Integer>();
        TreeMap<Integer, Integer> c8 = new TreeMap<Integer, Integer>();

        for (int i = 0; i < n; i++)
            c6.put(val[i], key[i]);

        for (int i = 0; i < n; i++)
            c7.put(val[i], key[i]);

        for (int i = 0; i < n; i++)
            c8.put(val[i], key[i]);
    }
    public static void main(String[] args) {
	task2A();
	task2B();
	task2C();
    }
}
