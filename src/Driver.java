import Users.Administrators;
import Users.Company;
import Users.Customer;
import Users.Employee;
import officeFurnitures.Branch;
import officeFurnitures.Chair;
import officeFurnitures.Product;

public class Driver {
    static Administrators consoleAdminInput() {
        return Company.admins.get(0);
    }

    static Branch consoleBranchInput() {
        return Company.branches.get(0);
    }

    static Employee consoleEmployeeInput() {
        return Company.employees.get(0);
    }

    static Customer consoleCustomerInput(String inputWay) {
        if (inputWay.startsWith("First"))
            return new Customer("Hakan","Muhafiz","mail","pw",Company.getNextCustomerId());
        else
            return Company.customers.get(0);
    }

    static Product customerSelectProduct() {
        return new Chair(Chair.ChairModels.CHAIR1, Chair.Color.BLUE,12);
    }

    static Employee systemEmployeeAssign() {
        return Company.employees.get(0);
    }

    static Product consoleInputProduct() {
        return new Chair(Chair.ChairModels.CHAIR1,Chair.Color.PURPLE,12);
    }

    static void  administratorsDriver() {
        System.out.println("-----Administrator, Driver Operations Start-----");
        Administrators admin = consoleAdminInput();
        admin.addBranch();
        admin.removeBranch(consoleBranchInput());
        admin.addEmployeeToBranch(consoleBranchInput(), "HardWorker");
        admin.addEmployeeToBranch(consoleBranchInput(), "LooseWorker");
        admin.removeEmployeeFromBranch(consoleEmployeeInput());
        admin.queryProductsNeedToBeSuplied();
        System.out.println("-----Administrator, Driver Operations End-----");
    }

    static void  branchDriver() {
        System.out.println("-----Branch, Driver Operations Start-----");
        Branch branch = consoleBranchInput();
        Chair product = (Chair)branch.findFurniture(new Chair(Chair.ChairModels.CHAIR1,Chair.Color.RED,10));
        System.out.println("-----Branch, Driver Operations End-----");

    }

    static void  customerDriver(String inputWay) {
        Customer customer;
        if (inputWay.startsWith("First")) {
            System.out.println("-----Customer First Time, Driver Operations-----");
            customer = consoleCustomerInput(inputWay);
            Company.addCustomer(customer);
        } else {
            System.out.println("-----Customer Already Registered, Driver Operations-----");
            customer = consoleCustomerInput(inputWay);
            try {
                if (Company.searchCustomer(customer.getEmail(),"pw") == null)
                    throw new Exception("You need to create new customer account to log in");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        Company.listProducts();
        customer.setAdress("adress");
        customer.setPhoneNumber("phoneNumber");
        Employee employeeBySystem0 = systemEmployeeAssign();
        if(!employeeBySystem0.makeSell(customerSelectProduct(),customer,32))
            System.out.println("!!!There is no enough amount of product!!!");
        else
            System.out.println("Your order has been successfully received");

        customer.getPrevOrders();
    }

    static void  employeeDriver() {
        System.out.println("-----Employeee, Driver Operations Start-----");
        Employee employee = consoleEmployeeInput();
        employee.addProduct(consoleInputProduct(),5);
        employee.removeProduct(consoleInputProduct(),1);
        employee.makeSell(customerSelectProduct(),consoleCustomerInput("Firs Time"),3);
        employee.getUserPrevOrder(consoleCustomerInput("Already Registered"));
        System.out.println("-----Employeee, Driver Operations End-----");
    }

    static public  void run() throws Exception {
        Driver driver = new Driver();
        try {
            Company.init();
            administratorsDriver();
            branchDriver();
            customerDriver("First Time Shopping");
            customerDriver("Already Registered");
            employeeDriver();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
