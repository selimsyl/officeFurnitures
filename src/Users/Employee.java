package Users;

import officeFurnitures.Branch;
import officeFurnitures.Chair;
import officeFurnitures.Product;

public class Employee extends User {

    public Employee(String name, int id, Branch myBranch) {
        super(name, id, UserRole.EMPLOYEE);
        this.myBranch = myBranch;
    }

    public boolean makeSell(Product product,Customer customer) {
        if(!removeProduct(product)) {
            return false;
        }

        Order order = new Order(myBranch,customer,this,product,product.getUnitInStock());
        customer.addPrevOrder(order);
        if (!getName().equals("online"))
            System.out.println("Employee succesfully made a sell to " + customer.getName());
        return true;
    }

    public void getUserPrevOrder(Customer customer) {
        System.out.println("Employee listing " + customer.getName() + " previous products");
        customer.getPrevOrders();
    }

    public void addProduct(Product product) {
        Product refProduct = myBranch.findFurniture(product);
        refProduct.increaseUnitInStock(product.getUnitInStock());
        myBranch.updateproductsNeedToBeSuplied(product,1);
        System.out.println("Employee Succesfully added below prodoct");
        product.printProductInfo();
        System.out.println("to Work Branch");
    }

    public boolean removeProduct(Product product) {
        Product refProduct = myBranch.findFurniture(product);
        if (refProduct == null)
            return false;
        if (refProduct.getUnitInStock() < product.getUnitInStock()) {
            myBranch.updateproductsNeedToBeSuplied(refProduct, 1);
            return false;
        } else if (refProduct.getUnitInStock() == product.getUnitInStock()) {
            myBranch.updateproductsNeedToBeSuplied(refProduct, 1);
        }
        if (!getName().equals("online")) {
            System.out.println("Employee succesfully removed below prodoct");
            product.printProductInfo();
            System.out.println("from Work Branch");
        }
        refProduct.decreaseUnitInStock(product.getUnitInStock());

        return true;
    }

    public void inquireProducts() {
        System.out.println("Listing products need to be suplied");
        for(int i = 0; i < myBranch.getproductsNeedToBeSuplied().size(); ++i) {
            Product product = myBranch.getproductsNeedToBeSuplied().get(i);
            product.printProductInfo();
        }
        System.out.println("Employee inquried products");
        System.out.println("Employee informed manager");
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

        return this.getId() == (rhs.getId());
//                && getName().equals(rhs.getName());
    }

    private Branch myBranch;
}
