package com.company;


public class Main {
// Collection
// ├List
// │├LinkedList
// │├ArrayList
// │└Vector
// │　└Stack
// └Set
//
// Map
// ├Hashtable
// ├HashMap
// └WeakHashMap

    public static class Student{
        public int a;
        public int b;
        public String c;
        Student(int a, int b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public String show() {
            return String.format("a: %d, b: %d, c: %s", a, b, c);
        }

    }

    public static void main(String[] args) {
        Student a1 = new Student(1, 1, "hello");
        Student a2 = new Student(2, 2, "sdf");
        Student a3 = new Student(3, 3, "helfdffflo");
        Student b1 = new Student(4, 4, "worldhhh");

        Student[] ori = {a1, a2, a3};
        Student[] tar = new Student[3];

        System.arraycopy(ori, 0, tar, 0, 3);

        System.out.println(tar[0].show());
        tar[0].c = "llllllllll";

        System.out.println(ori[0].show() + "\n" + tar[0].show());
    }
}
