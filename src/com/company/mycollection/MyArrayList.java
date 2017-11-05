package com.company.mycollection;

import java.util.Collection;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyList<E>{
    private int size;
    private int capacity;
    private Object[] elementData;
    private static int steps = 10;


    private void myCopy(int initCapacity) {
        Object[] newEleData = new Object[initCapacity];
        for (int i = 0; i < size; i++) {
            newEleData[i] = elementData[i];
        }
        elementData = newEleData;
    }

    public MyArrayList() {
        elementData = new Object[steps];
        capacity = 10;
        size = 0;

    }
    public MyArrayList(int initCapacity) {
        if (initCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initCapacity);
        } else if (initCapacity <= steps) {
            elementData = new Object[steps];
            capacity = steps;
            size = initCapacity;
        } else if (initCapacity > steps) {
            capacity = initCapacity % steps == 0 ? initCapacity : (initCapacity / 10 + 1) * steps;
            elementData = new Object[capacity];
            size = initCapacity;
        }
    }
    public MyArrayList(Collection<E> coll) {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("This index out of bounds: " + index);
        }
        return (E)elementData[index];
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = size; i >= 0; i--) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(E element) {
        if (size >= capacity) {
            capacity += steps;
            myCopy(capacity);
        }
        elementData[size++] = element;

    }

    @Override
    public void add(int index, E element) {
        if (size >= capacity) {
            capacity += steps;
            myCopy(capacity);
        }
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = element;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index out of bounds: " + index);
        }
        E elem = (E)elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        if ((capacity - size) / steps > 0) {
            capacity -= steps;
        }
        return elem;
    }

    @Override
    public boolean remove(E element) {
        boolean ok = false;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                index = i;
                ok = true;
                break;
            }
        }
        if(ok) {
            for (int i = index; i < size - 1; i++) {
                elementData[i] = elementData[i + 1];
            }
            size--;
            if ((capacity - size) / steps > 0) {
                capacity -= steps;
            }
        }
        return false;
    }

    @Override
    public void set(int index, E element) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index out of bounds: " + index);
        }
        for (int i = 0; i < size; i++) {
            if (i == index) {
                elementData[i] = element;
                break;
            }
        }
    }

    /**
     * iterator
     */
    public MyIterator<E> iterator(){
        return new MyItr();
    }

    private class MyItr implements MyIterator<E> {
        private int ptr;                // from 0 to size - 1

        @Override
        public boolean hasNext() {
            return ptr < size - 1;
        }

        @Override
        public E next() {
            if (ptr == size) {
                throw new NoSuchElementException("next element is null");
            }
            return (E) elementData[ptr++];
        }

        @Override
        public int nextIndex() {
            return ptr + 1;
        }

    }

}
