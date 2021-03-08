package officeFurnitures;

/**
 * A specific furniture type Table
 */
class Table extends Product {

    public enum TableModels implements Model {
        TABLE1("TABLE1"),TABLE2("TABLE2"),TABLE3("TABLE3"),TABLE4("TABLE4"),TABLE5("TABLE5"),
        TABLE6("TABLE6"),TABLE7("TABLE7"),TABLE8("TABLE8"),TABLE9("TABLE9"),TABLE10("TABLE10");

        private final String value;
        TableModels(String value) {
            this.value = value;
        }

        @Override
        public String getName() {
            return value;
        }
    }

    /**
     * @param model Chair Model Type
     */
    public Table(TableModels model, String color) {
        super();
        this.color = color;
        this.model = model;
    }

    @Override
    public TableModels getModel() {
        return model;
    }

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

    final TableModels model;
    private final String color;
}
