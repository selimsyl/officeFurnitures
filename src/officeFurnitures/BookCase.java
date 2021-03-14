package officeFurnitures;

public class BookCase extends Product {

    /**
     * Enum values to represent bookcase models
     */
    public enum BookCaseModels implements Model {
        BOOKCASE1("BOOKCASE1"),BOOKCASE2("BOOKCASE2"),BOOKCASE3("BOOKCASE3"),BOOKCASE4("BOOKCASE4"),
        BOOKCASE5("BOOKCASE5"),BOOKCASE6("BOOKCASE6"),BOOKCASE7("BOOKCASE7"),BOOKCASE8("BOOKCASE8"),
        BOOKCASE12("BOOKCASE9"),BOOKCASE9("BOOKCASE10"),BOOKCASE10("BOOKCASE11"),BOOKCASE11("BOOKCASE12");

        /**
         * Enum values wrap a string that represents model
         */
        private final String value;

        /**
         * private ctor
         * @param value model name
         */
        BookCaseModels(String value) {
            this.value = value;
        }

        /**
         * @return return model name as a string
         */
        @Override
        public String getName() {
            return value;
        }
    }

    /**
     * @param model
     * @param stockCount
     */
    public BookCase(BookCaseModels model,int stockCount) {
        super(stockCount);
        this.model = model;
    }

    /**
     * @return String represents model name
     */
    @Override
    public String getModelName() {
        return  model.getName();
    }

    /**
     * @return product doest have a color, although extends product class
     */
    @Override
    public String getColor() {
        return "";
    }

    /**
     * Check equalty comparing model
     * @param obj BookCase
     * @return true or false
     */
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

    /**
     * Represent model as a enum value
     */
    final private BookCaseModels model;
}