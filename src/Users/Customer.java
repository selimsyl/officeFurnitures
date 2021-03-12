package Users;

import officeFurnitures.Chair;
import officeFurnitures.Product;

public class Customer extends User {
    String surname,email,password;
    private String adress,phoneNumber;
    int customerId;

    GenericArray<Order> prevOrders;

    public Customer(String name,String surname,String email,String password,int customerId) {
        super(name,customerId,UserRole.CUSTOMER);
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.customerId = customerId;
        this.prevOrders = new GenericArray<Order>();
        informCustomerWelcome();
    }

    public void getPrevOrders() {
        for(int i = 0; i < prevOrders.getSize(); ++i) {
            prevOrders.get(i).print();
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
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Chair)) {
            return false;
        }

        Customer rhs = (Customer) obj;

        return email.equals(rhs.email)
                && password.equals(rhs.password);
    }

    public String getEmail() {
        return email;
    }

    private void informCustomerWelcome() {
        System.out.println("Sn. " + getName() + " Basari ile kaydedildiniz, hadi hayirlisi olsun bakalim.");
    }
}

