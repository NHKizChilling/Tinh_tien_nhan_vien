import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PayrollApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of employees: ");
        int n = sc.nextInt();
        EmployeeList employees = new EmployeeList(n);


        while(true) {
            switch (menu()) {
                case 1 -> {
                    System.out.println("List of all employees: ");
                    System.out.println(employees);
                }
                case 2 -> {
                    for(int i = 0; i < n; i++) {
                        System.out.println("Enter employee type (1. Salaried, 2. Hourly, 3. Manager): ");
                        int type = sc.nextInt();
                        switch (type) {
                            case 1 -> {
                                SalariedEmployee salariedEmployee = new SalariedEmployee();
                                input(salariedEmployee);
                                System.out.println("Enter annual salary: ");
                                double annualSalary = sc.nextDouble();
                                salariedEmployee.setAnnualSalary(annualSalary);
                                try {
                                    employees.addEmployee(salariedEmployee);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case 2 -> {
                                HourlyEmployee hourlyEmployee = new HourlyEmployee();
                                input(hourlyEmployee);
                                System.out.println("Enter hours worked: ");
                                int hoursWorked = sc.nextInt();
                                hourlyEmployee.setHoursWorked(hoursWorked);
                                System.out.println("Enter hourly wage: ");
                                double hourlyWage = sc.nextDouble();
                                hourlyEmployee.setHourlyWage(hourlyWage);
                                try {
                                    employees.addEmployee(hourlyEmployee);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case 3 -> {
                                Manager manager = new Manager();
                                input(manager);
                                System.out.println("Enter annual salary: ");
                                double annualSalary1 = sc.nextDouble();
                                manager.setAnnualSalary(annualSalary1);
                                System.out.println("Enter weekly bonus: ");
                                double weeklyBonus = sc.nextDouble();
                                manager.setWeeklyBonus(weeklyBonus);
                                try {
                                    employees.addEmployee(manager);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            default -> System.out.println("Invalid choice.");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Enter employee ID: ");
                    String id = sc.nextLine();
                    Employee employee = employees.searchEmployeeById(id);
                    if (employee == null) {
                        System.out.println("Employee not found.");
                    } else {
                        System.out.println(employee);
                    }
                }
                case 4 -> {
                    employees.sortByWeeklySalary();
                    System.out.println(employees);
                }
                case 5 -> {
                    System.out.println("Enter employee ID: ");
                    sc.nextLine();
                    String id1 = sc.nextLine();
                    try {
                        employees.removeEmployee(id1);
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("Enter employee ID: ");
                    String id2 = sc.nextLine();
                    Employee employee1 = employees.searchEmployeeById(id2);
                    if (employee1 == null) {
                        System.out.println("Employee not found.");
                    } else {
                        System.out.println(employee1);
                        System.out.println("Enter new information: ");
                        System.out.println("Enter employee type (1. Salaried, 2. Hourly, 3. Manager): ");
                        int type1 = sc.nextInt();
                        switch (type1) {
                            case 1 -> {
                                SalariedEmployee salariedEmployee = new SalariedEmployee();
                                input(salariedEmployee);
                                System.out.println("Enter annual salary: ");
                                double annualSalary = sc.nextDouble();
                                salariedEmployee.setAnnualSalary(annualSalary);
                                try {
                                    employees.updateEmployee(salariedEmployee);
                                }catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case 2 -> {
                                HourlyEmployee hourlyEmployee = new HourlyEmployee();
                                input(hourlyEmployee);
                                System.out.println("Enter hours worked: ");
                                int hoursWorked = sc.nextInt();
                                hourlyEmployee.setHoursWorked(hoursWorked);
                                System.out.println("Enter hourly wage: ");
                                double hourlyWage = sc.nextDouble();
                                hourlyEmployee.setHourlyWage(hourlyWage);
                                try {
                                    employees.updateEmployee(hourlyEmployee);
                                }catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case 3 -> {
                                Manager manager = new Manager();
                                input(manager);
                                System.out.println("Enter annual salary: ");
                                double annualSalary1 = sc.nextDouble();
                                manager.setAnnualSalary(annualSalary1);
                                System.out.println("Enter weekly bonus: ");
                                double weeklyBonus = sc.nextDouble();
                                manager.setWeeklyBonus(weeklyBonus);
                                try {
                                    employees.updateEmployee(manager);
                                }catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            default -> System.out.println("Invalid choice.");
                        }
                    }
                }
                case 7 -> {
                    System.out.println("List of hourly employees who work more than 40 hours a week: ");
                    Employee[] list = employees.getHourlyEmpsWorkMoreThan40();
                    for (Employee employee2 : list) {
                        if (employee2 == null) {
                            break;
                        }
                        System.out.println(employee2);
                    }
                }
                case 8 -> {
                    System.out.println("Total weekly salary of all employees: ");
                    System.out.println(employees.getWeeklyTotalSalaryOfManagers());
                }
                case 9 -> {
                    System.out.println("Enter employee ID(must be a Hourly Employee): ");
                    String id3 = sc.nextLine();
                    Employee employee3 = employees.searchEmployeeById(id3);
                    if (employee3 instanceof HourlyEmployee) {
                        System.out.println("Enter new hours worked: ");
                        int newHoursWorked = sc.nextInt();
                        ((HourlyEmployee) employee3).setHoursWorked(newHoursWorked);
                    } else {
                        System.out.println("Employee is not hourly employee.");
                    }
                }
                case 10 -> {
                    System.out.println("List of employees who are young managers (less than 30 years old): ");
                    EmployeeList listOfYoungManager = new EmployeeList(employees.getYoungEmployeesAsManagers().length);
                    listOfYoungManager.addAll(employees.getYoungEmployeesAsManagers());
                    for (Employee employee4 : listOfYoungManager.getEmployees()) {
                        if (employee4 == null) {
                            break;
                        }
                        System.out.println(employee4);
                    }
                }
                default -> System.out.println("Invalid choice.");
            }
    }
}

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
         do {
             System.out.println("============================================================================");
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
            System.out.println("============================================================================");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
             System.out.println("============================================================================\n");
            if(choice < 0 || choice > 10) {
                System.out.println("Invalid choice. Please choose again.\n");
            }
        } while(choice < 0 || choice > 10);
        if(choice == 0) {
            System.out.println("Exiting...");
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
        System.out.println("Enter employee date of birth(dd/MM/yyyy): ");
        String dob = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            tmp.setDob(LocalDate.parse(dob, formatter));
        } catch (Exception e) {
            System.out.println("Invalid date format.");
        }
    }
}
