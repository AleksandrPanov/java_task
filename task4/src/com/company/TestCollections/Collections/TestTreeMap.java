package com.company.TestCollections.Collections;
import com.company.TestCollections.Functor;
import com.company.TestCollections.Operations;

import java.util.TreeMap;

public class TestTreeMap<T> extends TreeMap<T, T> implements Functor<T>
{
    @Override
    public void calculate(T key, Operations operation)
    {
        switch (operation)
        {
            case Add:
                this.put(key, key);
                break;
            case Insert:
                System.out.println("There is no insert operation");
                break;
            case Delete:
                this.remove(key);
                break;
            case Search:
                this.containsKey(key);
                break;
        }
    }
    @Override
    public String toString()
    {
        return "TreeMap";
    }
}