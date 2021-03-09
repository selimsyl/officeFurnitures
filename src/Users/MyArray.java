package Users;

public class MyArray<T extends User> {
    User[] users;
    int size;
    int capacity;

    public MyArray() {
        users = new User[2];
        size=0;
        this.capacity=2;
    }

    public void remove(T person) {
        int index = find(person);

        if (index < 0)
            return;

        remove(index);
    }

    private int find(T person) {
        for (int i = 0; i < users.length; ++i) {
            if (person.equals(users[i])) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public T getUser(T user) {
        int index = find(user);
        if (index >= 0)
            return (T) users[index];
        
        return null;
    }

    public void add(T newPerson) {
        // double the capacity if all the allocated space is utilized
        if (size == capacity){
            increaseCapacity(10);
        }
        users[size] = newPerson;
        size++;
    }

    public void increaseCapacity(int extraCapacity){
        User[] temp = new User[capacity+extraCapacity];
        for (int i=0; i < capacity; i++){
            temp[i] = users[i];
        }
        users = temp;
        capacity = users.length;
    }

    private void remove(int index){
        for(int i=index;i<size-1;i++){
            users[i] = users[i+1];
        }
        users[size-1] = null;
        size--;

        if (size <= capacity/2) {
            trimToSize();
        }
    }

    public void trimToSize(){
        User[] temp = new User[size];
        for (int i=0; i < size; i++){
            temp[i] = users[i];
        }
        users = temp;
        capacity = users.length;
    }
}