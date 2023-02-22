import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarTest {
    Calendar calendar;

    @BeforeEach
    void setUp() {
        calendar=new Calendar();
    }

    @Test
    void sortDays() {
        assertEquals(101,calendar.sortDays().get(0));
        assertEquals(102,calendar.sortDays().get(1));
        assertEquals(103,calendar.sortDays().get(2));
        assertEquals(201,calendar.sortDays().get(31));
    }

    @Test
    void rentDays() {
        assertEquals(true,calendar.rentDays("january",23,"january",27));
        assertEquals(false,calendar.rentDays("january",27,"january",22));
        assertEquals(true,calendar.rentDays("january",27,"march",23));
        assertEquals(false,calendar.rentDays("april",22,"january",22));
    }
}