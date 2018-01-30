package ru.mamsta.otus.blockfirst.lessonthird;

import java.util.*;

public class MyArrayList<T> implements List<T> {

    private Object[] array;

    private Object[] EMPTY_ARRAY = {};

    private int max_size = Integer.MAX_VALUE;

    public MyArrayList() {
        array = EMPTY_ARRAY;
    }

    public MyArrayList(int size) {
        checkIndexLimits(size);
        max_size = size;
        array = EMPTY_ARRAY;
    }

    public MyArrayList(Object... array) {
        checkNotNullElement(array);
        this.array = array;
    }

    public int size() {
        return array.length;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) < 0 ? false : true;
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
        checkNotNullElement(t);
        int newIndex = array.length + 1;
        if((newIndex) > max_size) {
            throw new RuntimeException(this.getClass().getCanonicalName() + " crowded; size: " + array.length + "; max size: " + max_size);
        }
        Object[] oldArray = array;
        array = new Object[newIndex];
        System.arraycopy(oldArray, 0, array, 0, oldArray.length);
        array[oldArray.length] = t;
        return true;
    }

    public boolean remove(Object o) {
        try {
            return !Objects.isNull(remove(indexOf(o)));
        } catch (Throwable ex) { }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        checkNotNullElement(c);
        if(array.length == 0) {
            array = c.toArray();
        }
        Object[] oldArray = array;
        Object[] arrayForAdd = c.toArray();
        int newIndex = oldArray.length + arrayForAdd.length;
        array = new Object[newIndex];
        System.arraycopy(oldArray, 0, array, 0, oldArray.length);
        System.arraycopy(arrayForAdd, 0, array, oldArray.length, arrayForAdd.length);
        return true;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        checkNotNullElement(c);
        checkIndexInArray(index);
        int newSize = array.length + c.size();
        if(newSize > max_size) {
            throw new RuntimeException("newSize > max_size");
        }
        if(index == array.length - 1) {
            return addAll(c);
        }
        if(array.length == 0) {
            array = c.toArray();
        }
        Object[] oldArray = array;
        array = new Object[newSize];
        Object[] addArray = c.toArray();
        int fromIndex = index + 1;
        System.arraycopy(oldArray, 0, array, 0, index);
        System.arraycopy(addArray, 0, array, index, addArray.length);
        int nextIndex = addArray.length + index;
        System.arraycopy(oldArray, index, array, nextIndex, (oldArray.length - index));
        return true;
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
        checkIndexInArray(index);
        return (T) array[index];
    }

    public T set(int index, T element) {
        checkIndexInArray(index);
        checkNotNullElement(element);
        array[index] = element;
        return element;
    }

    public void add(int index, T element) {
        checkIndexInArray(index);
        checkNotNullElement(element);
        array[index] = element;
    }

    public T remove(int index) {
        checkIndexInArray(index);
        if (array.length == 1) {
            T res = (T) array[index];
            array = EMPTY_ARRAY;
            return res;
        }
        int newIndex = array.length-1;
        Object[] oldArray = array;
        array = new Object[newIndex];
        int fromIndex = index+1;
        System.arraycopy(oldArray, 0, array, 0, index);
        System.arraycopy(oldArray, fromIndex, array, index, (oldArray.length - fromIndex));
        return (T)oldArray[index];
    }

    public int indexOf(Object o) {
        checkNotNullElement(o);
        if(!this.isEmpty()) {
            for (int i = 0; i < array.length; i++) {
                if(array[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        checkNotNullElement(o);
        int index = -1;
        if(!this.isEmpty()) {
            for (int i = 0; i < array.length; i++) {
                if(array[i].equals(o)) {
                    index = i;
                }
            }
        }
        return index;
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public List<T> subList(final int fromIndex, final int toIndex) {
        checkIndexInArray(fromIndex);
        checkIndexInArray(toIndex);
        if(fromIndex > toIndex) {
            throw new RuntimeException("fromIndex > toIndex");
        } if (fromIndex == toIndex) {
            return new MyArrayList<T>();
        }
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

    private void checkIndexInArray(int index) {
        if(index > array.length || index < 0)
            throw new RuntimeException(this.getClass().getName() + " not found index: " + index + "; size: " + array.length);
    }

    private void checkNotNullElement(Object o) {
        if(Objects.isNull(o))
            throw new NullPointerException(o.getClass().getName() + " == null");
    }
}
