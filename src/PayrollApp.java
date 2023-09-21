import java.time.LocalDate;
import java.util.Scanner;

public class PayrollApp {

    public static void main(String[] args) {
//        int n;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number of employees: ");
//        n = sc.nextInt();
          LocalDate dob = LocalDate.of(1990, 1, 1);
//        EmployeeList employeeList = new EmployeeList(10);
//        SalariedEmployee salariedEmployee = new SalariedEmployee("1", "John", dob, 100000);
//        employeeList.addEmployee(salariedEmployee);
//        Manager manager = new Manager("2", "Jane", dob, 100000, 1000);
//        employeeList.addEmployee(manager);
//        HourlyEmployee hourlyEmployee = new HourlyEmployee("3", "John", dob, 20, 40);
//        employeeList.addEmployee(hourlyEmployee);
//
//        //in danh sách employeeList
//        System.out.println("Danh sách employeeList: ");
//        for (Employee employee : employeeList.getEmployees()) {
//            System.out.println(employee);
//        }
//
//        EmployeeList newList = new EmployeeList(2);
//        SalariedEmployee newSalariedEmployee = new SalariedEmployee("10", "John", dob, 100000);
//        newList.addEmployee(newSalariedEmployee);
//        Manager newManager = new Manager("20", "Jane", dob, 100000, 1000);
//        newList.addEmployee(newManager);
//
//        //in danh sách newList
//        System.out.println("Danh sách newList: ");
//         for (Employee employee : newList.getEmployees()) {
//            System.out.println(employee);
//        }
//
//        //thêm newList vào employeeList
//        employeeList.addAll(newList.getEmployees());
//        //in danh sách employeeList sau khi thêm newList
//        System.out.println("Danh sách employeeList sau khi thêm newList: ");
//        for (Employee employee : employeeList.getEmployees()) {
//            System.out.println(employee);
//        }

        //danh sách nhân viên làm theo giờ
        EmployeeList hourlyEmployees = new EmployeeList(3);
        HourlyEmployee hourlyEmployee1 = new HourlyEmployee("4", "John", dob, 20, 40);
        hourlyEmployees.addEmployee(hourlyEmployee1);
        HourlyEmployee hourlyEmployee2 = new HourlyEmployee("5", "John", dob, 20, 50);
        hourlyEmployees.addEmployee(hourlyEmployee2);
        HourlyEmployee hourlyEmployee3 = new HourlyEmployee("6", "John", dob, 20, 60);
        hourlyEmployees.addEmployee(hourlyEmployee3);
        //in danh sách hourlyEmployees
        System.out.println("\n\nDanh sách hourlyEmployees: ");
        System.out.println(hourlyEmployees.toString());

//        //thêm hourlyEmployees vào employeeList
//        employeeList.addAll(hourlyEmployees.getEmployees());
//        //in danh sách employeeList sau khi thêm hourlyEmployees
//        System.out.println("\n\nDanh sách employeeList sau khi thêm hourlyEmployees: ");
//        for (Employee employee : employeeList.getEmployees()) {
//            System.out.println(employee);
//        }

        //danh sách nhân viên làm theo giờ làm trên 40h
        EmployeeList hourlyEmployeesOver40Hours = new EmployeeList(3);
        hourlyEmployeesOver40Hours.addAll(hourlyEmployees.getHourlyEmpsWorkMoreThan40());
        //in danh sách hourlyEmployeesOver40Hours
        System.out.println("\n\nDanh sách hourlyEmployeesOver40Hours: ");
        for (Employee employee : hourlyEmployeesOver40Hours.getEmployees()) {
            System.out.println(employee);
        }


        
//        while(true) {
//            switch (menu()) {
//                case 1:
//                    employees.toString();
//                    break;
//                case 2:
//                    System.out.println("Enter employee type (1. Salaried, 2. Hourly, 3. Manager): ");
//                    int type = sc.nextInt();
//                    switch (type) {
//                        case 1:
//                            SalariedEmployee salariedEmployee = new SalariedEmployee();
//                            input(salariedEmployee);
//                            employees.addEmployee(salariedEmployee);
//                            break;
//                        case 2:
//                            HourlyEmployee hourlyEmployee = new HourlyEmployee();
//                            input(hourlyEmployee);
//                            employees.addEmployee(hourlyEmployee);
//                            break;
//                        case 3:
//                            Manager manager = new Manager();
//                            input(manager);
//                            employees.addEmployee(manager);
//                            break;
//                        default:
//                            System.out.println("Invalid type. Please choose again.");
//                            break;
//                    }
//                    break;
//
//            }
//        }
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
         do {
            System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("1.Display all employees");
            System.out.println("2.Add a new employee");
            System.out.println("3.Search employee by ID");
            System.out.println("4.Sort by weekly salary");
            System.out.println("5.Remove employee by ID");
            System.out.println("6.Update employee by ID");
            System.out.println("7.List hourly employees who work more than 40 hours a week");
            System.out.println("8.Print the total weekly salary of all employees");
            System.out.println("9.Update hourly worked of hourly employees by ID");
            System.out.println("10.List of employees who are young managers (less than 30 years old)");
            System.out.println("0.Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if(choice < 0 || choice > 10) {
                System.out.println("Invalid choice. Please choose again.");
            }
        } while(choice < 0 || choice > 10);
        if(choice == 0) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
        return choice;
    }

    public static void input(Employee tmp) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee ID: ");
        String id = sc.nextLine();
        tmp.setId(id);
        System.out.println("Enter employee name: ");
        String name = sc.nextLine();
        tmp.setName(name);
        System.out.println("Enter employee date of birth: ");
//        LocalDate dob = sc.nextLocalDate();
//        tmp.setDob(dob);
    }
}
