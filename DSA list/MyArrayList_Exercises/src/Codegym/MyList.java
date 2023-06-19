package Codegym;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object[] element;

    public MyList() {
        this.element = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        this.element = new Object[capacity];
    }


    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of the boundary");
        } else if (size == this.element.length - 2) {
            ensureCapa(size * 2);
        }
        for (int i = index; i < size; i++) {
            this.element[i + 1] = this.element[i];
        }
        this.element[index] = element;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of the boundary");
        }
        for (int i = index; i < size; i++) {
            element[i] = element[i + 1];
        }
        size--;
    }

    public int size() {
        return this.size;
    }

    public MyList<E> clone() {
        MyList<E> newElement = new MyList<>();
        //Object[] newElement = new Object[this.size];
        newElement.size = this.size;
        newElement.element = Arrays.copyOf(this.element, this.size);

        return newElement;
    }

    public boolean contains(E o) {
        boolean contain = false;
        for (int i = 0; i < size; i++) {
            if (this.element[i] == o) contain = true;
        }
        return contain;
    }

    public int indexOf(E o) {
        for (int i = 0; i < this.size; i++) {
            if (this.element[i] == o) {
                return i;
            }
        }
        return -1;
    }

    boolean add(E e) {
        if (size == element.length) {
            ensureCapa(size * 2);
        }
        this.element[size] = e;
        this.size++;
        return true;
    }

    public void ensureCapa(int minCapacity) {
        this.element = Arrays.copyOf(this.element, minCapacity);
    }

    E get(int i) {
        if (i > size || i < 0) {
            throw new IndexOutOfBoundsException("OutOfTheException");
        }
        return (E) element[i];
    }

    public void clear() {
        element = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void printall() {
        for (int i = 0; i < size; i++) {
            System.out.println(element[i]);
        }
    }
}
