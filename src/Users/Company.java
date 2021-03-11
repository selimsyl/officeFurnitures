package Users;

import factory.*;
import officeFurnitures.Branch;
import officeFurnitures.Cabinet;
import officeFurnitures.Product;

public  class Company {
    public static GenericArray<Administrators> admins;// = new GenericArray<Administrators>();
    public static GenericArray<Customer> customers;// = new GenericArray<Customer>();
    public static GenericArray<Branch> branches;// = new GenericArray<Branch>();
    public static GenericArray<Employee> employees;

    public Company() {
        admins = new GenericArray<Administrators>((new Administrators("admin1")));
        branches = new GenericArray<Branch>(new Branch[]{
            new Branch(createStarterProducts(),getNextBranchId()),
            new Branch(createStarterProducts(),getNextBranchId()),
            new Branch(createStarterProducts(),getNextBranchId()),
            new Branch(createStarterProducts(),getNextBranchId())});

        employees = new GenericArray<Employee>();
        for (int i = 0; i < branches.getSize(); ++i) {
            employees.add(new Employee("akan",getNextEmployeeId(),branches.get(i)));
        }
    }

    private static int branchId = 0;
    private static int employeeId = 0;
    private static int adminId = 0;
    private static int customerId = 0;

    public static int getNextBranchId() {
        return branchId++;
    }

    public static int getNextEmployeeId() {
        return employeeId++;
    }

    /**
     * @return
     */
    public static int getNextAdminId() {
        return adminId++;
    }

    public static int getNextCustomerId() {
        return customerId++;
    }

    public void listEmployees() {

    }

    public void listBranches() {

    }

    public void listCustomers() {

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
