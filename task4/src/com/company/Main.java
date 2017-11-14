package com.company;
import com.company.MyList.*;
import com.company.TestCollections.GenArray;
import com.company.TestCollections.*;
import com.company.TestCollections.Collections.*;

import java.util.*;

public class Main {
    static Operations ListOperation[] = {Operations.Add, Operations.Search, Operations.Delete, Operations.Insert};
    public static void task1A() {
        MyLinkedList<Double> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1.0);
        myLinkedList.add(2.0);
        System.out.println(myLinkedList.myContains());
        myLinkedList.add(0, -100.0);
        myLinkedList.add(1, 100.0);
        System.out.println(myLinkedList.myContains());
        myLinkedList.set(0, 0.0);
        myLinkedList.set(3, 999.0);
        System.out.println(myLinkedList.myContains());
        myLinkedList.remove(3);
        myLinkedList.remove(0);
        System.out.println(myLinkedList.myContains());
        myLinkedList.add(2.0);
        myLinkedList.remove(100.0);
        System.out.print("iterator: ");
        for(IIterator<Double> it = myLinkedList.iterator(); it.hasNext();)
            System.out.print(it.next()+" ");
        myLinkedList.clear();
        System.out.println("\n"+myLinkedList.myContains());
    }
    public static void task1B()
    {
        int n = 50000;
        int ar[] = GenArray.getRandAr(n, -1000, 1000);
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 4; i++)
        {
            TimeMeter.printTimeOfOperation(myLinkedList, ar, ListOperation[i]);
            //System.out.println(myLinkedList.myContains());
        }

    }
    public static void task2A() {
        int n = 50000;
        int ar[] = GenArray.getRandAr(n, -1000, 1000);

        Functor<Integer> arrayList = new TestArrayList<>();
        Functor<Integer> linkedList = new TestLinkedList<>();

        for (int i = 0; i < 4; i++)
        {
            TimeMeter.printTimeOfOperation(arrayList, ar, ListOperation[i]);
            TimeMeter.printTimeOfOperation(linkedList, ar, ListOperation[i]);
        }
    }
    public static void task2B() {
        int n = 5500000;
        int ar[] = GenArray.getRandAr(n, -100000, 100000);

        Functor<Integer> hashSet = new TestHashSet<>();
        Functor<Integer> linkedHashSet = new TestLinkedHashSet<>();
        Functor<Integer> treeSet = new TestTreeSet<>();

        for (int i = 0; i < 3; i++)
        {
            TimeMeter.printTimeOfOperation(hashSet, ar, ListOperation[i]);
            TimeMeter.printTimeOfOperation(linkedHashSet, ar, ListOperation[i]);
            TimeMeter.printTimeOfOperation(treeSet, ar, ListOperation[i]);
        }
    }
    public static void task2C() {
        int n = 5500000;
        int key[] = GenArray.getRandAr(n, -100000, 100000);
        Functor<Integer> hashMap = new TestHashMap<Integer>();
        Functor<Integer> linkedHashMap = new  TestLinkedHashMap<Integer>();
        Functor<Integer> treeMap = new TestTreeMap<Integer>();
        for (int i = 0; i < 3; i++)
        {
            TimeMeter.printTimeOfOperation(hashMap, key, ListOperation[i]);
            TimeMeter.printTimeOfOperation(linkedHashMap, key, ListOperation[i]);
            TimeMeter.printTimeOfOperation(treeMap, key, ListOperation[i]);
        }
    }
    public static void main(String[] args) {
        task1A();
        task1B();
	    task2A();
	    task2B();
	    task2C();
    }
}
