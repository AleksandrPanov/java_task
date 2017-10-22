package com.company;

public class Factorial implements Functor{
    public static long recursionF(int n)
    {
        if (n < 2) return 1;
        return n*recursionF(n-1);
    }
    public static long circleF(int n)
    {
        long ans = 1;
        for (int i = 2; i <= n; i++)
            ans *= i;
        return ans;
    }

    @Override
    public void calculate(Object o, int numMethod) {
        if (numMethod == 0)
            recursionF((int)o);
        else if (numMethod == 1)
            circleF((int)o);

    }
}
