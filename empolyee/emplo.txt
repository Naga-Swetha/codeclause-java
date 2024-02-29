import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagementSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee Salary");
            System.out.println("3. Remove Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployeeSalary();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    viewAllEmployees();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.println("Enter employee name:");
        String name = scanner.nextLine();
        System.out.println("Enter employee salary:");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        Employee employee = new Employee(name, nextId++, salary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    private static void updateEmployeeSalary() {
        System.out.println("Enter employee ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            System.out.println("Enter new salary:");
            double newSalary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            employee.setSalary(newSalary);
            System.out.println("Employee salary updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void removeEmployee() {
        System.out.println("Enter employee ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    private static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employees:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}
