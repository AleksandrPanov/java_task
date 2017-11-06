package com.company;

import java.util.Iterator;

public class IIterator<E, T extends Node<E>> implements Iterator{

    Node<E> head;
    Node<E> cur;

    @Override
    public boolean hasNext() {
        return (cur.next != null);
    }

    @Override
    public Node<E> next() {
        cur = cur.next;
        return  cur;
    }
}
