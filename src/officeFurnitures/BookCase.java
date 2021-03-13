package officeFurnitures;

public class BookCase extends Product {

    @Override
    public String getColor() {
        return "";
    }

    public enum BookCaseModels implements Model {
        BOOKCASE1("BOOKCASE1"),BOOKCASE2("BOOKCASE2"),BOOKCASE3("BOOKCASE3"),BOOKCASE4("BOOKCASE4"),
        BOOKCASE5("BOOKCASE5"),BOOKCASE6("BOOKCASE6"),BOOKCASE7("BOOKCASE7"),BOOKCASE8("BOOKCASE8"),
        BOOKCASE12("BOOKCASE9"),BOOKCASE9("BOOKCASE10"),BOOKCASE10("BOOKCASE11"),BOOKCASE11("BOOKCASE12");

        private final String value;
        BookCaseModels(String value) {
            this.value = value;
        }

        @Override
        public String getName() {
            return value;
        }
    }

    public BookCase(BookCaseModels model,int stockCount) {
        super(stockCount);
        this.model = model;
    }

    @Override
    public String getModelName() {
        return  model.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof BookCase)) {
            return false;
        }

        BookCase rhs = (BookCase) obj;

        return model.equals(rhs.model);
    }

    final private BookCaseModels model;
}