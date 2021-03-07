package officeFurnitures;

/**
 * Abstract main product class, all products share
 */
public abstract class Furniture {
    final String model;

    public interface Model {
        String getValue();
    }

    /**
     * @param model Furnitures Model Type
     */
    Furniture(String model) {
        this.model = model;
    }

    /**
     * @return Get furniture model
     */
    public String getModelName() {
        return model;
    }
//    public abstract Models getModel();
}
