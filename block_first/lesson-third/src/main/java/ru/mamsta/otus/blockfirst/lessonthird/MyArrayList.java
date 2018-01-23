package ru.mamsta.otus.blockfirst.lessonthird;

import java.util.*;

public class MyArrayList<T> implements List<T> {

    private Object[] array;

    public MyArrayList() {

    }

    public MyArrayList(int size) {
        this.array = new Object[size];
    }

    public MyArrayList(Object... array) {
        this.array = array;
    }

    public int size() {
        return array.length;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        return array;
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public T get(int index) {
        return null;
    }

    public T set(int index, T element) {
        array[index] = element;
        return element;
    }

    public void add(int index, T element) {

    }

    public T remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public List<T> subList(final int fromIndex, final int toIndex) {
        int fromIndexTmp = fromIndex;
        Object[] tmp = new Object[toIndex - fromIndexTmp];
        for(int i = 0; fromIndex <= toIndex; fromIndexTmp++, i++) {
            tmp[i] = array[fromIndexTmp];
        }
        return new MyArrayList<T>(tmp);
    }
}
