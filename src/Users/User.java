package Users;

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
    public UserRole getRole() {return role;}
    public String getName() {return name;}

    final private String name;
    final private int id;
    final private UserRole role;
}