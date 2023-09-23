import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Employee {
    protected String id;
    protected String name;
    protected LocalDate dob;

    public Employee() {
        this("0000", "No Name", LocalDate.now());
    }

    public Employee(String id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public abstract double weeklyPay();

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Employee ID: " + id + "\nEmployee name: " + name + "\nDate of birth: " + dob.format(formatter);
    }
}
