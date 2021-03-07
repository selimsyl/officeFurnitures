package officeFurnitures;

/**
 * Abstract main product class, all products share
 */
public abstract class Furniture {
    /**
     * Every furniture has a specific model
     */
    final Model model;

    /**
     * @param model Furnitures Model Type
     */
    Furniture(Model model) {
        this.model = model;
    }

    /**
     * @return Get furniture model
     */
    public abstract Model getModel();
}

/**
 * Furniture Models shares
 */
interface Model {
    String getValue();
}