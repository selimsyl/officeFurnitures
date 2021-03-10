//import officeFurnitures.Product.Product.Product;


import Users.Company;
import Users.Employee;
import Users.User;
import officeFurnitures.*;

import java.lang.reflect.Array;

interface Modelo {
    String getValue();
}

public class Main {

    public static void main(String[] args) {
        Company company = new Company();
        company.admins.get(0).addBranch();
        company.branches.get(4).addEmployee(new Employee("akan", Company.getNextEmployeeId(),Company.getNextBranchId()));
//        company.admins.get(0).removeBranch(new Branch(Company.createStarterProducts(),Company.getNextBranchId()));


    }
}
