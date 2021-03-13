package Users;

import factory.*;
import officeFurnitures.Branch;
import officeFurnitures.Cabinet;
import officeFurnitures.Product;

public final class Company {
    public static GenericArray<Administrators> admins;
    public static GenericArray<Customer> customers;
    public static GenericArray<Branch> branches;
    public static GenericArray<Employee> employees;

    private Company() {}

    public static void init() {
        admins = new GenericArray<Administrators>((new Administrators("admin1")));
        branches = new GenericArray<Branch>(new Branch[]{
                new Branch(createStarterProducts(),getNextBranchId()),
                new Branch(createStarterProducts(),getNextBranchId())});

        employees = new GenericArray<Employee>();
        for (int i = 0; i < branches.getSize(); ++i) {
            employees.add(new Employee("Hakan",getNextEmployeeId(),branches.get(i)));
        }
        customers =new GenericArray<Customer>(new Customer("Murat","Kala","email","pw",getNextCustomerId()));
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

    public static void listEmployees() {
        for (int i = 0; i < Company.employees.getSize(); ++i) {
            System.out.print(i + ". ");
            System.out.println(Company.employees.get(i).getName());
        }
    }

    public static void listBranches() {
        System.out.println("1 ile " + Integer.toString(Company.branches.getSize()) +
                " arasinda Branch bulunmaktadir ");
    }

    public static void listCustomers() {
        for (int i = 0; i < Company.customers.getSize(); ++i) {
            System.out.println(Company.customers.get(i).getName() +
                   " " + Company.customers.get(i).getEmail());
        }
    }

    public static void listProducts() {
        System.out.println("-----Lets Show You What We Got-----");
        for (int i = 0; i < Company.branches.getSize(); ++i) {
            Company.branches.get(i).listProducts();
        }
        System.out.println("-----End Of What We Got, You can choose What You Want-----");
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static boolean searchCustomer(Customer customer) {
        for (int i = 0; i < customers.getSize(); ++i) {
            if (customer.equals(customers.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static Product[] createStarterProducts() {
        Factory[] factories = new Factory[]{new ChairFactory(),new DeskFactory(),
                                    new CabinetFactory(),new BookCaseFactory(),new TableFactory()};

        Product[] products = new Product[119];
        int index = 0;
        for (Factory factory : factories) {
            for (Product product:factory.createFurniture()) {
                products[index++] = product;
            }
        }
        return products;
    }
}
