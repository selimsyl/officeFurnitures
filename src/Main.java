//import officeFurnitures.Product.Product.Product;

import furnitureFactory.BookCaseFactory;
import furnitureFactory.Factory;
import officeFurnitures.BookCase;
import officeFurnitures.Furniture;

public class Main {

    public static void main(String[] args) {
        int[] counts = new int[100];
        produceFurniture(new BookCaseFactory(BookCase.BookCaseModels.BOOKCASE2,10));
    }

    public static void produceFurniture(Factory factory) {
        Furniture[] order = factory.createFurniture();
        for (Furniture ele:order
             ) {
            if (BookCase.BookCaseModels.BOOKCASE2 == ele.getModel()) {
                System.out.println("model found");
            }
        }
    }
}
