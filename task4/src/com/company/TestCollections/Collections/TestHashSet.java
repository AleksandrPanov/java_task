package com.company.TestCollections.Collections;

import com.company.TestCollections.Functor;
import com.company.TestCollections.Operations;

import java.util.HashSet;

public class TestHashSet<T> extends HashSet<T> implements Functor<T>{

    @Override
    public void calculate(T key, Operations operation) {
        switch (operation)
        {
            case Add:
                this.add(key);
                break;
            case Insert:
                System.out.println("There is no insert operation");
                break;
            case Delete:
                this.remove(key);
                break;
            case Search:
                this.contains(key);
                break;
        }
    }

    @Override
    public String toString() {
        return "HashSet";
    }
}
