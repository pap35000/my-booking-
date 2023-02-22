import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class accommodationTest {

    accommodation a;
    HashSet<String> characteristics;

    @BeforeEach
    void setUp() {
        a=new accommodation();
    }

    @Test
    void getName() {
        a.setName("nick");
        assertEquals("nick", a.getName());
    }

    @Test
    void getPrice() {
        a.setPrice(45);
        assertEquals(45, a.getPrice());
    }

    @Test
    void getCharacteristics() {
        characteristics=new HashSet<>();
        characteristics.add("view");
        characteristics.add("pool");
        characteristics.add("spa");
        a.setCharacteristics(characteristics);
        assertEquals(true,a.getCharacteristics().contains("view"));
        assertEquals(true,a.getCharacteristics().contains("pool"));
        assertEquals(true,a.getCharacteristics().contains("spa"));
        assertEquals(false,a.getCharacteristics().contains("breakfast"));
        assertEquals(false,a.getCharacteristics().contains("gym"));
    }

    @Test
    void getSquareMetres() {
        a.setSquareMetres(500);
        assertEquals(500, a.getSquareMetres());
    }

    @Test
    void getCapacity() {
        a.setCapacity(650);
        assertEquals(650,a.getCapacity());
    }

    @Test
    void getLocation() {
        a.setLocation("athens");
        assertEquals("athens", a.getLocation());
    }
}