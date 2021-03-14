package Users;

public abstract class User {
    final private String name;
    final private int id;
    final private UserRole role;

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
    public UserRole getRole() {return role;}
    public String getName() {return name;}

    public void printInfo() {
        System.out.println("---User Info---");
        System.out.println("Id   : "+id);
        System.out.println("Name : "+name);
        System.out.println("UserRole : " +role.toString());
        System.out.println("---En of User Info---");
    }
}