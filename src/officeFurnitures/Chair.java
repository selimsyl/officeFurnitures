package officeFurnitures;

/**
 * A specific furniture type Chair
 */
public class Chair extends Product {

    public enum Color {
        BLUE,
        PURPLE,
        RED,
        BLACK,
        YELLOW,
    }

    public enum ChairModels implements Model {
        CHAIR1("CHAIR1"),CHAIR2("CHAIR2"),CHAIR3("CHAIR3"),
        CHAIR4("CHAIR4"),CHAIR5("CHAIR5"),CHAIR6("CHAIR6"),CHAIR7("CHAIR7");

        private final String modelName;
        ChairModels(String modelName) {
            this.modelName = modelName;
        }

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

    @Override
    public String getModelName() {
        return  model.getName();
    }

    @Override
    public String getColor() {
        return color.toString();
    }

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

    private final ChairModels model;
    private final Color color;
}
