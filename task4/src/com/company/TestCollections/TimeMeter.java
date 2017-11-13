package com.company.TestCollections;
public class TimeMeter {
    public static void printTimeOfOperation(Functor f, int []key, Operations operation)
    {
        long startTime = System.nanoTime();
        for (int i = 0; i < key.length; i++)
        {
            f.calculate(key[i], operation);
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(f + " " + key.length+ " " + operation + " worked " + estimatedTime/1000000 + " milliseconds");
    }
}
