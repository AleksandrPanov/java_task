package com.company;

public class Main {
    public static boolean near(double a, double b, double eps)
    {
        return (Math.abs(a - b) < eps);
    }
    public static void main(String[] args) {
        System.out.println("Test MyPolynomial");
        MyPolynomial pol1 = new MyPolynomial(1,2,3); // 1 + 2x + 3x^2
        MyPolynomial pol2 = new MyPolynomial(1,-2,3,4); // 1 -2x + 3x^2 + 4x^3
        MyPolynomial pol3 = new MyPolynomial(2,3);
        MyPolynomial pol4 = new MyPolynomial(-2,3);
        System.out.println(pol1);
        System.out.println(pol1.add(pol2));
        System.out.println(pol2.add(pol1));
        System.out.println(pol4.multiply(pol3));
        System.out.println(pol3.multiply(pol1));
        System.out.println("Test Ball");
        Ball ball = new Ball(1.0f, 1.0f, 1, 1, -45);
        System.out.println(ball);
        Container cont = new Container(0,0, 10, 10);
        System.out.println(cont);
        int count = 0;
        while (cont.collides(ball))
        {
            ball.move();
            count++;
        }
        System.out.println("ball have done "+count+" steps");
        ball.setX(1.0f);
        ball.setY(1.0f);
        System.out.println(ball);
        count = 1;
        ball.move();
        while (!near((double)ball.getX(), 1.0, 1.0e-3) && !near((double)ball.getY(), 1.0, 1.0e-3))
        {
            ball.move();
            if (!cont.collidesHeigth(ball)) ball.reflectVertical();
            if (!cont.collidesWidth(ball)) ball.reflectHorizontal();
            count++;
        }
        System.out.println("with bounes ball have done "+count+" steps until it came back");
    }
}
