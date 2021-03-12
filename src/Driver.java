import Users.Administrators;
import Users.Company;
import Users.Customer;
import Users.Employee;
import officeFurnitures.Branch;
import officeFurnitures.Chair;
import officeFurnitures.Color;
import officeFurnitures.Product;

public class Driver {
    Administrators consoleAdminInput() {
        return Company.admins.get(0);
    }

    Branch consoleBranchInput() {
        return Company.branches.get(0);
    }

    Employee consoleEmployeeInput() {
        return Company.employees.get(0);
    }

    Customer consoleCustomerInput(String inputWay) {
        if (inputWay.startsWith("First"))
            return new Customer("n1","sn1","mail","pw",Company.getNextCustomerId());
        else
            return Company.customers.get(0);
    }

    Product customerSelectProduct() {
        return new Chair(Chair.ChairModels.CHAIR1, Chair.Color.COLOR3,12);
    }

    Employee systemEmployeeAssign() {
        return Company.employees.get(0);
    }

    Product consoleInputProduct() {
        return new Chair(Chair.ChairModels.CHAIR1,Chair.Color.COLOR3,12);
    }

    void administratorsDriver() {
        Administrators admin = consoleAdminInput();
        for (int i = 0; i < 3; ++i)
            admin.addBranch();

//        admin.removeBranch(consoleBranchInput());

        admin.addEmployeeToBranch(consoleBranchInput(), "HardWorker");
        admin.addEmployeeToBranch(consoleBranchInput(), "LooseWorker");
//        admin.removeEmployeeFromBranch(consoleEmployeeInput());
//        admin.removeBranch(consoleBranchInput());

        admin.queryProductsNeedToBeSuplied();
    }

    void branchDriver() {
        Branch branch = consoleBranchInput();
        Chair product = (Chair)branch.findFurniture(new Chair(Chair.ChairModels.CHAIR1,Chair.Color.COLOR1,10));
        System.out.println(product.getModelName());
    }

    void customerDriver(String inputWay) {
        Customer customer;
        if (inputWay.startsWith("First")) {
            customer = consoleCustomerInput(inputWay);
            company.addCustomer(customer);
        } else {
            customer = consoleCustomerInput(inputWay);
            try {
                if (company.searchCustomer(customer))
                    throw new Exception("Kayitli degilsiniz, kayit olunuz");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        company.listProducts();
        customer.setAdress("adress");
        customer.setPhoneNumber("phoneNumber");
        Employee employeeBySystem0 = systemEmployeeAssign();
        employeeBySystem0.makeSell(customerSelectProduct(),customer,10);
        customer.getPrevOrders();
    }

    void employeeDriver() {
        Employee employee = consoleEmployeeInput();
        employee.addProduct(consoleInputProduct(),5);
        employee.removeProduct(consoleInputProduct(),1);
        employee.makeSell(customerSelectProduct(),consoleCustomerInput("Firs Time"),3);
        employee.getUserPrevOrder(consoleCustomerInput("Already Registered"));
    }

    public void run() throws Exception {
        company = new Company();
        administratorsDriver();
        branchDriver();
        customerDriver("First Time Shopping");
        customerDriver("Already Registered");

//        employeeDriver();

    }

    Company company;
}
