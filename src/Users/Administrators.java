package Users;

import officeFurnitures.Branch;
import officeFurnitures.Product;

public class Administrators extends User {
    Administrators(String name) {
        super(name,Company.getNextAdminId(),UserRole.ADMIN);
    }

    public void addBranch() {
        Company.branches.add(new Branch(Company.createStarterProducts(),Company.getNextBranchId()));
    }

    public void removeBranch(Branch branch) {
        for (int i = 0; i < Company.employees.getSize(); ++i) {
            if (Company.employees.get(i).whereIWork().equals(branch)){
                Company.employees.remove(Company.employees.get(i));
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
        for (int i=0; i < Company.branches.getSize(); ++i) {
            for (int k = 0; k < Company.branches.get(i).getproductsNeedToBeSuplied().getSize(); ++k){
                Company.branches.get(i).getproductsNeedToBeSuplied().get(k).increaseUnitInStock(10);
            }

        }
    }
}