package officeFurnitures;

/**
 * A specific furniture type Desk
 */
public class Desk extends Furniture {

    public enum DeskModels implements Model {
        DESK1("DESK1"),DESK2("DESK2"),DESK3("DESK3"),DESK4("DESK4"),DESK5("DESK5");

        private final String value;
        DeskModels(String value) {
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
    public Desk(DeskModels model, String color) {
        super(model);
        this.color = color;
    }

    public DeskModels getModel() {
        return (DeskModels) model;
    }

    private String color;
}
