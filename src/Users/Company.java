package Users;

import factory.*;
import officeFurnitures.Branch;
import officeFurnitures.Cabinet;
import officeFurnitures.Product;

public  class Company {
    public static GenericArray<Administrators> admins = new GenericArray<Administrators>(new Administrators("admin",1));
    public static GenericArray<Employee> employees = new GenericArray<Employee>(new Employee());
    public static GenericArray<Customer> customers = new GenericArray<Customer>(new Customer());
    public static GenericArray<Order> orders = new GenericArray<Order>(new Order());
    public static GenericArray<Branch> branches = new GenericArray<Branch>(new Branch(createStarterProducts(),branchId++));

    public static int branchId = 0;
    public static int employeeId = 0;
    public static int adminId = 0;

    public static Branch getBranch(int branchId) {
        for (Branch branch: branches) {
            if (branchId == branch.getBranchId())
                return branch;
        }
        return null;
    }

    public static Product[] createStarterProducts() {
        Factory[] factories = new Factory[]{new ChairFactory(),new DeskFactory(),
                                    new CabinetFactory(),new BookCaseFactory()};

        Product[] products = new Product[119];
        for (Factory factory : factories) {
            int index = 0;
            for (Product product:factory.createFurniture()) {
                products[index++] = product;
            }
        }
        return products;
    }

}
