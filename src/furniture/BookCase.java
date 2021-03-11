package furniture;

public class BookCase extends Product {

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

    /**
     * @param color Chair Color
     */
    public BookCase(BookCaseModels model,Color color) {
        this.model = model;
        this.color = color;
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

        return model.equals(rhs.model)
                && color.equals(rhs.color);
    }

    @Override
    public Model getModel() {return model;}

    final private BookCaseModels model;
    final private Color color;
}