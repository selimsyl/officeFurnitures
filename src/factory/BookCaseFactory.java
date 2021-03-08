package factory;

import officeFurnitures.BookCase;
import officeFurnitures.Chair;
import officeFurnitures.Color;

public class BookCaseFactory implements Factory {

    public BookCaseFactory() {}

    @Override
    public BookCase[] createFurniture() {
        BookCase[] order = new BookCase[BookCase.BookCaseModels.values().length];
        int index = 0;
        for (BookCase.BookCaseModels model : BookCase.BookCaseModels.values()) {
            for (Color color : Color.values()) {
                order[index++] = new BookCase(model, color);
            }
        }
        return order;
    }
}
