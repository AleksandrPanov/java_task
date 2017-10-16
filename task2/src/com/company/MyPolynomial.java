package com.company;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coef;

    public MyPolynomial(double coef) {

    }
    int getDegree()
    {
        return coef.length;
    }

    @Override
    public String toString() {
        return "MyPolynomial{" +
                "coef=" + Arrays.toString(coef) +
                '}';
    }

    MyPolynomial add(MyPolynomial o)
    {
        return new MyPolynomial(0.0);
    }

    MyPolynomial multiplyy(MyPolynomial o)
    {
        return new MyPolynomial(0.0);
    }
}
