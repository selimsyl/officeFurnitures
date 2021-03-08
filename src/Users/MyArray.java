package Users;

public class MyArray<T> {
    T[] product;
    int size;
    final int capacity;

    public Array(int capacity) {
        product = new T[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean add(T[] furnitures) {
        if (furnitures == null)
            return false;

        if (furnitures.length + size > capacity) {
            System.out.println("Not enough storage capacity");
            return false;
        }

        for (int i = 0; i < size; ++i) {
            product[i] = furnitures[i];
        }
        size += furnitures.length;
        return true;
    }

    public T remove(int index) {
        assert index < size && index > -1;

        T returnFurniture = product[index];
        T[] temp = new T[capacity];

        for(int i=0;i<size;i++) {
            if (i == index) {
                continue;
            }
            temp[i] = T[i+1];
        }
        product= temp;
        size--;
        return returnFurniture;
    }

    public int find(T desiredFurniture) {
        for(int i=0; i<size; i++) {
            if (desiredFurniture.equals(product[i])) {
                return i;
            }
        }
        return -1;
    }

//    /**
//     * @param desiredFurniture
//     * @return
//     * If desiredFurniture doesnt found return null
//     */
//    public Furniture getFurniture(Furniture desiredFurniture) {
//        int index = findFurniture(desiredFurniture);
//        if (index >= 0) {
//            return product[index];
//        }
//        return null;
//    }
}