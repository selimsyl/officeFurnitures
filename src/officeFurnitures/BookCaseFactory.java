package officeFurnitures;

public class BookCaseFactory implements Factory {

    Models.BookCaseModels model;
    int count;
    public BookCaseFactory(Models.BookCaseModels model, int count) {
        this.model = model;
        this.count = count;
    }
    @Override
    public BookCase[] createFurniture() {
        BookCase[] order = new BookCase[count];
        for (int i=0; i < count; ++i) {
            order[i] = new BookCase(model);
        }
        return order;
    }
}
