package officeFurnitures;

/**
 * A specific furniture type BookCase
 */
public class BookCase extends Furniture {

    public enum BookCaseModels implements Model {
        BOOKCASE1("BOOKCASE1"),BOOKCASE2("BOOKCASE2"),BOOKCASE3("BOOKCASE3"),BOOKCASE4("BOOKCASE4"),
        BOOKCASE5("BOOKCASE5"),BOOKCASE6("BOOKCASE6"),BOOKCASE7("BOOKCASE7"),BOOKCASE8("BOOKCASE8"),
        BOOKCASE12("BOOKCASE9"),BOOKCASE9("BOOKCASE10"),BOOKCASE10("BOOKCASE11"),BOOKCASE11("BOOKCASE12");

        private final String value;
        BookCaseModels(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    /**
     * @param model Chair Model Type
     */
    public BookCase(BookCaseModels model) {
        super(model);
    }

    public BookCaseModels getModel() {
        return (BookCaseModels) model;
    }
}
