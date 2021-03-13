package Users;

import officeFurnitures.Branch;
import officeFurnitures.Product;

public class Administrators extends User {
    Administrators(String name) {
        super(name,Company.getNextAdminId(),UserRole.ADMIN);
    }

    public void addBranch() {
        Branch branch = new Branch(Company.createStarterProducts(),Company.getNextBranchId());
        Company.branches.add(branch);
        System.out.println("Branch with id "+ branch.getBranchId() + " added to system succesfully");
    }

    public void removeBranch(Branch branch) {
        for (int i = 0; i < Company.employees.getSize(); ++i) {
            if (Company.employees.get(i).whereIWork().equals(branch)){
                Company.employees.remove(Company.employees.get(i));
            }
        }
        Company.branches.remove(branch);
        System.out.println("Branch with id "+ branch.getBranchId() + " removed from system succesfully");
    }

    public void addEmployeeToBranch(Branch branch,String name) {
        Employee employee = new Employee(name,Company.getNextEmployeeId(), branch);
        Company.employees.add(employee);
        System.out.println("Below Employee " );
        employee.printInfo();
        System.out.println("added to Branch with id : " + branch.getBranchId() + " succesfully");
    }

    public void removeEmployeeFromBranch(Employee employee) {
        Company.employees.remove(employee);
        System.out.println("Below Employee " );
        employee.printInfo();
        System.out.println("removed from Branch with id : " + employee.whereIWork().getBranchId() + " succesfully");
    }

    public void queryProductsNeedToBeSuplied() {
        System.out.println("Start of Administrator quering products that need to be supplied");
        for (int i=0; i < Company.branches.getSize(); ++i) {
            for (int k = 0; k < Company.branches.get(i).getproductsNeedToBeSuplied().getSize(); ++k){
                Product product = Company.branches.get(i).getproductsNeedToBeSuplied().get(k);
                product.printProductInfo();
                product.increaseUnitInStock(10);
            }
        }
        System.out.println("End of Administrator quering products that need to be supplied");
    }
}