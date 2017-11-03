package com.company;

public class MyLinkedList<E> implements ILinkedList<E>{
    private static class MyNode<E> {
        E item;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(MyNode<E> prev, E element, MyNode<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    MyNode<E> head;

    @Override
    public void add(E el) {

    }

    @Override
    public void add(int ind, E el) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int indxOf(E el) {
        return 0;
    }

    @Override
    public E remove(int ind) {
        return null;
    }

    @Override
    public E set(int ind, E el) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
}
