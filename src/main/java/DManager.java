import java.util.List;
import java.util.Scanner;

public class DManager {

    public static void main(String[] args){

        DBManager dbManager = new DBManager();


        while (true) {

            System.out.println("1 - Add employee\n" +
                    "2 - Who is the head of department\n" +
                    "3 - Show statistics\n" +
                    "4 - Average salary\n" +
                    "5 - Number of employee\n" +
                    "6 - Global search\n" +
                    "7 - Exit");

            Scanner choice = new Scanner(System.in);

            switch (choice.nextInt()) {
                case 1: {
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

                    break;
                }
                case 2: {
                    List<Employee> departmentHeads = dbManager.getDepartmentHead();

                    for (Employee employee: departmentHeads) {
                        System.out.println("Head of " + employee.getDepartment() + " department is " + employee.getName());
                    }

                    break;
                }
                case 3: {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Input department's name");
                    String department = scanner.nextLine();

                    System.out.println("Assistants - " + dbManager.getPositionCount(department, "assistant"));
                    System.out.println("Associate professors - " + dbManager.getPositionCount(department, "associate professor"));
                    System.out.println("Professors - " + dbManager.getPositionCount(department, "professor"));

                    break;
                }
                case 4: {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Input department's name");
                    String department = scanner.nextLine();

                    System.out.println("The average salary of " + department + " is " + dbManager.getAverageSalary(department));

                    break;
                }
                case 5: {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Input department's name");
                    String department = scanner.nextLine();

                    System.out.println(department + " has " + dbManager.getDepartmentCount(department) + " employees");

                    break;
                }
                case 6: {
                    Scanner scanner = new Scanner(System.in);

                    System.out.print("Search by: ");
                    String searchString = scanner.nextLine();

                    List<Employee> employees = dbManager.getEmployees(searchString);

                    for (Employee employee : employees) {
                        System.out.println(employee.getName() + " is working at " + employee.getDepartment());
                    }

                    break;
                }
                case 7:{
                    dbManager.closeConnection();
                    return;
                }
                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}
