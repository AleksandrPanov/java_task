package com.company;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float)Math.cos((double)direction * (Math.PI/180));
        this.yDelta = -(float)Math.sin((double)direction * (Math.PI/180));
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move()
    {
        x += xDelta;
        y += yDelta;
    }

    void reflectHorizontal()
    {
        xDelta = - xDelta;
    }

    void reflectVertical()
    {
        yDelta = - yDelta;
    }

    @Override
    public String toString() {
        return "Ball{" +
                '(' + x +
                ',' + y +
                "),speed=(" + xDelta + "," + yDelta + ")}";
    }
}
