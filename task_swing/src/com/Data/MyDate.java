package com.Data;
import com.Exception.ExeptionDate;
import com.Exception.ExeptionDateNotExist;
import java.util.Date;

public class MyDate extends Date {
    public MyDate()
    {
        super();
    }
    public MyDate(int year, int month, int date) {
        super(year - 1900, month - 1, date);
    }
    private static int pars(String s, int d) throws NumberFormatException
    {
       return Integer.parseInt(s) - d;
    }
    public static MyDate pars(String s) throws ExeptionDate, NumberFormatException, ExeptionDateNotExist
    {
        if (s.length() != 10)
            throw new ExeptionDate();
        String s1 = s.substring(2,3);
        String s2 = s.substring(5,6);
        if (!s.substring(2,3).equals(".") || !s.substring(5,6).equals(".")) throw new ExeptionDate();
        int d = pars(1 +s.substring(0, 2), 100);
        if (d == 0 || d > 31)
            throw new ExeptionDateNotExist();
        int m = pars(1 +s.substring(3, 5), 100);
        if (m == 0 || m > 12)
            throw new ExeptionDateNotExist();
        int y = pars(1 +s.substring(6, 10), 10000);
        MyDate tmp =  new MyDate(y,m,d);
        if (tmp.getDate() != d)
            throw new ExeptionDateNotExist();
        return tmp;
    }

    @Override
    public String toString() {
        String s = "";
        if (super.getDate() < 10) s = "0";
        return s+super.getDate() + "." + (super.getMonth()+1) + "." + (getYear()+ 1900);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyDate date = (MyDate) obj;
        return toString().equals(date.toString());
    }
}