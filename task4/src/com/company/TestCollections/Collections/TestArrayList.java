package com.company.TestCollections.Collections;

import com.company.TestCollections.Functor;
import com.company.TestCollections.Operations;

import java.util.ArrayList;

public class TestArrayList<T> extends ArrayList<T> implements Functor<T> {
    @Override
    public void calculate(T key, Operations operation) {
        switch (operation)
        {
            case Add:
                this.add(key);
                break;
            case Insert://вставка будет производиться в середину
                this.add(this.size()/2, key);
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
        return "ArrayList";
    }
}
