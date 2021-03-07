package officeFurnitures;

/**
 * A specific furniture type Table
 */
public class Table extends Furniture {

    public enum TableModels implements Furniture.Model {
        TABLE1("TABLE1"),TABLE2("TABLE2"),TABLE3("TABLE3"),TABLE4("TABLE4"),TABLE5("TABLE5"),
        TABLE6("TABLE6"),TABLE7("TABLE7"),TABLE8("TABLE8"),TABLE9("TABLE9"),TABLE10("TABLE10");

        private final String value;
        TableModels(String value) {
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
    public Table(TableModels model, String color) {
        super(model.getValue());
        this.color = color;
    }

    private String color;
}
