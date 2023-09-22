import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeList extends Employee {
    private int currentSize =  0;
    private Employee[] employees;

    public EmployeeList() {
        employees = new Employee[10];
    }

    public EmployeeList(int size) {
        employees = new Employee[size];
    }

    public Employee[] getEmployees() {
        return employees;
    }

    private void grow() {
        int newLength= (int) (employees.length * 1.5);
        employees = Arrays.copyOf(employees, newLength);
    }

    private int indexOfEmployee(String id) {
        Arrays.sort(employees, 0, currentSize, Comparator.comparing(Employee::getId));

        for(int i = 0; i < currentSize; i++) {
            if(employees[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Employee searchEmployeeById(String id) {
        int index = indexOfEmployee(id);
        if (index == -1) {
            return null;
        }
        return employees[index];
    }

    public Employee[] getHourlyEmpsWorkMoreThan40() {
        List<Employee> hourlyEmps = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee instanceof HourlyEmployee) {
                if (((HourlyEmployee) employee).getHoursWorked() > 40) {
                    hourlyEmps.add(employee);
                }
            }
        }
        return hourlyEmps.toArray(new Employee[0]);
    }


    public void addEmployee(Employee employee) {
        if (searchEmployeeById(employee.getId()) != null) {
            throw new IllegalArgumentException("Employee with ID " + employee.getId() + " already exists");
        }
        if (currentSize == employees.length) {
            grow();
        }
        employees[currentSize++] = employee;
    }

    public void addAll(Employee[] newEmployees) {
        Arrays.stream(newEmployees).forEach(this::addEmployee);
    }

    public void sortByWeeklySalary() {
        Arrays.sort(employees, 0, currentSize, Comparator.comparing(Employee::weeklyPay));
    }

    public void removeEmployee(String id) {
        int index = indexOfEmployee(id);
        if (index == -1) {
            throw new IllegalArgumentException("Employee ID does not exist");
        }
        for (int i = index; i < currentSize - 1; i++) {
            employees[i] = employees[i + 1];
        }
        currentSize--;
    }

    public void updateEmployee(Employee newInfor) {
        int index = indexOfEmployee(newInfor.getId());
        if (index == -1) {
            throw new IllegalArgumentException("Employee ID does not exist");
        }
        employees[index] = newInfor;
    }

    //trả về danh sách các nhân viên làm trên 40h

    public double getWeeklyTotalSalaryOfManagers() {
        double total = 0;
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                total += employee.weeklyPay();
            }
        }
        return total;
    }

    public void updateHourlyWorked(String id, int newHour) {
        if(newHour < 0) {
            throw new IllegalArgumentException("Work hour cannot be less than 0!");
        }

        int index = indexOfEmployee(id);
        if(index == -1) {
            throw new IllegalArgumentException("Employee ID do not exist!");
        }

        if(!(employees[index] instanceof HourlyEmployee)) {
            throw new IllegalArgumentException("This employee is not a hourly employee!");
        }

        ((HourlyEmployee) employees[index]).setHoursWorked(newHour);
    }

    public Employee[] getYoungEmployeesAsManagers() {
        LocalDate today = LocalDate.now();
        List<Employee> youngManagers = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                LocalDate dob = employee.getDob();
                if (dob != null) {
                    Period period = Period.between(dob, today);
                    int yearsOld = period.getYears();
                    if (yearsOld < 30) {
                        youngManagers.add(employee);
                    }
                }
            }
        }
        // Chuyển danh sách thành mảng
        return youngManagers.toArray(new Employee[0]);
    }

    @Override
    public double weeklyPay() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.weeklyPay();
        }
        return total;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("$#,###.00");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < currentSize; i++) {
            result.append(employees[i].toString()).append("\n");
            result.append("Weekly Salary: ").append(formatter.format(employees[i].weeklyPay())).append("\n\n");
        }
        return result.toString();
    }
}
