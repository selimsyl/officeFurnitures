package Users;

import factory.ChairFactory;
import officeFurnitures.Branch;

import static Users.Company.employees;

public abstract class User {
    public enum UserRole {
        ADMIN,
        EMPLOYEE,
        CUSTOMER
    }

    User(String name,int id,UserRole role) {
        this.name = name;
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    final private String name;
    final private int id;
    final private UserRole role;
}

class Administrators extends User {
    Administrators(String name,int id) {
        super(name,id,UserRole.ADMIN);
    }

    void addBranch() {
        for (Branch branch: Company.branches) {
            if (branch == null) {
                branch = new Branch(Company.createStarterProducts(),Company.branchId++);
                return;
            }
        }

        Branch[] temp = new Branch[Company.branches.length+1];
        for (int i = 0; i < Company.branches.length;++i) {
            temp[i] = Company.branches[i];
        }

        temp[temp.length-1] = new Branch(Company.createStarterProducts(),Company.branchId++);
        Company.branches = temp;
    }

    void removeBranch(int branchId) {
        for (Branch branch:Company.branches) {
            if (branch.getBranchId() == branchId) {
                branch = null;
            }
        }
    }

    void addEmployeeToBranch(int branchId,String name) {
        for (Employee Employee: employees) {
            if (Employee == null) {
                Employee = new Employee();
                return;
            }
        }

        Employee[] temp = new Employee[employees.length+1];
        for (int i = 0; i < employees.length;++i) {
            temp[i] = employees[i];
        }

        temp[temp.length-1] = new Employee(name,Company.employeeId++,branchId);
        employees = temp;
        
    }

    void removeEmployeeFromBranch(int employeeId) {
        for (Employee employee: Company.employees) {
            if (employee.getId() == employeeId) {
                employee = null;
            }
        }
    }
}