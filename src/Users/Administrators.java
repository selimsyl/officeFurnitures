package Users;

import officeFurnitures.Branch;

public class Administrators extends User {
    Administrators(String name) {
        super(name,Company.getNextAdminId(),UserRole.ADMIN);
    }

    public void addBranch() {
        Company.branches.add(new Branch(Company.createStarterProducts(),Company.getNextBranchId()));
    }

    public void removeBranch(Branch branch) {
        Company.branches.remove(branch);
    }

    public void addEmployeeToBranch(Branch branch,String name) {
        branch.addEmployee(new Employee(name, Company.getNextEmployeeId(),branch.getBranchId()));
    }

    public void removeEmployeeFromBranch(Branch branch,Employee employee) {
        branch.removeEmployee(employee);
    }
}