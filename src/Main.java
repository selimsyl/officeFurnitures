//import officeFurnitures.Product.Product.Product;

import FurnitureFactory.BookCaseFactory;
import FurnitureFactory.Factory;
import officeFurnitures.BookCase;
import officeFurnitures.Furniture;

public class Main {

    public static void main(String[] args) {
        int[] counts = new int[100];
        produceFurniture(new BookCaseFactory(BookCase.BookCaseModels.BOOKCASE2,10));
    }

    public static void produceFurniture(Factory factory) {
        Furniture[] order = factory.createFurniture();

    }
}
