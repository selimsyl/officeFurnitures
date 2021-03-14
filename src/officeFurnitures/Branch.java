package officeFurnitures;

import Users.Employee;
import Users.GenericArray;

public class Branch {

    /**
     * Producst stored in
     */
    Product[] products;
    /**
     * Products which have 0 unitInStock
     */
    GenericArray<Product> productsNeedToBeSuplied = new GenericArray<Product>();
    /**
     * used as default employee for online operations to help Customers
     */
    Employee onlineEmployee;

    /**
     * Unique id to identify branches in Company
     */
    final private int branchId;

    /**
     * Branch only ctor
     * @param products What products branch has
     * @param branchId uniqe branch id
     */
    public Branch(Product[] products,int branchId) {
        this.branchId = branchId;
        this.products = products;
        this.onlineEmployee = new Employee("online",0,this);
    }

    /**
     * @return return branch unique id
     */
    public int getBranchId() {
        return branchId;
    }

    /**
     * If a product is needs to be supplied it is added here to infore manager
     * @param product Product to be addet to need to be list
     * @param operation add or remove from list
     */
    public void updateproductsNeedToBeSuplied(Product product,int operation)
    {
        if (operation > 0) {//increase
            productsNeedToBeSuplied.add(product);
        } else {//decrease
            productsNeedToBeSuplied.remove(product);
        }
    }

    /**
     * @return getArray
     */
    public GenericArray<Product> getproductsNeedToBeSuplied() {
        return productsNeedToBeSuplied;
    }

    /**
     * @param furniture find product end return reference to it
     * @return
     */
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

    /**
     * list branch`s products
     */
    public void listProducts() {
        Product printedPrevProduct = null;
        System.out.println("Producst in Strore ID : " + branchId);
        for (Product product: products) {
            if (product.getUnitInStock() != 0) {
                if (printedPrevProduct != null &&
                        !product.getModelName().equals(printedPrevProduct.getModelName()))
                    System.out.println();

                System.out.print("["+product.getModelName() + "(" + product.getUnitInStock() + ")");
                String color = product.getColor();
                if (!color.equals(""))
                    System.out.print (color);

                System.out.print ("]");
                printedPrevProduct = product;
            }
        }
        System.out.println();
    }

    /**
     * check branch equalty by unique Branch id
     * @param obj branch
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Branch)) {
            return false;
        }

        Branch rhs = (Branch) obj;

        return this.branchId == rhs.getBranchId();
    }

    /**
     * @return get always exist employee to access branch product operations
     */
    public Employee getOnlineEmployee() {
        return onlineEmployee;
    }
}
