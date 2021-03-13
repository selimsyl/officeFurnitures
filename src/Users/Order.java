package Users;

import officeFurnitures.Branch;
import officeFurnitures.Product;

public class Order {
    public Order(Branch myBranch, Customer customer, Employee employee, Product product, int count) {
        this.branch = myBranch;
        this.customer = customer;
        this.employee = employee;
        this.product = product;
        this.productCount = count;
    }

    public void printInfo() {
        System.out.println("------------Order Info------------");
        product.printProductInfo();
        System.out.println("------------En of Order Info------------");
    }
    Branch branch;
    Customer customer;
    Employee employee;
    Product product;
    int productCount;
}
