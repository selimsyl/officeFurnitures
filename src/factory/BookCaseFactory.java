package factory;

import furniture.BookCase;
import furniture.Color;

public class BookCaseFactory implements Factory {

    public BookCaseFactory() {}

    @Override
    public BookCase[] createFurniture() {
        BookCase[] order = new BookCase[BookCase.BookCaseModels.values().length*Color.values().length];
        int index = 0;
        for (BookCase.BookCaseModels model : BookCase.BookCaseModels.values()) {
            for (Color color : Color.values()) {
                order[index++] = new BookCase(model, color);
            }
        }
        return order;
    }
}
