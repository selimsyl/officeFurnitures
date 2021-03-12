package officeFurnitures;

/**
 * Abstract main product class, all products share
 */
public abstract class Product {
    int unitInStock;

//    public abstract Model getModel();
    public abstract String getModelName();

    public Product(int stockCount) {
        this.unitInStock = stockCount;
    }

    public int getUnitInStock() {return unitInStock;}
    public void increaseUnitInStock() {++unitInStock;}
    public void increaseUnitInStock(int count) {unitInStock += count;}
    public void decreaseUnitInStock( ) {--unitInStock;}
    public void decreaseUnitInStock(int count ) {unitInStock = count > unitInStock ? 0 : count - unitInStock;}
}

