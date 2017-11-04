package com.company.mycollection;

public interface MyList<E> {
    int size();
    boolean isEmpty();

    E get(int i);
    void set(int i, E element);
    void add(int index, E element);
    E remove(int index);
    boolean remove(Object o);

    int indexOf();
    int lastIndexOf(Object o);

}
