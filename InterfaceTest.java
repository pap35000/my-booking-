import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class InterfaceTest {

    Interface a;
    provider p,expP;
    ArrayList<accommodation> accommodations;
    accommodation hotel1;
    HashSet<String> characteristics;


    @BeforeEach
    void setUp() {
        a=new Interface();
    }

    @Test
    void createProvider() {
        accommodations=new ArrayList<>();
        characteristics=new HashSet<>();
        characteristics.add("pool");
        characteristics.add("sauna");
        characteristics.add("casino");
        hotel1=new accommodation("king's resort",60, 550, 220, "ioannina",characteristics);
        accommodations.add(hotel1);
        p=a.createProvider("king's resort",60,550,220,"ioannina",characteristics,"hotel","kostas");
        expP=new provider("kostas","hotel",accommodations,5);

        assertEquals(expP.getId(),p.getId());
        assertEquals(expP.getUsername(),p.getUsername());
        assertEquals(expP.getTypeOfAccommodation(),p.getTypeOfAccommodation());
        assertEquals(expP.getBuildings().get(0).getName(),p.getBuildings().get(0).getName());
    }
}