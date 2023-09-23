import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    LocalDate dob = LocalDate.of(2000, 1, 1);
    Manager manager = new Manager("1", "A", dob, 1000, 100);

    @Test
    void getWeeklyBonus() {
        assertEquals(100, manager.getWeeklyBonus());
    }

}