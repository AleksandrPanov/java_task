package com.company;

public class TimeMeter {
    public static void printResults(TestFunction f)
    {
        System.out.println("testing of "+f.getName()+":");
        System.out.print("function work ");
        long startTime = System.nanoTime();
        f.runTestingFunction();
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime/1000 + " microseconds");
    }
}
