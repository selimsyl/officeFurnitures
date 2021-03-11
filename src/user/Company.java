package user;

import factory.*;
import furniture.Branch;
import furniture.Product;

public  class Company {
    public static GenericArray<Administrators> admins;// = new GenericArray<Administrators>();
    public static GenericArray<Customer> customers;// = new GenericArray<Customer>();
    public static GenericArray<Order> orders;// = new GenericArray<Order>();
    public static GenericArray<Branch> branches;// = new GenericArray<Branch>();

    public Company() {
        admins = new GenericArray<Administrators>((new Administrators("admin1")));
        branches = new GenericArray<Branch>(new Branch[]{
            new Branch(createStarterProducts(),getNextBranchId()),
            new Branch(createStarterProducts(),getNextBranchId()),
            new Branch(createStarterProducts(),getNextBranchId()),
            new Branch(createStarterProducts(),getNextBranchId())});
    }

    private static int branchId = 0;
    private static int employeeId = 0;
    private static int adminId = 0;

    public static int getNextBranchId() {
        return branchId++;
    }

    public static int getNextEmployeeId() {
        return employeeId++;
    }

    public static int getNextAdminId() {
        return adminId++;
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
