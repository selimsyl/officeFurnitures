package Users;

import officeFurnitures.Product;

public class Customer extends User {
    String name,surname,email,password;
    String adress,phoneNumber;
    int customerId;

    GenericArray<Order> prevOrders;

    Customer(String name,String surname,String email,String password,int customerId) {
        super(name,customerId,UserRole.CUSTOMER);
        this.surname = surname;
        this.email = email;
        this.password = password;
        informCustomerWelcome();
    }

    public void getPrevOrders() {
        for(int i = 0; i < prevOrders.getSize(); ++i) {
//            System.out.println(prevOrders.get(i).print());
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

    private void informCustomerWelcome() {
        System.out.println("Basari ile kaydedildiniz, hadi hayirlisi olsun bakalim.");
    }
}

