package Users;

import java.util.Arrays;

public class GenericArray<T>  {
    T[] data;
    int size;
    int capacity = 10;

    @SuppressWarnings("unchecked")
    public GenericArray() {
        data = (T[]) new Object[this.capacity];
        size=0;
    }

    @SuppressWarnings("unchecked")
    public GenericArray(T[] data) {
        this.data =  (T[]) new Object[data.length + 10];
        System.arraycopy(data, 0, data, 0, data.length);
        size = data.length;
        this.capacity=data.length;
    }

    public GenericArray(T data) {
        this();
        this.data[0] = data;
    }

    @SuppressWarnings("unchecked")
    public T get(T data) {
        int index = find(data);
        if (index >= 0)
            return (T) this.data[index];

        return null;
    }

    public void remove(T data) {
        int index = find(data);

        if (index < 0)
            return;

        remove(index);
    }

    private int find(T data) {
        for (int i = 0; i < this.data.length; ++i) {
            if (data.equals(this.data[i])) {
                return i;
            }
        }
        return -1;
    }

    public void add(T data) {
        // double the capacity if all the allocated space is utilized
        if (size == capacity){
            increaseCapacity(2);
        }
        this.data[size] = data;
        size++;
    }

    private void increaseCapacity(int extraCapacity) {
        data = Arrays.copyOf(data, capacity*extraCapacity);
        capacity = data.length;
    }

    private void remove(int index) {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        for(int i=index; i < size-1; i++){
            data[i] = data[i+1];
        }

        data[size-1] = null;
        size--;

        if (size <= capacity/2) {
            trimToSize();
        }
    }

    private void trimToSize() {
        data = Arrays.copyOf(data, size);
        capacity = data.length;
    }
}