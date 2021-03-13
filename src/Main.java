//import officeFurnitures.Product.Product.Product;


import Users.*;
import officeFurnitures.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Driver driver = new Driver();
        try {
            driver.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
