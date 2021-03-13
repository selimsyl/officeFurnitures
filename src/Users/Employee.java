package Users;

import officeFurnitures.Branch;
import officeFurnitures.Chair;
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
        System.out.println("Employee succesfully made a sell to " + customer.getName());
        return true;
    }

    public void getUserPrevOrder(Customer customer) {
        System.out.println("Employee listing " + customer.getName() + " previous products");
        customer.getPrevOrders();
    }

    public void addProduct(Product product, int count) {
        Product refProduct = myBranch.findFurniture(product);
        refProduct.increaseUnitInStock();
        myBranch.updateproductsNeedToBeSuplied(product,1);
        System.out.println("Employee Succesfully added below prodoct");
        product.printProductInfo();
        System.out.println("to Work Branch");
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
        System.out.println("Employee succesfully removed below prodoct");
        product.printProductInfo();
        refProduct.decreaseUnitInStock(count);
        System.out.println("from Work Branch");

        return true;
    }

    public void inquireProducts() {
        System.out.println("Listing products need to be suplied");
        for(int i = 0; i < myBranch.getproductsNeedToBeSuplied().getSize(); ++i) {
            Product product = myBranch.getproductsNeedToBeSuplied().get(i);
            product.printProductInfo();
        }
        System.out.println("Employee inquried producst");
    }

    public void addCustomer(Customer customer) {
        Company.addCustomer(customer);
        System.out.println("Employee succesfully added below customer");
        customer.printInfo();
        System.out.println("to system");
    }

    public Branch whereIWork() {
        return myBranch;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee rhs = (Employee) obj;

        return this.getId() == (rhs.getId())
                && getName().equals(rhs.getName());
    }

    private Branch myBranch;
}
