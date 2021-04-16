//import officeFurnitures.Product.Product.Product;


import Users.*;
import containers.HybridList;
import containers.KWArrayList;
import containers.KWLinkedList;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

      Driver.run();
      Company.init();
      Menu menu = new Menu();
      Test.TestRun();
      menu.run();
    }
}
