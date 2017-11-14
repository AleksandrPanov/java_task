package com.company.MyList;
import com.company.TestCollections.Functor;
import com.company.TestCollections.Operations;

public class MyLinkedList<E> implements ILinkedList<E>, Functor<E>{
    MyNode<E> head = null;
    MyNode<E> tail = null;
    int size;

    @Override
    public void calculate(E key, Operations operation) {
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
        return "MyLinkedList";
    }

    @Override
    public void add(E el) {
        if (tail != null)
        {
            tail = new  MyNode<>(tail, el, null);
            tail.prev.next = tail;
        }
        else if (head == null)
        {
            head = new MyNode<>(null, el, null);
        }
        else //tail == null
        {
            tail = new  MyNode<>(head, el, null);
            head.next = tail;
        }
        size++;
    }

    @Override
    public void add(int ind, E el) {
        check(ind);
        if (ind != 0)
        {
            MyNode<E> tmp = getNode(ind);
            MyNode<E> ins = new MyNode<>(tmp.prev, el, tmp);

            tmp.prev.next = ins;
            tmp.prev = ins;

            if (size == 1)
                tail = tmp;
        }
        else
        {
            MyNode<E> ins = new MyNode<>(null, el, head);
            if (head != null) head.prev = ins;
            head = ins;
        }
        size++;
    }

    @Override
    public void clear() {
        size = 0;
        while (head != null)
        {
            head.item = null;
            head = head.next;
        }
    }

    @Override
    public int indxOf(E el) {
        MyNode<E> tmp = head;
        for (int i = 0; i < size; i++)
        {
            if (tmp.item.equals(el)) return i;
            tmp = tmp.next;
        }
        return -1;
    }

    public boolean contains(E el)
    {
        return (indxOf(el) != -1);
    }

    private MyNode<E> getNode(int ind)
    {
        int i = 0;
        MyNode<E> tmp = head;
        while (i < ind)
        {
            i++;
            tmp = tmp.next;
        }
        return tmp;
    }

    @Override
    public E remove(int ind) {
        size--;
        check(ind);
        MyNode<E> tmp = new MyNode(null, null, null);
        if (size == 0)
        {
            tmp = head;
            head = null;
        }
        else if (ind == 0)
        {
            head = new MyNode<>(null, head.next.item, head.next.next);
            tmp = head;
            if (head == tail)
                tail = null;
        }
        else
        {
            tmp = getNode(ind);
            tmp.prev.next = tmp.next;
            if (ind == size) tail = tail.prev;
        }
        return tmp.item;
    }

    public void remove(E el)
    {
        int ind = indxOf(el);
        remove(ind);
    }

    @Override
    public E set(int ind, E el) {
        check(ind);
        MyNode<E> tmp = getNode(ind);
        E was = tmp.item;
        tmp.item = el;
        return was;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        Object[] arr=new Object[size()];
        int i=0;
        for (MyNode node=head.next; node!=null; node=node.next, i++)
            arr[i]=node.item;
        return (E[]) arr;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }

    private boolean indexInside(int index)
    {
        return index >= 0 && index <= size;
    }
    public boolean empty()
    {
        return (size == 0);
    }

    private void check(int index)
    {
        if (!indexInside(index))
            throw new IndexOutOfBoundsException();
    }

    public String myContains()
    {
        MyNode<E> tmp = head;
        String s = "MyLinkedList contains ";
        for (int i = 0; i < size; i++)
        {
            s = s.concat(tmp.item.toString()+" ");
            tmp = tmp.next;
        }
        return s;
    }

    public IIterator<E> iterator()
    {
        IIterator<E> it = new IIterator<>(head);
        return it;
    }
}
