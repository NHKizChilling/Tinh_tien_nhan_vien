import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {

    @Test
    void weeklyPay() {
        assertEquals(400, new HourlyEmployee("1", "John", null, 40, 10).weeklyPay());
    }

    @Test
    void weeklyPayOvertime() {
        assertEquals(475, new HourlyEmployee("1", "John", null, 45, 10).weeklyPay());
    }

    @Test
    void toStringTest() {
        LocalDate dob = LocalDate.of(2000, 1, 1);
        assertEquals("Employee ID: 1\nEmployee name: John\nDate of birth: 01/01/2000\n==Salary details==\n\nHours worked: 40\nHourly wage: $10.00", new HourlyEmployee("1", "John", dob, 40, 10).toString());
    }
}