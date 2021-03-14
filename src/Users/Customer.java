package Users;

public class Customer extends User {
    private String surname,email,password;
    private String adress,phoneNumber;
    private int customerId;

    GenericArray<Order> prevOrders;

    public Customer(String name,String surname,String email,String password,int customerId) {
        super(name,customerId,UserRole.CUSTOMER);
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.customerId = customerId;
        this.prevOrders = new GenericArray<Order>();
    }

    public void getPrevOrders() {
        if (prevOrders.getSize() == 0) {
            System.out.println("There is no previous orders");
            return;
        }

        for(int i = 0; i < prevOrders.getSize(); ++i) {
            prevOrders.get(i).printInfo();
        }
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addPrevOrder(Order order) {
        prevOrders.add(order);
        System.out.println("Below Order ");
        order.printInfo();
        System.out.println("added to customer previous orders");
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Customer)) {
            return false;
        }

        Customer rhs = (Customer) obj;

        return email.equals(rhs.email)
                && password.equals(rhs.password);
    }

}

