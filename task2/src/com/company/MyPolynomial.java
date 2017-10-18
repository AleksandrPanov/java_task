package com.company;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coef;

    public MyPolynomial(double ... coef) {
        this.coef = coef.clone();
    }
    int getDegree()
    {
        return coef.length - 1;
    }
    @Override
    public String toString() {
        String s = String.valueOf(coef[0]);
        String delimiter;
        for (int i = 1; i < coef.length; i++)
        {
            if (coef[i-1] >= 0) delimiter = "+";
            else delimiter = "";
            s = String.join(delimiter,String.valueOf(coef[i]) + "x^" + String.valueOf(i), s);
        }
        return s;
    }

    MyPolynomial add(MyPolynomial o)
    {
        MyPolynomial arMax = new MyPolynomial();
        if (this.coef.length >= o.coef.length)
        {
            arMax.coef = new double[this.coef.length];
            for (int i = 0; i < o.coef.length; i++)
                arMax.coef[i] = coef[i] + o.coef[i];
            for(int i = o.coef.length; i < arMax.coef.length; i++)
                arMax.coef[i] = coef[i];
        }
        else
        {
            arMax.coef = new double[o.coef.length];
            for (int i = 0; i < this.coef.length; i++)
                arMax.coef[i] = coef[i] + o.coef[i];
            for(int i = this.coef.length; i < arMax.coef.length; i++)
                arMax.coef[i] = o.coef[i];
        }
        return arMax;
    }
    MyPolynomial multiply(MyPolynomial o) //not effective - O(n^2), but very easy
    {
        MyPolynomial pol = new MyPolynomial();
        for (int i = 0; i < o.coef.length; i++)
            pol = pol.add(multiply(o.coef[i], i));
        return pol;
    }
    MyPolynomial multiply(double coef, int pow)
    {
        MyPolynomial pol = new MyPolynomial();
        pol.coef = new double[this.coef.length + pow];
        for (int i = pow; i < pol.coef.length; i++)
            pol.coef[i] = this.coef[i - pow] * coef;
        return pol;
    }

    double evaluate(double x)
    {
        double res = 0;
        double xi = 1;
        for (int i = 0; i < coef.length; i++)
        {
            res += coef[i]*xi;
            xi *= x;
        }
        return res;
    }
}
