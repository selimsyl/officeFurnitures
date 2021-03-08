package Users;

public class Employee extends User {

    Employee(String name, int id,int branchId) {
        super(name, id, UserRole.EMPLOYEE);
    }
}
