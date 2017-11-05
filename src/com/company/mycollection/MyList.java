package com.company.mycollection;

public interface MyList<E> {
    int size();
    boolean isEmpty();

    E get(int index);
    void set(int index, E element);
    void add(E element);
    void add(int index, E element);
    E remove(int index);
    boolean remove(E element);

    int indexOf(E element);
    int lastIndexOf(E element);

}
