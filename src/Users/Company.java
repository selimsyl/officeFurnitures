package Users;

import factory.*;
import officeFurnitures.Branch;
import officeFurnitures.Cabinet;
import officeFurnitures.Product;

public  class Company {
    static MyArray<Administrators> admins = new MyArray<Administrators>(new Administrators("admin",1));
    MyArray<Employee> employees = MyArray<Employee>(new Employee());
    MyArray<Customer> customers = MyArray<Customer>(new Customer());
    MyArray<Order> orders = MyArray<Order>(new Order());
    Branch[] branches = new Branch[4];
    private static int branchId = 0;
    private static int employeeId = 0;
    private static int adminId = 0;

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
