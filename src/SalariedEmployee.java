import java.text.DecimalFormat;
import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    protected double annualSalary;

    public SalariedEmployee() {
        super();
        annualSalary = 0;
    }

    public SalariedEmployee(String id, String name, LocalDate dob, double annualSalary) {
        super(id, name, dob);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double weeklyPay() {
        return annualSalary / 52;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("$#,###.00");
        return super.toString() + "\n==Salary details==" + "\nAnnual salary: " + formatter.format(annualSalary);
    }
}
