import javax.persistence.*;
import java.util.List;

class DBManager {

    private EntityManagerFactory factory;
    private EntityManager manager;

    DBManager() {
        factory = Persistence.createEntityManagerFactory("DBConfig");
        manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.persist(new Employee("Adam","NULP", "Head", 7000));
        manager.persist(new Employee("Alex", "NULP", "assistant", 3100));
        manager.persist(new Employee("Peter", "NULP", "associate professor", 4000));
        manager.persist(new Employee("Victor", "NULP", "professor", 5300));
        manager.persist(new Employee("Igor", "LNU", "Head", 6000));
        manager.persist(new Employee("Nick", "LNU", "assistant", 3000));
        manager.persist(new Employee("Bob", "LNU", "associate professor", 3500));
        manager.persist(new Employee("Leo", "LNU", "professor", 4000));
    }

    void closeConnection(){
        manager.close();
        factory.close();
    }

    void addEmployee(Employee employee){
        manager.persist(employee);
        manager.getTransaction().commit();
    }

    List<Employee> getDepartmentHead(){
        String sqlQuery = "select employee from Employee employee where employee.position = 'Head'";

        TypedQuery<Employee> queryResult = manager.createQuery(sqlQuery, Employee.class);

        return queryResult.getResultList();
    }


    long getPositionCount(String department, String position){
        String sqlQuery = "select COUNT(employee.position) from Employee employee where employee.department = :department " +
                                                                                        "and employee.position = :position";

        Query queryResult = manager.createQuery(sqlQuery);
        queryResult.setParameter("department", department);
        queryResult.setParameter("position", position);

        return (long) queryResult.getSingleResult();
    }

    Double getAverageSalary(String department){
        String sqlQuery = "select AVG(employee.salary) from Employee employee where employee.department = :department";

        Query queryResult = manager.createQuery(sqlQuery);
        queryResult.setParameter("department", department);

        return (Double) queryResult.getSingleResult();
    }

    long getDepartmentCount(String department){
        String sqlQuery = "select COUNT(employee.name) from Employee employee where employee.department = :department";

        Query queryResult = manager.createQuery(sqlQuery);
        queryResult.setParameter("department", department);

        return (long) queryResult.getSingleResult();
    }

    List<Employee> getEmployees(String searchString){
        String sqlQuery = "select employee from Employee employee where employee.name LIKE :searchString";

        TypedQuery<Employee> queryResult = manager.createQuery(sqlQuery, Employee.class);
        queryResult.setParameter("searchString", "%" + searchString + "%");

        return queryResult.getResultList();
    }
}
