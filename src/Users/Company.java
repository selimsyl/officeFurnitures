package Users;

import factory.*;
import officeFurnitures.Branch;
import officeFurnitures.Cabinet;
import officeFurnitures.Product;

public  class Company {
    static MyArray<Administrators> admins = new MyArray<Administrators>();
    static Employee[] employees = new Employee[4];
    static Customer[] customer = new Customer[4];
    static Branch[] branches = new Branch[4];
    static Order[] orders;
    static int branchId = 0;
    static int employeeId = 0;
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
