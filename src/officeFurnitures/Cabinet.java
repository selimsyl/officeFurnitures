package officeFurnitures;

/**
 * A specific furniture type Cabinet
 */
public class Cabinet extends Furniture {
    public enum CabinetModels implements Furniture.Model {
        CABINET1("CABINET1"),CABINET2("CABINET2"),CABINET3("CABINET3"),CABINET4("CABINET4"),
        CABINET5("CABINET5"),CABINET6("CABINET6"),CABINET7("CABINET7"),CABINET8("CABINET8"),
        CABINET12("CABINET9"),CABINET9("CABINET10"),CABINET10("CABINET11"),CABINET11("CABINET12");

        private final String value;
        CabinetModels(String value) {
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
    public Cabinet(CabinetModels model) {
        super(model.getValue());
    }
}
