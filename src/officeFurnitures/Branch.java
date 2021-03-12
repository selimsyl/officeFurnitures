package officeFurnitures;


import Users.Company;
import Users.Employee;
import Users.GenericArray;

public class Branch {
    Product[] products;
    GenericArray<Product> productsNeedToBeSuplied = new GenericArray<Product>();

    public Branch(Product[] products,int branchId,String branchName) {
        this.branchId = branchId;
        this.products = products;
        this.branchName = branchName;
    }

    public Product findFurniture(Product furniture) {
        for (Product kik : products) {
            if(kik.getUnitInStock() > 0) {
                if (furniture.equals(kik)) {
                    return kik;
                }
            }
        }
        return null;
    }

    public int getBranchId() {
        return branchId;
    }

    public void updateproductsNeedToBeSuplied(Product product,int operation)
    {
        if (operation > 0) {//increase
            productsNeedToBeSuplied.add(product);
        } else {//decrease
            productsNeedToBeSuplied.remove(product);
        }
    }

    public GenericArray<Product> getproductsNeedToBeSuplied() {
        return productsNeedToBeSuplied;
    }

    public void listProducts() {

    }

    public String getBranchName() {
        return branchName;
    }

    final private int branchId;
    final String branchName;
}
