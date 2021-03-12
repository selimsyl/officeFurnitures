package officeFurnitures;


import Users.Company;
import Users.Employee;
import Users.GenericArray;

public class Branch {
    Product[] products;
    GenericArray<Product> productsNeedToBeSuplied = new GenericArray<Product>();

    public Branch(Product[] products,int branchId) {
        this.branchId = branchId;
        this.products = products;
    }

    public Product findFurniture(Product furniture) {
        for (Product product : products) {
            if(product.getUnitInStock() > 0) {
                if (furniture.equals(product)) {
                    return product;
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
        System.out.println("Producst in Strore ID : " + branchId);
        for (Product product: products) {
//            System.out.println(product.getUnitInStock());
            if (product.getUnitInStock() != 0)
                System.out.println(product.getModelName());
        }
    }

    public int getProductCount() {
        return products.length;
    }

    final private int branchId;
}
