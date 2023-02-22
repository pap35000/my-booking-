import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class providerTest {
    provider p;
    ArrayList<accommodation> buildings, expBuildings;
    accommodation hotel1,hotel2;
    HashSet<String> characteristics;

    @BeforeEach
    public void setUp() {
        p=new provider();
    }

    @Test
    public void getId() {
        p.setId(23);
        assertEquals(23,p.getId());
    }

    @Test
    public void getUsername() {
        p.setUsername("johnp");
        assertEquals("johnp", p.getUsername());
    }

    @Test
    public void getBuildings() {
        characteristics=new HashSet<>();
        characteristics.add("pool");
        characteristics.add("massage");
        characteristics.add("casino");
        hotel1=new accommodation("ipiros palace",45, 500, 200, "ioannina",characteristics);
        characteristics.clear();
        characteristics.add("sauna");
        characteristics.add("view");
        hotel1=new accommodation("arax resort",50, 300, 100, "araxova",characteristics);
        buildings=new ArrayList<>();
        buildings.add(hotel1);
        buildings.add(hotel2);
        p.setBuildings(buildings);
        expBuildings=new ArrayList<>();
        expBuildings.add(hotel1);
        expBuildings.add(hotel2);
        assertEquals(expBuildings,p.getBuildings());
    }

    @Test
    public void getTypeOfAccommodation() {
        p.setTypeOfAccommodation("hotel");
        assertEquals("hotel", p.getTypeOfAccommodation());
        p.setTypeOfAccommodation("airbnb");
        assertEquals("airbnb", p.getTypeOfAccommodation());
    }
}