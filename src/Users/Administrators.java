package Users;

import officeFurnitures.Branch;
import officeFurnitures.Product;

import java.util.ListIterator;

public class Administrators extends User {
    /**
     * Ctor
     * @param name Admin name
     */
    Administrators(String name) {
        super(name,Company.getNextAdminId(),UserRole.ADMIN);
    }

    /**
     * Add a branch to system with auto assigned branch id and products for initialization
     */
    public void addBranch() {
        Branch branch = new Branch(Company.createStarterProducts(),Company.getNextBranchId());
        Company.branches.addLast(branch);
        System.out.println("Branch with id "+ branch.getBranchId() + " added to system succesfully");
    }

    /**
     * Remove branch from system if its exits
     * @param branch to be removed
     * @return true if branch is exists else false
     */
    public boolean removeBranch(Branch branch) {
        if (branch == null)
            return false;

        for (int i = 0; i < Company.employees.size(); ++i) {
            if (Company.employees.get(i).whereIWork().equals(branch)) {
                Company.employees.remove(i);
            }
        }

        if(!Company.branches.remove(branch)) {
            System.out.println("Branch doesnt exist, cant remove");
            return false;
        }

        System.out.println("Branch with id "+ branch.getBranchId() + " removed from system succesfully");
        return true;
    }

    /**
     * Create new employee and add to system
     * @param branch to add employee
     * @param name employee name
     */
    public void addEmployeeToBranch(Branch branch,String name) {
        Employee employee = new Employee(name,Company.getNextEmployeeId(), branch);
        Company.employees.add(employee);
        System.out.println("Below Employee " );
        employee.printInfo();
        System.out.println("added to Branch with id : " + branch.getBranchId() + " succesfully");
    }

    /**
     * @param employee to be removed
     */
    public void removeEmployeeFromBranch(Employee employee) {
        try {
            Company.employees.remove(Company.employees.indexOf(employee));
            System.out.println("Below Employee " );
            employee.printInfo();
            System.out.println("removed from Branch with id : " + employee.whereIWork().getBranchId() + " succesfully");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No employee to remove");
        }
//        Company.employees.remove(employee);
    }

    /**
     * query products and increase stock value +10
     */
    public void queryProductsNeedToBeSuplied() {
        System.out.println("Start of Administrator quering products that need to be supplied");
        ListIterator<Branch> iterBranch = Company.branches.listIterator();
        while(iterBranch.hasNext()) {
            Branch refBranch = iterBranch.next();
            for (int k = 0; k < refBranch.getproductsNeedToBeSuplied().getSize(); ++k){
                Product product = refBranch.getproductsNeedToBeSuplied().get(k);
                product.printProductInfo();
                product.increaseUnitInStock(10);
            }
        }

//        for (int i=0; i < Company.branches.getSize(); ++i) {
//            for (int k = 0; k < Company.branches.get(i).getproductsNeedToBeSuplied().getSize(); ++k){
//                Product product = Company.branches.get(i).getproductsNeedToBeSuplied().get(k);
//                product.printProductInfo();
//                product.increaseUnitInStock(10);
//            }
//        }
        System.out.println("End of Administrator quering products that are supplied");
    }

    /**
     * Check admin object equalty comparing names
     * @param obj admin
     * @return  true/false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Administrators)) {
            return false;
        }

        Administrators rhs = (Administrators) obj;

        return this.getName().equals(rhs.getName());
    }
}
