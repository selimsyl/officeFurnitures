package user;

public class Employee extends User {

    public Employee(String name, int id, int branchId) {
        super(name, id, UserRole.EMPLOYEE);
        this.branchId = branchId;
    }

    private int branchId;
}
