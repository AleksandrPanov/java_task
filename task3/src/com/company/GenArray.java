package com.company;
import java.sql.Time;
import java.util.Random;

public class GenArray {
    public  static int[] getRandAr(int size, int min, int max)
    {
        Random random = new Random();
        int ar[] = new int[size];
        for (int i = 0; i < size; i++)
        {
            ar[i] = random.nextInt(max - min + 1) + min;
        }
        return ar;
    }
    public  static int[] getRandOddAr(int size, int minOdd, int maxOdd)
    {
        Random random = new Random();
        int ar[] = new int[size];
        for (int i = 0; i < size; i++)
        {
            ar[i] = (random.nextInt(maxOdd/2 - minOdd/2 + 1) + minOdd/2)*2 + 1;
        }
        return ar;
    }
}
