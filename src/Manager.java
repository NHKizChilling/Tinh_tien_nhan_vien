import java.text.DecimalFormat;
import java.time.LocalDate;

public class Manager extends SalariedEmployee {
    private double weeklyBonus;

    public Manager() {
        super();
        weeklyBonus = 0;
    }

    public Manager(String id, String name, LocalDate dob, double annualSalary, double weeklyBonus) {
        super(id, name, dob, annualSalary);
        this.weeklyBonus = weeklyBonus;
    }

    public double getWeeklyBonus() {
        return weeklyBonus;
    }

    public void setWeeklyBonus(double weeklyBonus) {
        this.weeklyBonus = weeklyBonus;
    }

    @Override
    public double weeklyPay() {
        return super.weeklyPay() + weeklyBonus;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("$#,###.00");
        return super.toString() + "\nWeekly bonus for manager: " + formatter.format(weeklyBonus);
    }
}
