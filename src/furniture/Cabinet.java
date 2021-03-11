package furniture;

/**
 * A specific furniture type Cabinet
 */
public class Cabinet extends Product {

    public enum CabinetModels implements Model {
        CABINET1("CABINET1"),CABINET2("CABINET2"),CABINET3("CABINET3"),CABINET4("CABINET4"),
        CABINET5("CABINET5"),CABINET6("CABINET6"),CABINET7("CABINET7"),CABINET8("CABINET8"),
        CABINET12("CABINET9"),CABINET9("CABINET10"),CABINET10("CABINET11"),CABINET11("CABINET12");

        private final String modelName;
        CabinetModels(String value) {
            this.modelName = value;
        }

        @Override
        public String getName() {
            return modelName;
        }
    }

    /**
     * @param model Chair Model Type
     */
    public Cabinet(CabinetModels model) {
        this.model = model;
    }

    @Override
    public CabinetModels getModel() {
        return model;
    }

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

    final public CabinetModels model;
}
