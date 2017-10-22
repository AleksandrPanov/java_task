package com.company;

public class TimeMeter {
    public static void printTimeMicroSeconds(Functor f, Object o, int numMethod)
    {
        long startTime = System.nanoTime();
        f.calculate(o, numMethod);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime/1000 + " mcs");
    }
}
