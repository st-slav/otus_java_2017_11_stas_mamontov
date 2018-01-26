package ru.mamsta.otus.blockfirst.lessonthird;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.*;

public class MyArrayList<T> implements List<T> {

    private Object[] array;

    private Object[] EMPTY_ARRAY = {};

    private int max_size = Integer.MAX_VALUE;

    private int size;

    public MyArrayList() {

    }

    public MyArrayList(int size) {
        if(size > max_size) {
            throw new OutOfMemoryError();
        } else if (size < 0) {
            throw new RuntimeException("index for array < 0");
        }
        max_size = size;
    }

    public MyArrayList(Object... array) {
        this.array = array;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if(o.equals(array[i])) {
                    return true;
                }
            }
        }
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
        for(int i = 0; i < size; i++) {

        }
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
        if (array.length > 0) {
            array = EMPTY_ARRAY;
        }
    }

    public T get(int index) {
        checkIndexLimits(index);
        checkIndexForArray(index);
        return (T) array[index];
    }

    public T set(int index, T element) {
        checkNotNullElement(element);
        checkIndexForArray(index);
        checkNotNullElement(element);
        array[index] = element;
        return element;
    }

    public void add(int index, T element) {
        checkIndexForArray(index);
        checkNotNullElement(element);
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

    private void checkIndexLimits(int index) {
        if(index < 0) {
            throw new RuntimeException("index < 0");
        } else if (index > max_size) {
            throw new RuntimeException("index > max size (" + max_size + ")" );
        }
    }

    private void checkIndexForArray(int index) {
        if(index > array.length || index < 0)
            throw new RuntimeException(this.getClass().getName() + " not founnd index: " + index);
    }

    private void checkNotNullElement(Object o) {
        if(Objects.isNull(o))
            throw new NullPointerException(o.getClass().getName() + " == null");
    }
}
