package officeFurnitures;

/**
 * A specific furniture type Chair
 */
public class Chair extends Furniture {

    public enum ChairModels implements Furniture.Model {
        CHAIR1("CHAIR1"),CHAIR2("CHAIR2"),CHAIR3("CHAIR3"),
        CHAIR4("CHAIR4"),CHAIR5("CHAIR5"),CHAIR6("CHAIR6"),CHAIR7("CHAIR7");

        private final String value;
        ChairModels(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    /**
     * @param model Chair Model Type
     * @param color Chair Color
     */
    public Chair(ChairModels model, String color) {
        super(model.getValue());
        this.color = color;
    }

    private String color;
}
