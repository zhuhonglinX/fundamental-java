package com.company.mycollection;

import sun.rmi.rmic.iiop.PrimitiveType;

import java.lang.annotation.ElementType;

public class MyLinkedList<E> implements MyList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    MyLinkedList() {
    }

    /**
     * 双向链表
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            item = element;
            this.next = next;
        }
    }

    private Node<E> node(int index) {
        Node<E> nodePtr = first;
        for (int i = 0; i < index; i++) {
            nodePtr = nodePtr.next;
        }
        return nodePtr;
    }
    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index out of bounds: " + index);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return node(index).item;
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);
        Node<E> ptr = node(index);
        ptr.item = element;
    }

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(last, element, null);
        if (size == 0) {
            first = last = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        Node<E> ptr = node(index);
        ptr.prev = new Node<>(ptr.prev, element, ptr);
        size++;

    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> ptr = node(index);
        ptr.next.prev = ptr.prev;
        ptr.prev.next = ptr.next;
        ptr.prev = ptr.next = null;
        return ptr.item;
    }

    /**
     * remove first one
     */
    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item.equals(element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        return 0;
    }

}
