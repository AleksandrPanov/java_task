package com.company;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }
    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }
    public double getImag() {
        return imag;
    }

    public void setReal(double real) {
        this.real = real;
    }
    public void setImag(double imag) {
        this.imag = imag;
    }
    void SetValue(double real, double imag)
    {

        this.real = real;
        this.imag = imag;
    }
    @Override
    public String toString() {
        return "(" + real +"+" + imag + "i)";
    }

    boolean isReal()
    {
        return (imag == 0.0);
    }
    boolean isImaginary()
    {
        return (imag != 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyComplex myComplex = (MyComplex) o;

        if (Double.compare(myComplex.real, real) != 0) return false;
        return Double.compare(myComplex.imag, imag) == 0;
    }

    public boolean equals(MyComplex o)
    {
        return (real == o.real && imag == o.imag);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imag);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    double magnitude()
    {
        return Math.sqrt(real*real + imag*imag);
    }
    double argument()
    {
        if (real == 0 && imag == 0) return -100.0;
        if (real > 0) return Math.atan(imag/real);
        if (real < 0 && imag >= 0) return Math.PI + Math.atan(imag/real);
        if (imag > 0) return Math.PI/2;
        return -Math.PI/2;
    }
    MyComplex addNew(MyComplex o)
    {
        return new MyComplex(real + o.real, imag + o.imag);
    }
    MyComplex substractNew(MyComplex o)
    {
        return new MyComplex(real - o.real, imag - o.imag);
    }
    MyComplex conjugate()
    {
        return new MyComplex(real, -imag);
    }
    MyComplex add(MyComplex o)
    {
        real += o.real;
        imag += o.imag;
        return this;
    }
    MyComplex subtruct(MyComplex o)
    {
        real -= o.real;
        imag -= o.imag;
        return this;
    }
    MyComplex multiply(MyComplex o)
    {
        real = real * o.real - imag * o.imag;
        imag = real * o.imag + imag * o.real;
        return this;
    }
    MyComplex divide(MyComplex o)
    {
        double r = (real * o.real + imag * o.imag) / (o.real * o.real + o.imag * o.imag);
        imag = (imag * o.real - real * o.imag) / (o.real * o.real + o.imag * o.imag);
        real = r;
        return this;
    }
}
