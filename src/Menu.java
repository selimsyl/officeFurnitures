import Users.Administrators;
import Users.Company;
import Users.User;
import officeFurnitures.Branch;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private User user;
    private MenuOperations menuOperations;
    private final Scanner inputScanner = new Scanner(System.in);

    abstract class MenuOperations {
        String[] menu;
        public String[] getMenuOptions() {
            return menu;
        }
        public int getMenuOptionsSize(){
            return menu.length;
        }
    }

    class LoginMenu extends MenuOperations{
        LoginMenu() {
            menu = new String[]{"Administrator","Employee","Customer"};
        }
    }

    class AdministratorMenu extends MenuOperations {
        AdministratorMenu(){
            menu = new String[]{"AddBranch","RemoveBranch","AddEmployee","RemoveEmployee","QueryProducts", "Quit"};
        }
    }

    class EmployeeMenu extends MenuOperations {
        EmployeeMenu(){
            menu = new String[]{"AddProduct","RemoveProduct","InquireProducts","AddCustomer","MakeSell",
                    "ViewCustomerPreviousOrders",
                    "Quit"};
        }
    }

    class CustomerMenu extends MenuOperations {
        CustomerMenu(){
            menu = new String[]{"SearchForAProduct","listProducts","ViewPreviousOrders","Quit"};
        }
    }

    private int getSelectedOption() {
        int enteredOption = -1;

        try {
            enteredOption = inputScanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        inputScanner.nextLine();
        return enteredOption;
    }

    private String listMenu(String[] menu) {
        int i = 1;
        System.out.println("Please choose a option below, enter option number");
        for (String item:menu) {
            System.out.println(i++ + ". " + item);
        }

        var enteredOption = getSelectedOption();

        if (enteredOption < 1 || enteredOption > menu.length)
            return "";
        System.out.println(menu[enteredOption-1]);
        return i >= 0 ? menu[enteredOption-1] : "";
    }

    private User loginMenu() {
        menuOperations = new LoginMenu();

        user = null;
        do {
            switch (listMenu(menuOperations.getMenuOptions())) {
                case "Administrator" -> {
                    System.out.print("Enter admin name : ");
                    String name = inputScanner.nextLine();
                    user = Company.searchAdmin(name);
                    if (user == null)
                        System.out.println("Invalid login, please try again");
                }
                case "Employee" -> {
                    System.out.print("Enter employee name : ");
                    String name = inputScanner.nextLine();
                    System.out.print("Enter employee id : ");
                    int id = Integer.parseInt(inputScanner.nextLine());
                    user = Company.searchEmployee(name, id);
                    if (user == null)
                        System.out.println("Invalid login, please try again");
                }
                case "Customer" -> {
                    System.out.print("Enter customer email : ");
                    String email = inputScanner.nextLine();
                    System.out.print("Enter customer password : ");
                    String pw = inputScanner.nextLine();
                    user = Company.searchCustomer(email, pw);
                    if (user == null)
                        System.out.println("Invalid login, please try again");
                }
                default-> {
                    System.out.println("Please enter a valid option");
                }
            }

        } while(user == null);

        System.out.println("Succesfully logged in");
        return user;
    }

    public void userMenu() {
        switch (loginMenu().getRole()) {
            case ADMIN -> {
                AdmistratorOperations();
            }
            case CUSTOMER -> {
                CustomerOperations();
            }
            case EMPLOYEE -> {
                EmployeeOperations();
            }
        }
    }

    private void AdmistratorOperations() {
        menuOperations = new AdministratorMenu();
        boolean menuExit = false;
        Administrators admin = (Administrators) user;
        do {
            switch (listMenu(menuOperations.getMenuOptions())) {
                case "AddBranch" -> {
                    admin.addBranch();
                }
                case "RemoveBranch" -> {
                    System.out.println("Please choose a branch id to remove below");
                    if(!Company.listBranches()){
                        break;
                    }
                    var enteredSelection = getSelectedOption();
                    if (enteredSelection < 0 || enteredSelection > Company.branches.getSize()) {
                        System.out.println("Please enter a valid option");
                        break;
                    }
                    Branch branch = Company.branches.get(new Branch(null,enteredSelection));

                    if(!admin.removeBranch(branch)) {
                        System.out.println("There is no branch with " + enteredSelection + " id");
                    }
                }
                case "AddEmployee" -> {

                }
                case "RemoveEmployee" -> {

                }
                case "QueryProducts" -> {

                }
                case "Quit" -> {
                    System.out.println("Succesfully logged out");
                    menuExit = true;
                }
                default-> {
                    System.out.println("Please enter a valid option");
                }
            }
        }while (!menuExit);
    }

    private void EmployeeOperations() {
        menuOperations = new EmployeeMenu();
        boolean menuExit = false;
        do {
            switch (listMenu(menuOperations.getMenuOptions())) {
                case "AddProduct" -> {

                }
                case "MakeSell" -> {

                }
                case "AddCustomer" -> {

                }
                case "RemoveProduct" -> {

                }
                case "InquireProducts" -> {

                }
                case "ViewCustomerPreviousOrders" -> {

                }
                case "Quit" -> {
                    System.out.println("Succesfully logged out");
                    menuExit = true;
                }
                default-> {
                    System.out.println("Please enter a valid option");
                }
            }
        }while(!menuExit);
    }

    private void CustomerOperations() {
        menuOperations = new CustomerMenu();
        boolean menuExit = false;
        do {
            switch (listMenu(menuOperations.getMenuOptions())) {
                case "SearchForAProduct" -> {

                }
                case "listProducts" -> {

                }
                case "ViewPreviousOrders" -> {

                }
                case "Quit" -> {
                    System.out.println("Succesfully logged out");
                    menuExit = true;
                }
                default-> {
                    System.out.println("Please enter a valid option");
                }
            }
        }while (!menuExit);
    }

    public void run() {
        userMenu();
    }
}
