//import officeFurnitures.Product.Product.Product;


import Users.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Driver.run();
        Company.init();
        Menu menu = new Menu();
        menu.run();
    }
}
