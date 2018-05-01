import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String department;
    private String position;

    private double salary;

    public Employee() {
    }

    Employee(String name, String department, String position, double salary) {
        this.name = name;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getDepartment() {
        return department;
    }

    String getPosition() {
        return position;
    }

    double getSalary() {
        return salary;
    }
}
