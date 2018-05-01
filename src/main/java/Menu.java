import java.util.List;
import java.util.Scanner;

class Menu {

    DBManager dbManager;

    Menu() {
        dbManager = new DBManager();
    }

    void drawMenu(){
        while (true) {

            System.out.println("1 - Add employee\n" +
                    "2 - Department head\n" +
                    "3 - Statistics\n" +
                    "4 - Average salary\n" +
                    "5 - Employee number\n" +
                    "6 - Global search\n" +
                    "7 - Exit");

            Scanner choice = new Scanner(System.in);

            switch (choice.nextInt()) {
                case 1: {
                    addEmployee();

                    break;
                }
                case 2: {
                    getDepartmentHead();

                    break;
                }
                case 3: {
                    getDepartmentStatistic();

                    break;
                }
                case 4: {
                    getAverageSalary();

                    break;
                }
                case 5: {
                    getDepartmentCount();

                    break;
                }
                case 6: {
                    globalSearch();

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

    private void addEmployee(){
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

    private void getDepartmentHead(){
        List<Employee> departmentHeads = dbManager.getDepartmentHead();

        for (Employee employee: departmentHeads) {
            System.out.println("Head of " + employee.getDepartment() + " department is " + employee.getName());
        }
    }

    private void getDepartmentStatistic(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input department's name");
        String department = scanner.nextLine();

        System.out.println("Assistants - " + dbManager.getPositionCount(department, "assistant"));
        System.out.println("Associate professors - " + dbManager.getPositionCount(department, "associate professor"));
        System.out.println("Professors - " + dbManager.getPositionCount(department, "professor"));
    }

    private void getAverageSalary(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input department's name");
        String department = scanner.nextLine();

        System.out.println("The average salary of " + department + " is " + dbManager.getAverageSalary(department));
    }

    private void getDepartmentCount(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input department's name");
        String department = scanner.nextLine();

        System.out.println(department + " has " + dbManager.getDepartmentCount(department) + " employees");
    }

    private void globalSearch(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Search by: ");
        String searchString = scanner.nextLine();

        List<Employee> employees = dbManager.getEmployees(searchString);

        for (Employee employee : employees) {
            System.out.println(employee.getName() + " is working at " + employee.getDepartment());
        }
    }
}
