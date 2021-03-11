//package Users;
//
//import java.util.Arrays;
//
//public class MyArray<T extends User> extends GenericArray<T> {
//    User[] users;
//    int size;
//    int capacity;
//
//    public MyArray() {
//        users = new User[10];
//        size=0;
//        this.capacity=10;
//    }
//
//    public MyArray(T[] persons) {
//        users = new User[persons.length + 10];
//        System.arraycopy(persons, 0, users, 0, persons.length);
//        size=persons.length;
//        this.capacity=users.length;
//    }
//
//    public MyArray(T person) {
//        this();
//        users[0] = person;
//    }
//
//    @SuppressWarnings("unchecked")
//    public T getUser(T user) {
//        int index = find(user);
//        if (index >= 0)
//            return (T) users[index];
//
//        return null;
//    }
//
//    public void remove(T person) {
//        int index = find(person);
//
//        if (index < 0)
//            return;
//
//        remove(index);
//    }
//
//    private int find(T person) {
//        for (int i = 0; i < users.length; ++i) {
//            if (person.equals(users[i])) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public void add(T newPerson) {
//        // double the capacity if all the allocated space is utilized
//        if (size == capacity){
//            increaseCapacity(2);
//        }
//        users[size] = newPerson;
//        size++;
//    }
//
//    private void increaseCapacity(int extraCapacity) {
//        users = Arrays.copyOf(users, capacity*extraCapacity);
////        User[] temp = new User[capacity*extraCapacity];
////        for (int i=0; i < capacity; i++){
////            temp[i] = users[i];
////        }
////        users = temp;
//        capacity = users.length;
//    }
//
//    private void remove(int index) {
//
//        if (index < 0 || index >= size) {
//            throw new ArrayIndexOutOfBoundsException(index);
//        }
//
//        for(int i=index; i < size-1; i++){
//            users[i] = users[i+1];
//        }
//
//        users[size-1] = null;
//        size--;
//
//        if (size <= capacity/2) {
//            trimToSize();
//        }
//    }
//
//    private void trimToSize() {
//        users = Arrays.copyOf(users, size);
////        User[] temp = new User[size];
////        for (int i=0; i < size; i++){
////            temp[i] = users[i];
////        }
////        users = temp;
//        capacity = users.length;
//    }
//}