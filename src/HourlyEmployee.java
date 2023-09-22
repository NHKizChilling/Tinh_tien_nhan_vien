import java.text.DecimalFormat;
import java.time.LocalDate;

public class HourlyEmployee extends Employee {
    private int hoursWorked;
    private double hourlyWage;

    public HourlyEmployee() {
        super();
        hoursWorked = -1;
        hourlyWage = -1;
    }

    public HourlyEmployee(String id, String name, LocalDate dob, int hoursWorked, double hourlyWage) {
        super(id, name, dob);
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public double weeklyPay() {
        if(hoursWorked <= 40) {
            return hoursWorked * hourlyWage;
        }
        return (hourlyWage * 40) + ((hoursWorked - 40) * (hourlyWage * 1.5));
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("$#,###.00");
        return super.toString() + "\n==Salary details=="+"\nHours worked: " + hoursWorked + "\nHourly wage: " + formatter.format(hourlyWage);
    }
}
