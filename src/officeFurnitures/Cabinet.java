package officeFurnitures;

/**
 * A specific furniture type Cabinet
 */
public class Cabinet extends Product {

    /**
     * Enum values to represent bookcase models
     */
    public enum CabinetModels implements Model {
        CABINET1("CABINET1"),CABINET2("CABINET2"),CABINET3("CABINET3"),CABINET4("CABINET4"),
        CABINET5("CABINET5"),CABINET6("CABINET6"),CABINET7("CABINET7"),CABINET8("CABINET8"),
        CABINET12("CABINET9"),CABINET9("CABINET10"),CABINET10("CABINET11"),CABINET11("CABINET12");

        private final String modelName;
        CabinetModels(String value) {
            this.modelName = value;
        }

        /**
         * @return Model name as a string
         */
        @Override
        public String getName() {
            return modelName;
        }
    }

    /**
     * @param model Chair Model Type
     */
    public Cabinet(CabinetModels model,int stockCount) {
        super(stockCount);
        this.model = model;
    }

    /**
     * @return color of product
     */
    @Override
    public String getColor() {
        return "";
    }

    /**
     * @return String name of a product
     */
    @Override
    public String getModelName() {
        return  model.getName();
    }

    /**
     * Check equalty comparing model
     * @param obj Cabinet
     * @return true/false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Cabinet)) {
            return false;
        }

        Cabinet rhs = (Cabinet) obj;

        return model.equals(rhs.model);
    }

    /**
     * Represent model as a enum value
     */
    final CabinetModels model;
}
