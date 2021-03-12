package Users;

import officeFurnitures.Branch;
import officeFurnitures.Product;

public class Employee extends User {

    public Employee(String name, int id, Branch myBranch) {
        super(name, id, UserRole.EMPLOYEE);
        this.myBranch = myBranch;
    }

    public boolean makeSell(Product product,Customer customer,int count) {
        if(!removeProduct(product,count)) {
            return false;
        }

        Order order = new Order(myBranch,customer,this,product,count);
        customer.addPrevOrder(order);
        return true;
    }

    public void getUserPrevOrder(Customer customer) {
        customer.getPrevOrders();
    }

    public void addProduct(Product product, int count) {
        Product refProduct = myBranch.findFurniture(product);
        refProduct.increaseUnitInStock();
        myBranch.updateproductsNeedToBeSuplied(product,1);
    }

    public boolean removeProduct(Product product,int count) {
        Product refProduct = myBranch.findFurniture(product);
        if (refProduct == null)
            return false;
        if (refProduct.getUnitInStock() < count) {
            myBranch.updateproductsNeedToBeSuplied(refProduct, 0);
            return false;
        } else if (refProduct.getUnitInStock() == count) {
            myBranch.updateproductsNeedToBeSuplied(refProduct, 0);
        }

        refProduct.decreaseUnitInStock(count);
        return true;
    }

    public void addCustomer(Customer customer) {
        Company.addCustomer(customer);
    }

    public Branch whereIWork() {
        return myBranch;
    }

    private Branch myBranch;
}
