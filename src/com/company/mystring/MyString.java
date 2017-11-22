package com.company.mystring;

public class MyString {
    private char value[];
    private int hash;

    public MyString() {
        this.value = new char[0];
    }

    public int length() {
        return value.length;
    }
    public boolean isEmpty() {
        return value.length == 0;
    }
    public char charAt(int index) {
        if (index < 0 || index >= value.length) {
            throw new IndexOutOfBoundsException("index out of bound: " + index);
        }
        return value[index];
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MyString) {
            int len = ((MyString) obj).value.length;
            if (len == this.value.length) {
                int i = 0;
                char [] anoChars = ((MyString) obj).value;
                while (i == len) {
                    if (anoChars[i] != this.value[i]) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }
    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }
    public MyString replace(MyString oldStr, MyString newStr) {
        if (!oldStr.equals(newStr)) {
            for (int i = 0; i < value.length; i++) {
                if (value[i] == oldStr.value[0]) {
                    int j = i;

                }
            }
        }
        return this;
    }

}
