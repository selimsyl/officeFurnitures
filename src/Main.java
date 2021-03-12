//import officeFurnitures.Product.Product.Product;


import Users.*;
import officeFurnitures.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Driver driver = new Driver();
        try {
            driver.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
//        Company Company = new Company();
//
//        Company.admins.get(0).addBranch();
//        Company.admins.get(0).addEmployeeToBranch(Company.branches.get(3),"kiro");
//        Company.admins.get(0).addEmployeeToBranch(Company.branches.get(5),"hiro");
//        Company.admins.get(0).addEmployeeToBranch(Company.branches.get(1),"ziro");
//        Company.admins.get(0).removeBranch(Company.branches.get(3));
////        Company.admins.get(0).removeBranch(Company.branches.get(35));
//
//        Company.admins.get(0).removeEmployeeFromBranch(Company.employees.get(4));
//
//        Employee e = new Employee("akan", Company.getNextEmployeeId(),Company.branches.get(0));
//
//        e.addProduct(new Chair(Chair.ChairModels.CHAIR1,Color.COLOR1,10), 1);
//
//        Company.listBranches();
//
//        Company.admins.get(0).removeBranch(Company.branches.get(0));
//        Company.addCustomer(new Customer("ha","ka","mail","ow",Company.getNextCustomerId()));
//        Company.listCustomers();
//        Company.listEmployees();
    }
}
