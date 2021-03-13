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

    private static int branchId = 0;
    private static int employeeId = 0;
    private static int adminId = 0;
    private static int customerId = 0;

    private Company() {}

    public static void init() {
        admins = new GenericArray<Administrators>((new Administrators("admin")));
        branches = new GenericArray<Branch>(new Branch[]{
                new Branch(createStarterProducts(),getNextBranchId()),
                new Branch(createStarterProducts(),getNextBranchId())});

        employees = new GenericArray<Employee>();
        for (int i = 0; i < branches.getSize(); ++i) {
            employees.add(new Employee("Hakan",getNextEmployeeId(),branches.get(i)));
        }
        customers =new GenericArray<Customer>(new Customer("Murat","Kala","email","pw",getNextCustomerId()));
    }

    public static void listEmployees() {
        for (int i = 0; i < Company.employees.getSize(); ++i) {
            System.out.print(i + ". ");
            System.out.println(Company.employees.get(i).getName());
        }
    }

    public static boolean listBranches() {
        if (Company.branches.getSize() == 0) {
            System.out.println("There is no branch in company");
            return false;
        }

        Object[] branch = Company.branches.getDataArray();

        for (int i = 0; i < Company.branches.getSize(); ++i) {
            if (i!=0 && i % 16 == 0) {
                System.out.println();
            }
            System.out.print(((Branch)branch[i]).getBranchId() + " ");
        }
        System.out.println();
        return true;
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

    public static Customer searchCustomer(String email,String pw) {
        return customers.get(new Customer("", "", email, pw, 0));
    }

    public static Administrators searchAdmin(String name) {
        return admins.get(new Administrators(name));
//        for (int i = 0; i < admins.getSize(); ++i) {
//            if (name.equals(admins.get(i).getName())) {
//                return true;
//            }
//        }
//        return false;
    }

    public static Employee searchEmployee(String name,int id) {
        return employees.get(new Employee(name,id,null));
//        for (int i = 0; i < admins.getSize(); ++i) {
//            if (name.equals(admins.get(i).getName())) {
//                return true;
//            }
//        }
//        return false;
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
}
