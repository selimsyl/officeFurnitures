package officeFurnitures;


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

    public int getProductCount() {
        return products.length;
    }

    final private int branchId;
}
