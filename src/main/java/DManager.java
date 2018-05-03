import java.util.List;
import java.util.Scanner;

class DManager {

    private DBManager dbManager;

    DManager() {
        dbManager = new DBManager();
    }

    void addEmployee(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input name");
        String name = scanner.nextLine();

        System.out.println("Input assignment");
        String assignment = scanner.nextLine();

        System.out.println("Input departure name ");
        String department = scanner.nextLine();

        System.out.println("Input salary");
        double salary = scanner.nextDouble();

        dbManager.addEmployee(new Employee(name, department, assignment, salary));

        System.out.println("Added successfully");
    }

    void getDepartmentHead(){
        List<Employee> departmentHeads = dbManager.getDepartmentHead();

        for (Employee employee: departmentHeads) {
            System.out.println("Head of " + employee.getDepartment() + " department is " + employee.getName());
        }
    }

    void getDepartmentStatistic(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input department's name");
        String department = scanner.nextLine();

        System.out.println("Assistants - " + dbManager.getPositionCount(department, "assistant"));
        System.out.println("Associate professors - " + dbManager.getPositionCount(department, "associate professor"));
        System.out.println("Professors - " + dbManager.getPositionCount(department, "professor"));
    }

    void getAverageSalary(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input department's name");
        String department = scanner.nextLine();

        System.out.println("The average salary of " + department + " is " + dbManager.getAverageSalary(department));
    }

    void getDepartmentCount(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input department's name");
        String department = scanner.nextLine();

        System.out.println(department + " has " + dbManager.getDepartmentCount(department) + " employees");
    }

    void globalSearch(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Search by: ");
        String searchString = scanner.nextLine();

        List<Employee> employees = dbManager.getEmployees(searchString);

        for (Employee employee : employees) {
            System.out.println(employee.getName() + " is working at " + employee.getDepartment());
        }
    }
}
