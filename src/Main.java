//import officeFurnitures.Product.Product.Product;


import user.Company;
import user.Employee;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();
        company.admins.get(0).addBranch();
        System.out.println(company.branches.getSize());
        company.branches.get(0).addEmployee(new Employee("akan", Company.getNextEmployeeId(),Company.getNextBranchId()));
//        company.admins.get(0).removeBranch(new Branch(Company.createStarterProducts(),Company.getNextBranchId()));


    }
}
