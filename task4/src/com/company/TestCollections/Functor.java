package com.company.TestCollections;

public interface Functor<T> {
    void calculate(T key, Operations operation);
}
