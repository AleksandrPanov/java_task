package com.company.MyList;

public class MyNode<E> {
    E item;
    MyNode<E> next;
    MyNode<E> prev;

    MyNode(MyNode<E> prev, E element, MyNode<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return  item+" ";
    }
}