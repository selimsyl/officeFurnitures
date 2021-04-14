package officeFurnitures;

import Users.Employee;
import Users.GenericArray;
import containers.HybridList;
import containers.KWArrayList;

import javax.sound.sampled.Port;

public class Branch {

    /**
     * Producst stored in
     */
    HybridList<Product> products;
//    Product[] products;
    /**
     * Products which have 0 unitInStock
     */
    HybridList<Product> productsNeedToBeSuplied = new HybridList<Product>();
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
    public Branch(HybridList<Product> products,int branchId) {
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
     * @return get HybridList of products to be supplied
     */
    public HybridList<Product> getproductsNeedToBeSuplied() {
        return productsNeedToBeSuplied;
    }

    /**
     * @param furniture find product end return reference to it
     * @return targetProduct or null
     */
    public Product findFurniture(Product furniture) {
        Product targetProduct = products.get(furniture);
        if(targetProduct!=null && targetProduct.getUnitInStock() > 0) {
            return targetProduct;
        }
        return null;
    }

    /**
     * list branch`s products
     */
    public void listProducts() {
        System.out.println("Producst in Strore ID : " + branchId);

        int printedCount = 1;
        KWArrayList<Product> currentProducts = new KWArrayList<Product>();
        for (int i = 0; i < products.size(); ++i) {
            Product product = products.get(i);
            if (product.getUnitInStock() != 0) {
                System.out.print("["+ product.getModelName() + "(" + product.getUnitInStock() + ")");
                String color = product.getColor();
                if (!color.equals(""))
                    System.out.print (color);

                System.out.print ("]");
                if (printedCount++ % 16 == 0) {
                    System.out.println();
                }
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
