package com.company.mycollection;

public interface MyIterator <E> {
    boolean hasNext();
    E next();
    int nextIndex();
}
