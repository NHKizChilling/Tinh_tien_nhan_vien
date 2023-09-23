import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeListTest {

    LocalDate dob = LocalDate.of(1990, 1, 1);
    EmployeeList employeeList = new EmployeeList(10);


    @Test
    void addEmployeeTest() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("1", "John", dob, 100000);
        employeeList.addEmployee(salariedEmployee);
        Manager manager = new Manager("2", "Jane", dob, 100000, 1000);
        employeeList.addEmployee(manager);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("3", "John", dob, 20, 40);
        employeeList.addEmployee(hourlyEmployee);
        SalariedEmployee salariedEmployee1 = new SalariedEmployee("4", "Jane", dob, 100000);

        HourlyEmployee hourlyEmployee1 = new HourlyEmployee("1", "Jane", dob, 20, 40);
        assertThrows(IllegalArgumentException.class, () -> employeeList.addEmployee(hourlyEmployee1));
    }

    @Test
    void getEmployees() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("1", "John", dob, 100000);
        employeeList.addEmployee(salariedEmployee);
        Manager manager = new Manager("2", "Jane", dob, 100000, 1000);
        employeeList.addEmployee(manager);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("3", "John", dob, 20, 40);
        employeeList.addEmployee(hourlyEmployee);
        SalariedEmployee salariedEmployee1 = new SalariedEmployee("4", "Jane", dob, 100000);

        assertEquals(salariedEmployee, employeeList.getEmployees()[0]);
        assertEquals(manager, employeeList.getEmployees()[1]);
        assertEquals(hourlyEmployee, employeeList.getEmployees()[2]);
        assertNull(employeeList.getEmployees()[3]);
    }

    @Test
    void searchEmployeeById() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("1", "John", dob, 100000);
        employeeList.addEmployee(salariedEmployee);
        Manager manager = new Manager("2", "Jane", dob, 100000, 1000);
        employeeList.addEmployee(manager);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("3", "John", dob, 20, 40);
        employeeList.addEmployee(hourlyEmployee);
        SalariedEmployee salariedEmployee1 = new SalariedEmployee("4", "Jane", dob, 100000);

        assertEquals(salariedEmployee, employeeList.searchEmployeeById("1"));
        assertEquals(manager, employeeList.searchEmployeeById("2"));
        assertEquals(hourlyEmployee, employeeList.searchEmployeeById("3"));
        assertNull(employeeList.searchEmployeeById("5"));
    }

    @Test
    void addAllTest() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("1", "John", dob, 100000);
        employeeList.addEmployee(salariedEmployee);
        Manager manager = new Manager("2", "Jane", dob, 100000, 1000);
        employeeList.addEmployee(manager);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("3", "John", dob, 20, 40);
        employeeList.addEmployee(hourlyEmployee);


        EmployeeList newList = new EmployeeList(2);
        SalariedEmployee newSalariedEmployee = new SalariedEmployee("10", "John", dob, 100000);
        newList.addEmployee(newSalariedEmployee);
        Manager newManager = new Manager("1", "Jane", dob, 100000, 1000);
        newList.addEmployee(newManager);

        assertThrows(IllegalArgumentException.class, () -> employeeList.addAll(newList.getEmployees()));
        assertEquals(newSalariedEmployee, employeeList.searchEmployeeById("10"));
    }

    @Test
    void removeEmployee() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("1", "John", dob, 100000);
        employeeList.addEmployee(salariedEmployee);
        Manager manager = new Manager("2", "Jane", dob, 100000, 1000);
        employeeList.addEmployee(manager);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("3", "John", dob, 20, 40);
        employeeList.addEmployee(hourlyEmployee);

        employeeList.removeEmployee("1");
        assertNull(employeeList.searchEmployeeById("1"));
    }

    @Test
    void updateEmployeeTest() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("1", "John", dob, 100000);
        employeeList.addEmployee(salariedEmployee);
        Manager manager = new Manager("2", "Jane", dob, 100000, 1000);
        employeeList.addEmployee(manager);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("3", "John", dob, 20, 40);
        employeeList.addEmployee(hourlyEmployee);

        SalariedEmployee newSalariedEmployee = new SalariedEmployee("1", "Johnny ", dob, 100000);
        employeeList.updateEmployee(newSalariedEmployee);
        assertEquals(newSalariedEmployee, employeeList.searchEmployeeById("1"));
    }

    @Test
    void getHourlyEmpsWorkMoreThan40Test() {
        EmployeeList listWorkMoreThan40 = new EmployeeList(4);
        Employee hourlyEmployee = new HourlyEmployee("3", "John", dob, 20, 40);
        employeeList.addEmployee(hourlyEmployee);
        Employee hourlyEmployee1 = new HourlyEmployee("4", "Joe", dob, 50, 50);
        employeeList.addEmployee(hourlyEmployee1);
        Employee hourlyEmployee2 = new HourlyEmployee("5", "Foden", dob, 60, 30);
        employeeList.addEmployee(hourlyEmployee2);

        listWorkMoreThan40.addAll(employeeList.getHourlyEmpsWorkMoreThan40());

        assertEquals(hourlyEmployee1, listWorkMoreThan40.searchEmployeeById("4"));
    }

    @Test
    void getWeeklyTotalSalaryOfManagersTest() {
        EmployeeList listManagers = new EmployeeList(4);
        Employee manager = new Manager("1", "John", dob, 100000, 1000);
        listManagers.addEmployee(manager);
        Employee manager1 = new Manager("2", "Joe", dob, 100000, 1000);
        listManagers.addEmployee(manager1);
        Employee manager2 = new Manager("3", "Foden", dob, 100000, 1000);
        listManagers.addEmployee(manager2);

        assertEquals((100000.0/52+1000)*3, listManagers.getWeeklyTotalSalaryOfManagers());
    }

    @Test
    void updateHourlyWorked() {

        Employee hourlyEmployee = new HourlyEmployee("3", "John", dob, 20, 40);
        employeeList.addEmployee(hourlyEmployee);
        Employee hourlyEmployee1 = new HourlyEmployee("4", "Joe", dob, 50, 50);
        employeeList.addEmployee(hourlyEmployee1);
        Employee hourlyEmployee2 = new HourlyEmployee("5", "Foden", dob, 60, 30);
        employeeList.addEmployee(hourlyEmployee2);

        employeeList.updateHourlyWorked("3", 30);
        HourlyEmployee tmp = (HourlyEmployee) employeeList.searchEmployeeById("3");
        assertEquals(30, tmp.getHoursWorked());
    }

    @Test
    void getYoungEmployeesAsManagers() {
        EmployeeList listManagers = new EmployeeList(4);
        Employee manager = new Manager("1", "John", LocalDate.of(2000, 05, 19), 100000, 1000);
        listManagers.addEmployee(manager);
        Employee manager1 = new Manager("2", "Joe", LocalDate.of(1999, 05, 31), 100000, 1000);
        listManagers.addEmployee(manager1);
        Employee manager2 = new Manager("3", "Fred", LocalDate.of(1980, 1, 1), 100000, 1000);
        listManagers.addEmployee(manager2);

        EmployeeList youngManagers = new EmployeeList(2);
        youngManagers.addAll(listManagers.getYoungEmployeesAsManagers());
        assertEquals(manager, youngManagers.searchEmployeeById("1"));
        assertEquals(manager1, youngManagers.searchEmployeeById("2"));
        assertNull(youngManagers.searchEmployeeById("3"));
    }

    @Test
    void weeklyPay() {
        EmployeeList list = new EmployeeList(4);
        Employee manager = new Manager("1", "John", dob, 100000, 1000);
        list.addEmployee(manager);
        Employee manager1 = new Manager("2", "Joe", dob, 100000, 1000);
        list.addEmployee(manager1);
        Employee manager2 = new Manager("3", "Foden", dob, 100000, 1000);
        list.addEmployee(manager2);
        Employee hourlyEmployee = new HourlyEmployee("4", "John", dob, 20, 40);
        list.addEmployee(hourlyEmployee);

        assertEquals(9569.23076923077, list.weeklyPay());
    }
}