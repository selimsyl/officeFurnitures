//import officeFurnitures.Product.Product.Product;

import Users.User;
import officeFurnitures.*;

import java.lang.reflect.Array;

interface Modelo {
    String getValue();
}

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        arr[5] = null;

        for (Integer i:arr) {
            if (i == null) {
                System.out.println("null");
            }
        }
    }
}
