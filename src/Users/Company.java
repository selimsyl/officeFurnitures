package Users;

import containers.HybridList;
import containers.KWArrayList;
import containers.KWLinkedList;
import factory.*;
import officeFurnitures.Branch;
import officeFurnitures.Product;

import java.util.ListIterator;

public final class Company {
    /**
     * Systems admins
     */
    public static KWArrayList<Administrators> admins;

//    public static GenericArray<Administrators> admins;
    /**
     * System Customers
     */
    public static KWArrayList<Customer> customers;
    /**
     * System branches
     */
    public static KWLinkedList<Branch> branches;

//    public static GenericArray<Branch> branches;
    /**
     * System employess
     */
    public static KWArrayList<Employee> employees;

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

        admins = new KWArrayList<Administrators>();
        admins.add(new Administrators("admin"));

        branches = new KWLinkedList<Branch>();
        branches.addLast(new Branch(createStarterProducts(),getNextBranchId()));
        branches.addLast(new Branch(createStarterProducts(),getNextBranchId()));

        employees = new KWArrayList<Employee>();
        customers =new KWArrayList<Customer>();
        customers.add(new Customer("Murat","Kala","email","pw",getNextCustomerId()));
    }

    /**
     * List customer names
     */
    public static void listEmployees() {
        for (int i = 0; i < Company.employees.size(); ++i) {
            System.out.print(i + ". ");
            System.out.println(Company.employees.get(i).getName());
        }
    }

    /**
     * List branches unique id's
     * @return True if there is a branch in the system
     */
    public static boolean listBranches() {
        if (Company.branches.size() == 0) {
            System.out.println("There is no branch in company");
            return false;
        }

        ListIterator<Branch> iterBranch = branches.listIterator();

        System.out.println("--------Current Branches---------");
        while(iterBranch.hasNext()) {
            Branch refBranch = iterBranch.next();
            System.out.println("Branch with id : "+refBranch.getBranchId());
        }
        System.out.println("--------Current Branches End---------");
        System.out.println();

        return true;
    }

    /**
     * List customers name and email
     */
    public static void listCustomers() {
        for (int i = 0; i < Company.customers.size(); ++i) {
            System.out.println(Company.customers.get(i).getName() +
                   " " + Company.customers.get(i).getEmail());
        }
    }

    /**
     * List products as string formatted [Model(Amount)Color]
     */
    public static void listProducts() {
        System.out.println("-----Lets Show You What We Got-----");
        ListIterator<Branch> iterBranch = branches.listIterator();
        while(iterBranch.hasNext()) {
            Branch refBranch = iterBranch.next();
            refBranch.listProducts();
        }
        System.out.println("-----End Of What We Got, You can choose Which You Desire-----");
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
        Customer targetCustomer = new Customer("", "", email, pw, 0);
        try {
            return customers.get(customers.indexOf(targetCustomer));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * @param name Admin name
     * @return admin object it if is exist in system or null
     */
    public static Administrators searchAdmin(String name) {
        Administrators targetAdmin = new Administrators(name);
        try {
            return admins.get(admins.indexOf(targetAdmin));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * @param name of Employee to be searched
     * @param id of employee
     * @return admin object it is exist in sytem or null
     */
    public static Employee searchEmployee(String name,int id) {
        Employee targetEmployee = new Employee(name,id,null);
        try {
            return employees.get(employees.indexOf(targetEmployee));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
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
    public static HybridList createStarterProducts() {
        Factory[] factories = new Factory[]{new ChairFactory(),new DeskFactory(),
                new CabinetFactory(),new BookCaseFactory(),new TableFactory()};

        HybridList<Product> products = new HybridList<Product>();
        for (Factory factory : factories) {
            for (Product product:factory.createFurniture()) {
                products.add(product);
            }
        }
        return products;
    }
}
