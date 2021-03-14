import Users.*;
import officeFurnitures.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    /**
     *  Used to access current system user
     */
    private User user;
    /**
     * abstract base class reference to store current menu string array
     */
    private MenuOperations menuOperations;

    /**
     * input stream handler
     */
    private final Scanner inputScanner = new Scanner(System.in);

    /**
     * base abstract class for menu strings
     */
    abstract class MenuOperations {
        String[] menu;
        public String[] getMenuOptions() {
            return menu;
        }
    }

    /**
     * System login options
     */
    class LoginMenu extends MenuOperations{
        LoginMenu() {
            menu = new String[]{"Administrator","Employee","Customer","NewCustomer","Exit"};
        }
    }

    /**
     * Administrator operation menu string array
     */
    class AdministratorMenu extends MenuOperations {
        AdministratorMenu(){
            menu = new String[]{"AddBranch","RemoveBranch","AddEmployee","RemoveEmployee","QueryProducts", "LogOut"};
        }
    }
    /**
     * EmployeeMenu operation menu string array
     */
    class EmployeeMenu extends MenuOperations {
        EmployeeMenu(){
            menu = new String[]{"AddProduct","RemoveProduct","InquireProducts","AddCustomer","MakeSell",
                    "ViewCustomerPreviousOrders",
                    "LogOut"};
        }
    }

    /**
     * CustomerMenu operation menu string array
     */
    class CustomerMenu extends MenuOperations {
        CustomerMenu(){
            menu = new String[]{"SearchForAProduct","ListProducts","ViewPreviousOrders","Buy","LogOut"};
        }
    }

    /**
     * ProductMenu selection menu string array
     */
    class ProductMenu extends  MenuOperations {
        ProductMenu(){
            menu = new String[]{"Chair","Desk","Table","Bookcase","Cabinet","Exit"};
        }
    }

    /**
     * Menu operations base method, all starts from here
     */
    public void run() {
        System.out.println("=============WELCOM TO OFFICE FURNITRES WONDERLAND=============");
        userMenu();
    }

    /**
     * Get which user uses the sytem
     */
    private void userMenu() {
        do {
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
        }while(true);
    }

    /**
     * @return which user logs in system Administrator,Customer,Employee
     */
    private User loginMenu() {
        user = null;
        do {
            menuOperations = new LoginMenu();
            switch (listMenu(menuOperations.getMenuOptions())) {
                case "Administrator" -> {
                    System.out.print("Enter admin name : ");
                    String name = inputScanner.nextLine();
                    user = Company.searchAdmin(name);
                    if (user == null)
                        System.out.println("Invalid login, please try again");
                }
                case "Employee" -> {
                    System.out.print("Enter employee id : ");
                    try {
                        int id = inputScanner.nextInt();
                        inputScanner.nextLine();
                        user = Company.searchEmployee("dum", id);
                        if (user == null)
                            System.out.println("Invalid login, please try again");
                    }catch (Exception e) {
                        System.out.println("Please enter a valid id number");
                        inputScanner.nextLine();
                    }
                }
                case "Customer" -> {
                    user = getCustomerCredentialsFromConsole();
                    if (user == null)
                        System.out.println("Invalid login, please try again");
                }
                case "NewCustomer" -> {
                    Customer customer = registerCustomer();
                    if (customer != null) {
                        Company.addCustomer(customer);
                        System.out.println("Welcom " + customer.getName() + ",you are succesfully registered");
                    }
                }
                case "Exit" -> {
                    System.exit(0);
                }
                default-> {
                }
            }

        } while(user == null);

        System.out.println("Succesfully logged in");
        return user;
    }

    /**
     * Administrator menu for operations
     */
    private void AdmistratorOperations() {
        boolean menuExit = false;
        Administrators admin = (Administrators) user;
        do {
            menuOperations = new AdministratorMenu();
            switch (listMenu(menuOperations.getMenuOptions())) {
                case "AddBranch" -> {
                    admin.addBranch();
                }
                case "RemoveBranch" -> {
                    if(!Company.listBranches())
                        break;
                    System.out.println("Please choose a branch id to remove above");
                    var enteredSelection = getSelectedOption(0,Company.getExistLastBranchId());
                    if (enteredSelection == -1)
                        break;
                    Branch branch = Company.branches.get(new Branch(null,enteredSelection));
                    if (branch != null) {
                        if (!admin.removeBranch(branch)) {
                            System.out.println("There is no branch with " + enteredSelection + " id");
                        }
                    }else{
                        System.out.println("There is no branch with id " + enteredSelection);
                    }
                }
                case "AddEmployee" -> {
                    if(!Company.listBranches())
                        break;
                    System.out.println("Please choose a branch id to add employee above");
                    var enteredSelection = getSelectedOption(0,Company.getExistLastBranchId());
                    if (enteredSelection == -1)
                        break;
                    Branch branch = Company.branches.get(new Branch(null,enteredSelection));
                    if (branch == null) {
                        System.out.println("There is no branch with id " + enteredSelection);
                        break;
                    }
                    var enteredName = getStringFromConsole("name",5, 10);
                    if (!enteredName.toLowerCase().equals("exit"))
                        admin.addEmployeeToBranch(branch,enteredName);
                }
                case "RemoveEmployee" -> {
                    if (Company.employees.getSize() <= 0) {
                        System.out.println("There is no employee to remove");
                        break;
                    }
                    System.out.println("Please enter a employee id beetween 0-"+(Company.getExistEmployeeBranchId()-1)+" to remove");
                    var enteredSelection = getSelectedOption(0,Company.getExistEmployeeBranchId()-1);
                    if (enteredSelection == -1)
                        break;
                    Employee employee = Company.employees.get(new Employee("dum", enteredSelection, null));
                    if (employee != null)
                        admin.removeEmployeeFromBranch(employee);
                }
                case "QueryProducts" -> {
                    admin.queryProductsNeedToBeSuplied();
                }
                case "LogOut" -> {
                    System.out.println("Succesfully logged out");
                    menuExit = true;
                }
                default-> {
//                    System.out.println("Please enter a valid option");
                }
            }
        }while (!menuExit);
    }

    /**
     * Customer menu for operations
     */
    private void CustomerOperations() {
        Product product = null;
        boolean menuExit = false;
        Customer customer = (Customer)user;
        do {
            menuOperations = new CustomerMenu();
            switch (listMenu(menuOperations.getMenuOptions())) {
                case "SearchForAProduct" -> {
                    System.out.println("Please select product to search");
                    product = chooseAProduct();
                    if (product != null) {
                        Object[] branches = Company.branches.getDataArray();
                        for (int i = 0; i < Company.branches.getSize(); ++i) {
                            Branch branch = (Branch) branches[i];
                            if (branch.findFurniture(product) != null) {
                                System.out.println("Product found in store id with " + branch.getBranchId());
                            }
                        }
                    }
                }
                case "ListProducts" -> {
                    Company.listProducts();
                }
                case "ViewPreviousOrders" -> {
                    customer.getPrevOrders();
                }
                case "Buy" -> {
                    System.out.println("Please select product to buy");
                    product = chooseAProduct();
                    boolean sellCompleted = false;
                    if (product != null) {
                        Object[] branches = Company.branches.getDataArray();
                        for (int i = 0; i < Company.branches.getSize(); ++i) {
                            Branch branch = (Branch)branches[i];
                            if (branch.getOnlineEmployee().makeSell(product, customer)) {
                                sellCompleted = true;
                                break;
                            }
                        }
                        if (!sellCompleted) {
                            System.out.println("There are no enough products in store");
                            System.out.println("Employee informed manager");
                        }
                    }
                }
                case "LogOut" -> {
                    System.out.println("Succesfully logged out");
                    menuExit = true;
                }
                default-> {
                }
            }
        }while (!menuExit);
    }

    /**
     * Employee menu for operations
     */
    private void EmployeeOperations() {
        boolean menuExit = false;
        Product product = null;
        Employee employee = (Employee)user;
        do {
            menuOperations = new EmployeeMenu();
            switch (listMenu(menuOperations.getMenuOptions())) {
                case "AddProduct" -> {
                    product = chooseAProduct();
                    if(product != null)
                        employee.addProduct(product);
                }
                case "MakeSell" -> {
                    product = chooseAProduct();
                    Customer customer = getCustomerCredentialsFromConsole();
                    if (customer!=null) {
                        if(!employee.makeSell(product,customer)){
                            System.out.println("There are no enough products in store");
                            System.out.println("Employee informed manager");
                        }
                    }
                    else {
                        System.out.println("Invalid customer, please try again");
                    }
                }
                case "AddCustomer" -> {
                    Customer customer = registerCustomer();
                    if (customer != null)
                        employee.addCustomer(customer);
                }
                case "RemoveProduct" -> {
                    product = chooseAProduct();
                    if(product != null)
                        employee.removeProduct(product);
                }
                case "InquireProducts" -> {
                    employee.inquireProducts();
                }
                case "ViewCustomerPreviousOrders" -> {
                    Customer customer = getCustomerCredentialsFromConsole();
                    if (customer != null) {
                        customer.getPrevOrders();
                    }else {
                        System.out.println("Invalid customer, please try again");
                    }
                }
                case "LogOut" -> {
                    System.out.println("Succesfully logged out");
                    menuExit = true;
                }
                default-> {
//                    System.out.println("Please enter a valid option");
                }
            }
        }while(!menuExit);
    }

    /**
     * @param menu String values listed as a menu
     * @return which menu option is selected
     */
    private String listMenu(String[] menu) {
        int i = 1;
        System.out.println("Please choose a option below, enter option number");
        for (String item:menu) {
            System.out.println(i++ + ". " + item);
        }

        var enteredOption = getSelectedOption(1,menu.length);
        if (enteredOption == -1)
            return "";

        System.out.println("Selected option : " + menu[enteredOption-1]);
        return i >= 0 ? menu[enteredOption-1] : "";
    }

    /**
     * @param desiredInput String name for a prompt to user what is expected
     * @param minLength Min length of input
     * @param maxLength Max length of input
     * @return what is entered
     */
    private String getStringFromConsole(String desiredInput,int minLength,int maxLength) {
        System.out.println("Enter 'exit' to abort operations");
        return getEnteredString(desiredInput,minLength,maxLength);
    }

    /**
     * @param desiredInput String name for a prompt to user what is expected
     * @param minLength Min length of input
     * @param maxLength Max length of input
     * @return what is entered
     */
    private String getEnteredString(String desiredInput,int minLength,int maxLength) {
        String revStr = null;
        System.out.println("Please enter a valid "+desiredInput+" between " + minLength + "-" + maxLength);
        do {
            try {
                revStr = inputScanner.nextLine();
                if (revStr.toLowerCase().equals("exit"))
                    continue;
                if (revStr.length() < minLength || revStr.length() > maxLength) {
                    System.out.println("Please enter a valid "+desiredInput+" between " + minLength + "-" + maxLength);
                }
                else {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid name");
                revStr = "";
            }

        }while(!revStr.toLowerCase().equals("exit"));
        return revStr;
    }

    /**
     * @param minInput Min input value
     * @param maxInput Max input value
     * @return what value is entered
     * Make user to enter a value between minInput-maxInput values
     */
    private int getSelectedOption(int minInput,int maxInput) {
        int enteredOption = -1;

        try {
            enteredOption = inputScanner.nextInt();
        } catch (Exception e) {
//            System.out.println(e.getMessage());
        }
        inputScanner.nextLine();

        if (enteredOption < minInput || enteredOption > maxInput) {
            System.out.println("Please enter a valid option");
            enteredOption = -1;
        }

        return enteredOption;
    }

    /**
     * @return register Customer to Copmany customer array
     */
    private Customer registerCustomer() {
        String name = getStringFromConsole("NAME",1, 15);
        if (name.toLowerCase().equals("exit"))
            return null;

        String email = getStringFromConsole("EMAIL",1, 15);
        if (email.toLowerCase().equals("exit"))
            return null;

        String surname = getStringFromConsole("SURNAME",1, 15);
        if (surname.toLowerCase().equals("exit"))
            return null;

        String password = getStringFromConsole("PASSWORD",1, 15);
        if (password.toLowerCase().equals("exit"))
            return null;

        String adress = getStringFromConsole("ADRESS",1, 25);
        if (password.toLowerCase().equals("exit"))
            return null;

        String phone = getStringFromConsole("PHONENUMBER",1, 25);
        if (password.toLowerCase().equals("exit"))
            return null;
        Customer customer = new Customer(name, surname,email ,password ,Company.getNextCustomerId());
        customer.setPhoneNumber(phone);
        customer.setAdress(adress);
        return customer;
    }

    /**
     * @return get customer email and password to validate it
     */
    private Customer getCustomerCredentialsFromConsole() {
        String email = getStringFromConsole("Customer Email",1, 15);
        if (email.toLowerCase().equals("exit"))
            return null;
        String pw = getStringFromConsole("Customer Password",1, 15);
        if (email.toLowerCase().equals("exit"))
            return null;
        return Company.searchCustomer(email, pw);
    }

    /**
     * @param menu String values for products
     * @return which product option is selected
     */
    private String listProductsMenus(String[] menu) {
        menu = Arrays.copyOf(menu, menu.length+1);
        menu[menu.length-1] = "Exit";

        String selectedModel = "";

        while(selectedModel.equals(""))
            selectedModel = listMenu(menu);

        return selectedModel;
    }

    /**
     * @return choosen product
     */
    private Product chooseAProduct() {
        boolean menuExit = false;
        do {
            menuOperations = new ProductMenu();
            switch (listMenu(menuOperations.getMenuOptions())) {
                case "Chair" -> {
                    //Pick model
                    String[] chairMenu = new String[Chair.ChairModels.values().length];
                    int index = 0;
                    for (Chair.ChairModels item:Chair.ChairModels.values()) {
                        chairMenu[index++] = item.toString();
                    }
                    var modelString = listProductsMenus(chairMenu);
                    if (modelString.equals("Exit"))
                        break;

                    var model = Chair.ChairModels.valueOf(modelString);

                    //Pick color
                    String[] chairColorMenu = new String[Chair.Color.values().length];
                    index = 0;

                    for (Chair.Color item:Chair.Color.values()) {
                        chairColorMenu[index++] = item.toString();
                    }

                    var colorString = listProductsMenus(chairColorMenu);
                    if (colorString.equals("Exit"))
                        break;

                    var color = Chair.Color.valueOf(colorString);

                    int amount;
                    do {
                        System.out.println("Please enter a amount between " + 1 + "-" + 100);
                        amount = getSelectedOption(1, 100);
                    }while (amount == -1);

                    return new Chair(model,color,amount);
                }
                case "Desk" -> {
                    //Pick model
                    String[] modelMenu = new String[Desk.DeskModels.values().length];
                    int index = 0;
                    for (Desk.DeskModels item:Desk.DeskModels.values()) {
                        modelMenu[index++] = item.toString();
                    }
                    var modelString = listProductsMenus(modelMenu);
                    if (modelString.equals("Exit"))
                        break;

                    var model = Desk.DeskModels.valueOf(modelString);

                    //Pick color
                    String[] colorMenu = new String[Desk.Color.values().length];
                    index = 0;

                    for (Desk.Color item:Desk.Color.values()) {
                        colorMenu[index++] = item.toString();
                    }

                    var colorString = listProductsMenus(colorMenu);
                    if (colorString.equals("Exit"))
                        break;

                    var color = Desk.Color.valueOf(colorString);

                    int amount;
                    do {
                        System.out.println("Please enter a amount between " + 1 + "-" + 100);
                        amount = getSelectedOption(1, 100);
                    }while (amount == -1);

                    return new Desk(model,color,amount);
                }
                case "Table" -> {
                    //Pick model
                    String[] modelMenu = new String[Table.TableModels.values().length];
                    int index = 0;
                    for (Table.TableModels item:Table.TableModels.values()) {
                        modelMenu[index++] = item.toString();
                    }
                    var modelString = listProductsMenus(modelMenu);
                    if (modelString.equals("Exit"))
                        break;

                    var model = Table.TableModels.valueOf(modelString);

                    //Pick color
                    String[] colorMenu = new String[Table.Color.values().length];
                    index = 0;

                    for (Table.Color item:Table.Color.values()) {
                        colorMenu[index++] = item.toString();
                    }

                    var colorString = listProductsMenus(colorMenu);
                    if (colorString.equals("Exit"))
                        break;

                    var color = Table.Color.valueOf(colorString);

                    int amount;
                    do {
                        System.out.println("Please enter a amount between " + 1 + "-" + 100);
                        amount = getSelectedOption(1, 100);
                    }while (amount == -1);

                    return new Table(model,color,amount);
                }
                case "Bookcase" -> {
                    //Pick model
                    String[] modelMenu = new String[BookCase.BookCaseModels.values().length];
                    int index = 0;
                    for (BookCase.BookCaseModels item:BookCase.BookCaseModels.values()) {
                        modelMenu[index++] = item.toString();
                    }
                    var modelString = listProductsMenus(modelMenu);
                    if (modelString.equals("Exit"))
                        break;

                    var model = BookCase.BookCaseModels.valueOf(modelString);

                    int amount;
                    do {
                        System.out.println("Please enter a amount between " + 1 + "-" + 100);
                        amount = getSelectedOption(1, 100);
                    }while (amount == -1);

                    return new BookCase(model,amount);
                }
                case "Cabinet" -> {
                    //Pick model
                    String[] modelMenu = new String[Cabinet.CabinetModels.values().length];
                    int index = 0;
                    for (Cabinet.CabinetModels item:Cabinet.CabinetModels.values()) {
                        modelMenu[index++] = item.toString();
                    }
                    var modelString = listProductsMenus(modelMenu);
                    if (modelString.equals("Exit"))
                        break;

                    var model = Cabinet.CabinetModels.valueOf(modelString);

                    int amount;
                    do {
                        System.out.println("Please enter a amount between " + 1 + "-" + 100);
                        amount = getSelectedOption(1, 100);
                    }while (amount == -1);

                    return new Cabinet(model,amount);
                }
                case "Exit" -> {
                    menuExit = true;
                }
            }
        } while(!menuExit);
        return null;
    }

}
