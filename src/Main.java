//import officeFurnitures.Product.Product.Product;


import Users.*;
import com.sun.source.tree.CaseTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.SwitchTree;
import com.sun.source.tree.TreeVisitor;
import officeFurnitures.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
//        Driver.run();
        Company.init();
        Menu menu = new Menu();
        menu.userMenu();
    }
}
