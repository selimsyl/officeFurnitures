package factory;

import officeFurnitures.BookCase;

public class BookCaseFactory implements Factory {

    public BookCaseFactory() {}

    @Override
    public BookCase[] createFurniture() {
        BookCase[] order = new BookCase[BookCase.BookCaseModels.values().length];
        int index = 0;
        for (BookCase.BookCaseModels model : BookCase.BookCaseModels.values()) {
                order[index++] = new BookCase(model,10);
        }
        return order;
    }
}
