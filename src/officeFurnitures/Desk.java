package officeFurnitures;

/**
 * A specific furniture type Desk
 */
public class Desk extends Product {

    /**
     * Desk color as a enum values
     */
    public enum Color {
        BROWN,
        ORANGE,
        GRAY,
        GREEN,
    }

    /**
     * Enum values represent desk models
     */
    public enum DeskModels implements Model {
        DESK1("DESK1"),DESK2("DESK2"),DESK3("DESK3"),DESK4("DESK4"),DESK5("DESK5");

        private final String value;
        DeskModels(String value) {
            this.value = value;
        }

        /**
         * @return Model name as a string
         */
        @Override
        public String getName() {
            return value;
        }
    }

    /**
     * @param model Chair Model Type
     * @param color Chair Color
     */
    public Desk(DeskModels model, Color color, int stockCount) {
        super(stockCount);
        this.model = model;
        this.color = color;
    }

    /**
     * @return Color value as a string
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
     * Check equalty comparing model and color
     * @param obj Desk
     * @return true/false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Desk)) {
            return false;
        }

        Desk rhs = (Desk) obj;

        return model.equals(rhs.model)
                && color.equals(rhs.color);
    }

    /**
     * Represent model as a enum value
     */
    final DeskModels model;
    /**
     * Represent color as a enum value
     */
    private final Color color;
}
