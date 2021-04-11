package containers;

import java.util.*;

public class KWArrayList<E>  {
    /**
     * Capacity of array to store datas
     */
    private static final int INITAL_CAPACITY = 10;

    /**
     * Underlying array to store data
     */
    private E[] theData;

    /**
     * Current size of underlying array
     */
    private int size;

    /**
     * Max size of underlyig array
     */
    private int capacity;

    public KWArrayList() {
        capacity = INITAL_CAPACITY;
        size = 0;
        theData = (E[]) new Object[capacity];
    }

    public KWArrayList(int initialCapacity) {
        capacity = initialCapacity;
        size = 0;
        theData = (E[]) new Object[capacity];
    }

    /**
     * @param element instert element to end of list
     * @return true if inserting is successful
     */
    public boolean add(E element) {
        if (size == capacity) {
            reallocate();
        }
        theData[size++] = element;
        return true;
    }

    public void add(int index, E element) {
        checkIndexBorder(index);

        if (size == capacity) {
            reallocate();
        }

        for (int i = size; i > index; --i) {
            theData[i] = theData[i-1];
        }
        theData[index] = element;
        size++;
    }

    /**
     * @param index get element of index
     * @return
     */
    public E get(int index) {
        checkIndexBorder(index);

        return theData[index];
    }

    /**
     * @param index element to be set
     * @param element new element to replace old one
     * @return
     */
    public E set(int index, E element) {
        checkIndexBorder(index);

        E oldElement = theData[index];
        theData[index] = element;
        return oldElement;
    }

    /**
     * @param index index of element to be removed
     * @return
     */
    public E remove(int index) {
        checkIndexBorder(index);

        E removedElement = theData[index];

        for (int i = index; i < size - 1; ++i) {
            theData[i] = theData[i + 1];
        }
        size--;
        return removedElement;
    }

    /**
     * @param target to be find in list
     * @return index of first target if it is in list, otherwise -1
     */
    public int indexOf(E target) {
        for (int i = 0; i < size; ++i) {
            if (target.equals(theData[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return size of underlying array
     */
    public int size() {
        return size;
    }

    /**
     * @return true if underlying array size is 0, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }


    /**
     * @param index check index is valid
     *              if index is unvalid throw IndexOutOfBoundsException
     */
    private void checkIndexBorder(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    /**
     * double the capacity of underlying array
     */
    private void reallocate() {
        capacity *= 2;
        theData = Arrays.copyOf(theData, capacity);
    }

}
