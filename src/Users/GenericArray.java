package Users;

import java.util.Arrays;

public class GenericArray<T> {
    protected T[] data;
    protected int size;
    protected int capacity = 10;

    @SuppressWarnings("unchecked")
    public GenericArray() {
        data = (T[]) new Object[this.capacity];
        size=0;
    }

    @SuppressWarnings("unchecked")
    public GenericArray(T[] data) {
        this.capacity = data.length * 2;
        this.data =  (T[]) new Object[this.capacity];
        System.arraycopy(data, 0, this.data, 0, data.length);
        size = data.length;
    }

    public GenericArray(T data) {
        this();
        this.data[0] = data;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    public T get(T data) {
        int index = find(data);
        if (index >= 0)
            return (T) this.data[index];

        return null;
    }

    public T get(int index) {
        if (index < 0 || index > data.length)
            throw new ArrayIndexOutOfBoundsException(index);

        return (T) this.data[index];
    }

    public boolean remove(T data) {
        int index = find(data);

        if (index < 0)
            return false;

        remove(index);

        return true;
    }

    private int find(T data) {
        for (int i = 0; i < this.size; ++i) {
            if (data.equals(this.data[i])) {
                return i;
            }
        }
        return -1;
    }

    public void add(T data) {
        if (size == capacity){
            increaseCapacity(2);
        }
        this.data[size++] = data;
    }

    public int getSize() {
        return size;
    }

    public T[] getDataArray() {
        return data;
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
        size--;
    }
}