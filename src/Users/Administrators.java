package Users;

import officeFurnitures.Branch;
import officeFurnitures.Product;

public class Administrators extends User {
    Administrators(String name) {
        super(name,Company.getNextAdminId(),UserRole.ADMIN);
    }

    public void addBranch() {
        Company.branches.add(new Branch(Company.createStarterProducts(),Company.getNextBranchId(),"Paris"));
    }

    public void removeBranch(Branch branch) {
        for (Employee employee:Company.employees.getDataArray()) {
            if (employee.whereIWork().equals(branch)){
                Company.employees.remove(employee);
            }
        }
        Company.branches.remove(branch);
    }

    public void addEmployeeToBranch(Branch branch,String name) {
        Company.employees.add(new Employee(name,Company.getNextEmployeeId(), branch));
    }

    public void removeEmployeeFromBranch(Employee employee) {
        Company.employees.remove(employee);
    }

    public void queryProductsNeedToBeSuplied() {
        for (Branch branch:Company.branches.getDataArray()) {
            for (Product product:branch.getproductsNeedToBeSuplied().getDataArray()) {
                product.increaseUnitInStock(10);
            }
        }
    }
}