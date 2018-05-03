import java.util.Scanner;

class Menu {

    private DBManager dbManager;
    private DManager dManager;

    Menu() {
        dbManager = new DBManager();
        dManager = new DManager();
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
                    dManager.addEmployee();

                    break;
                }
                case 2: {
                    dManager.getDepartmentHead();

                    break;
                }
                case 3: {
                    dManager.getDepartmentStatistic();

                    break;
                }
                case 4: {
                    dManager.getAverageSalary();

                    break;
                }
                case 5: {
                    dManager.getDepartmentCount();

                    break;
                }
                case 6: {
                    dManager.globalSearch();

                    break;
                }
                case 7:{
                    dbManager.closeConnection();
                    return;
                }
                default:
                    System.out.println("Wrong input!");
                    return;
            }
        }
    }


}
