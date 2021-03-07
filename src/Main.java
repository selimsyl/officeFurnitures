//import officeFurnitures.Product.Product.Product;

import Branches.Branch;
import officeFurnitures.*;

public class Main {


    public static void main(String[] args) {
        int[] counts = new int[100];
//        Furniture furniture = makeProduct(new ChairFactory(Models.ChairModels.CHAIR2,"white",1))[0];
//        Furniture furniture1 = makeProduct(new ChairFactory(Models.ChairModels.CHAIR2,"white",1))[0];
//
//        System.out.println(furniture.equals(makeProduct(new ChairFactory(Models.ChairModels.CHAIR2,"black",1))[0]));
//        System.out.println(furniture.equals(makeProduct(new ChairFactory(Models.ChairModels.CHAIR1,"white",1))[0]));
//        System.out.println(furniture.equals(makeProduct(new ChairFactory(Models.ChairModels.CHAIR1,"black",1))[0]));
//        System.out.println(furniture.equals(makeProduct(new ChairFactory(Models.ChairModels.CHAIR2,"white",1))[0]));


    }

    public static Furniture[] makeProduct(Factory factor) {
        return factor.createFurniture();
    }

}
