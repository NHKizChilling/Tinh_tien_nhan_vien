import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SalariedEmployeeTest {

    LocalDate dob = LocalDate.of(2000, 1, 1);
    SalariedEmployee salariedEmployee = new SalariedEmployee("1", "Bob", dob, 1000);

    @Test
    void weeklyPayTest() {
        assertEquals(19.23, salariedEmployee.weeklyPay(), 0.01);
    }

    @Test
    void toStringTest() {
        assertEquals("Employee type: Salaried Employee\nEmployee ID: 1\nEmployee name: Bob\nDate of birth: 01/01/2000\n==Salary details==\nAnnual salary: $1,000.00", salariedEmployee.toString());
    }
}