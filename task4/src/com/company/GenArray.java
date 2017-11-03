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
}
