package com.company;

import java.util.Iterator;

public interface ILinkedList<E> extends Iterator<E> {
    void add(E el);
    void add(int ind, E el);
    void clear();
    int indxOf(E el);
    E remove(int ind);
    E set(int ind, E el);
    int size();
    E[] toArray();
    String toString();
}
