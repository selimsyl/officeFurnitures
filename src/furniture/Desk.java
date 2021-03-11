package furniture;

/**
 * A specific furniture type Desk
 */
public class Desk extends Product {

    public enum DeskModels implements Model {
        DESK1("DESK1"),DESK2("DESK2"),DESK3("DESK3"),DESK4("DESK4"),DESK5("DESK5");

        private final String value;
        DeskModels(String value) {
            this.value = value;
        }

        @Override
        public String getName() {
            return value;
        }
    }

    /**
     * @param model Chair Model Type
     * @param color Chair Color
     */
    public Desk(DeskModels model, Color color) {
        super();
        this.model = model;
        this.color = color;
    }

    @Override
    public DeskModels getModel() {
        return (DeskModels) model;
    }

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

    final DeskModels model;
    private final Color color;
}
