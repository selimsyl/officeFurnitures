package officeFurnitures;

/**
 * A specific furniture type Table
 */
public class Table extends Product {

    /**
     * Chair color enum values
     */
    public enum Color {
        WHITE,
        BLACK,
        PINK,
        OLIVE,
    }

    /**
     * Enum values represent chair models
     */
    public enum TableModels implements Model {
        TABLE1("TABLE1"),TABLE2("TABLE2"),TABLE3("TABLE3"),TABLE4("TABLE4"),TABLE5("TABLE5"),
        TABLE6("TABLE6"),TABLE7("TABLE7"),TABLE8("TABLE8"),TABLE9("TABLE9"),TABLE10("TABLE10");

        /**
         * Enum value wraps a string that represent model name
         */
        private final String value;
        TableModels(String value) {
            this.value = value;
        }

        /**
         * @return model name as a string
         */
        @Override
        public String getName() {
            return value;
        }
    }

    /**
     * @param model Chair Model Type
     */
    public Table(TableModels model, Color color,int stockCount) {
        super(stockCount);
        this.color = color;
        this.model = model;
    }

    /**
     * @return Color as a string
     */
    @Override
    public String getColor() {
        return color.toString();
    }

    /**
     * @return Model name as a string
     */
    @Override
    public String getModelName() {
        return  model.getName();
    }

    /**
     * Check equalty comparing model and colo
     * @param obj Table
     * @return true/false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Table)) {
            return false;
        }

        Table rhs = (Table) obj;

        return model.equals(rhs.model)
                && color.equals(rhs.color);
    }

    /**
     * Represent model as a enum value
     */
    final TableModels model;
    /**
     * Represent color as a enum value
     */
    private final Color color;
}
