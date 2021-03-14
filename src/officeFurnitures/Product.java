package officeFurnitures;

/**
 * Abstract main product class, all products share
 */
public abstract class Product {
    int unitInStock;

//    public abstract Model getModel();
    public abstract String getModelName();
    public abstract String getColor();

    public void printProductInfo() {
        System.out.println("---Product Info---");
        System.out.println("Model : "+getModelName());
        String color = getColor();
        if (!color.equals(""))
            System.out.println("Color : "+getColor());
        System.out.println("Stock : "+getUnitInStock());
        System.out.println("---En of Product Info---");
    }
    public Product(int stockCount) {
        this.unitInStock = stockCount;
    }

    public int getUnitInStock() {return unitInStock;}
    public void increaseUnitInStock() {++unitInStock;}
    public void increaseUnitInStock(int count) {unitInStock += count;}
    public void decreaseUnitInStock( ) {--unitInStock;}
    public void decreaseUnitInStock(int count ) {unitInStock = count > unitInStock ? 0 : count - unitInStock;}
}

