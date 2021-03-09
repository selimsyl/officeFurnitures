package officeFurnitures;


public class Branch {
    Product[] products;

    public Branch(Product[] products,int branchId) {
        this.branchId = branchId;
    }

    Product findFurniture(Product furniture) {
        for (Product kik : products) {
            if(kik.getUnitInStock() > 0) {
                if (furniture.equals(kik)) {
                    return kik;
                }
            }
        }
        return null;
    }

    final private int branchId;

    public int getBranchId() {
        return branchId;
    }
}
