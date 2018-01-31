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
        return size() == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) < 0 ? false : true;
    }

    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                checkIndexInArray(index);
                T t = (T) array[index];
                index++;
                return t;
            }
        };
    }

    public Object[] toArray() {
        return array;
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t) {
        checkNotNullElement(t);
        int newIndex = size() + 1;
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
        checkNotNullElement(c);
        boolean flag = false;
        if(c.isEmpty()) {
            return flag;
        }
        if(isEmpty()) {
            return flag;
        }
        Object[] containsArray = c.toArray();
        for(int i = 0; i < containsArray.length; i++) {
            for(int j = 0; j < size(); j++) {
                if(array[j].equals(containsArray[i])){
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                return flag;
            } else {
                flag = false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends T> c) {
        checkNotNullElement(c);
        if(c.isEmpty()) {
            return true;
        }
        if(isEmpty()) {
            array = c.toArray();
            return true;
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
        if(c.isEmpty()) {
            return true;
        }
        int newSize = size() + c.size();
        if(newSize > max_size) {
            throw new RuntimeException("newSize > max_size");
        }
        if(index == size() - 1) {
            return addAll(c);
        }
        if(isEmpty()) {
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
        if (size() > 0) {
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
        if (size() == 1) {
            T res = (T) array[index];
            array = EMPTY_ARRAY;
            return res;
        }
        int newIndex = size()-1;
        Object[] oldArray = array;
        array = new Object[newIndex];
        int fromIndex = index+1;
        System.arraycopy(oldArray, 0, array, 0, index);
        System.arraycopy(oldArray, fromIndex, array, index, (oldArray.length - fromIndex));
        return (T)oldArray[index];
    }

    public int indexOf(Object o) {
        checkNotNullElement(o);
        if(!isEmpty()) {
            for (int i = 0; i < size(); i++) {
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
        if(!isEmpty()) {
            for (int i = 0; i < size(); i++) {
                if(array[i].equals(o)) {
                    index = i;
                }
            }
        }
        return index;
    }

    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    public ListIterator<T> listIterator(int index) {
        checkIndexInArray(index);
        return new ListIterator<T>() {

            private int ind = index;

            @Override
            public boolean hasNext() {
                return ind < size();
            }

            @Override
            public T next() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public T previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(T t) {

            }

            @Override
            public void add(T t) {

            }
        };
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
        if(index > size() || index < 0)
            throw new RuntimeException(this.getClass().getName() + " not found index: " + index + "; size: " + size());
    }

    private void checkNotNullElement(Object o) {
        Objects.requireNonNull(o);
    }
}
