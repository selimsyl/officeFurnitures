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

        System.out.println(company.branches.getSize());

        Employee e = new Employee("akan", Company.getNextEmployeeId(),Company.branches.get(0));

        company.employees.add(e);

        company.admins.get(0).removeBranch(new Branch(Company.createStarterProducts(),Company.getNextBranchId()));

        e.addProduct(new Chair(Chair.ChairModels.CHAIR1,Color.COLOR1,10), 1);
    }
}
