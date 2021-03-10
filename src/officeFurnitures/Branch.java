package officeFurnitures;


import Users.Company;
import Users.Employee;
import Users.GenericArray;

public class Branch {
    Product[] products;

    public Branch(Product[] products,int branchId) {
        this.branchId = branchId;
        this.products = products;
        employees = new GenericArray<Employee>();
    }

    public Product findFurniture(Product furniture) {
        for (Product kik : products) {
            if(kik.getUnitInStock() > 0) {
                if (furniture.equals(kik)) {
                    return kik;
                }
            }
        }
        return null;
    }

    public int getBranchId() {
        return branchId;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public int getEmployeeCount() {
        return employees.getSize();
    }

    final private int branchId;

    private GenericArray<Employee> employees;
}
