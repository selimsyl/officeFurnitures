package Users;

import factory.*;
import officeFurnitures.Branch;
import officeFurnitures.Product;

public final class Company {
    /**
     * Systems admins
     */
    public static GenericArray<Administrators> admins;
    /**
     * System Customers
     */
    public static GenericArray<Customer> customers;
    /**
     * System branches
     */
    public static GenericArray<Branch> branches;
    /**
     * System employess
     */
    public static GenericArray<Employee> employees;

    /**
     * Used to give each branch to unique id
     */
    private static int branchId = 0;
    /**
     * Used to give each branch to unique id
     */
    private static int employeeId = 0;
    /**
     * Used to give each admin to unique id
     */
    private static int adminId = 0;
    /**
     * Used to give each customer to unique id
     */
    private static int customerId = 0;

    private Company() {}

    /**
     * Init company add default admin, branches, and a customer
     */
    public static void init() {
        admins = new GenericArray<Administrators>((new Administrators("admin")));
        branches = new GenericArray<Branch>(new Branch[]{
                new Branch(createStarterProducts(),getNextBranchId()),
                new Branch(createStarterProducts(),getNextBranchId())});

        employees = new GenericArray<Employee>();
        customers =new GenericArray<Customer>(new Customer("Murat","Kala","email","pw",getNextCustomerId()));
    }

    /**
     * List customer names
     */
    public static void listEmployees() {
        for (int i = 0; i < Company.employees.getSize(); ++i) {
            System.out.print(i + ". ");
            System.out.println(Company.employees.get(i).getName());
        }
    }

    /**
     * List branches unique id's
     * @return True if there is a branch in the system
     */
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

    /**
     * List customers name and email
     */
    public static void listCustomers() {
        for (int i = 0; i < Company.customers.getSize(); ++i) {
            System.out.println(Company.customers.get(i).getName() +
                   " " + Company.customers.get(i).getEmail());
        }
    }

    /**
     * List products as string formatted [Model(Amount)Color]
     */
    public static void listProducts() {
        System.out.println("-----Lets Show You What We Got-----");
        for (int i = 0; i < Company.branches.getSize(); ++i) {
            Company.branches.get(i).listProducts();
        }
        System.out.println("-----End Of What We Got, You can choose What You Want-----");
    }

    /**
     * @param customer to be added to system
     */
    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Search customer by email and password
     * @param email Customer unique email
     * @param pw    Customer pw
     * @return customer object if it is exist in sytem or null
     */
    public static Customer searchCustomer(String email,String pw) {
        return customers.get(new Customer("", "", email, pw, 0));
    }

    /**
     * @param name Admin name
     * @return admin object it if is exist in sytem or null
     */
    public static Administrators searchAdmin(String name) {
        return admins.get(new Administrators(name));
    }

    /**
     * @param name of Employee to be searched
     * @param id of employee
     * @return admin object it is exist in sytem or null
     */
    public static Employee searchEmployee(String name,int id) {
        return employees.get(new Employee(name,id,null));
    }

    /**
     * @return Unique branch id for new created branches
     */
    public static int getNextBranchId() {
        return branchId++;
    }

    public static int getExistLastBranchId() {
        return branchId;
    }

    public static int getExistEmployeeBranchId() {
        return employeeId;
    }

    /**
     * @return Unique employee id for new created branches
     */
    public static int getNextEmployeeId() {
        return employeeId++;
    }

    /**
     * @return Unique admin id for new created branches
     */
    public static int getNextAdminId() {
        return adminId++;
    }

    /**
     * @return Unique customer id for new created branches
     */
    public static int getNextCustomerId() {
        return customerId++;
    }

    /**
     * @return Product array for new created branches
     */
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
