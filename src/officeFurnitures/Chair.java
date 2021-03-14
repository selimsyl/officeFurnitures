package officeFurnitures;

/**
 * A specific furniture type Chair
 */
public class Chair extends Product {

    /**
     * Chair color enum values
     */
    public enum Color {
        BLUE,
        PURPLE,
        RED,
        BLACK,
        YELLOW,
    }

    /**
     * Enum values represent chair models
     */
    public enum ChairModels implements Model {
        CHAIR1("CHAIR1"),CHAIR2("CHAIR2"),CHAIR3("CHAIR3"),
        CHAIR4("CHAIR4"),CHAIR5("CHAIR5"),CHAIR6("CHAIR6"),CHAIR7("CHAIR7");

        /**
         * Enum value wraps a string that represent model name
         */
        private final String modelName;
        ChairModels(String modelName) {
            this.modelName = modelName;
        }

        /**
         * @return model name as a string
         */
        @Override
        public String getName() {
            return modelName;
        }
    }

    public Chair(ChairModels model, Color color,int stockCount) {
        super(stockCount);
        this.model = model;
        this.color = color;
    }

    /**
     * @return Model name as a string
     */
    @Override
    public String getModelName() {
        return  model.getName();
    }

    /**
     * @return Color as a string
     */
    @Override
    public String getColor() {
        return color.toString();
    }

    /**
     * Check equalty comparing model and colo
     * @param obj Chair
     * @return true/false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Chair)) {
            return false;
        }

        Chair rhs = (Chair) obj;

        return model.equals(rhs.model)
                && color.equals(rhs.color);
    }

    /**
     * Represent model as a enum value
     */
    private final ChairModels model;
    /**
     * Represent color as a enum value
     */
    private final Color color;
}
