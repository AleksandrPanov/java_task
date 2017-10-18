package com.company;

public class Main {

    public static void main(String[] args) {
        MyPolynomial pol1 = new MyPolynomial(1,2,3); // 1 + 2x + 3x^2
        MyPolynomial pol2 = new MyPolynomial(1,-2,3,4); // 1 -2x + 3x^2 + 4x^3
        MyPolynomial pol3 = new MyPolynomial(2,3);
        MyPolynomial pol4 = new MyPolynomial(-2,3);
        System.out.println(pol1);
        System.out.println(pol1.add(pol2));
        System.out.println(pol2.add(pol1));
        System.out.println(pol4.multiply(pol3));
        System.out.println(pol3.multiply(pol1));
    }
}
