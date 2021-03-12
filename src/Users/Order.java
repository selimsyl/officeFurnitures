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

    public void print() {
        System.out.println("------------Order Info------------");
        System.out.println(product.getModelName());
        System.out.println(productCount);
        System.out.println("------------Order Info------------");
    }
    Branch branch;
    Customer customer;
    Employee employee;
    Product product;
    int productCount;
}
