package com.company.MyList;

import java.util.Iterator;

public class IIterator<E> implements Iterator{

    MyNode<E> head = null;
    MyNode<E> cur = null;

    public IIterator( MyNode<E> head)
    {
        this.head = head;
        this.cur = head;
    }

    @Override
    public boolean hasNext() {
        return (cur != null);
    }

    @Override
    public E next() {
        MyNode<E> tmp = cur;
        cur = cur.next;
        return  tmp.item;
    }
}
