import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class customerTest {

    customer c;
    provider p1,p2;
    ArrayList<accommodation> accommodations1, accommodations2;
    accommodation hotel1,hotel2;
    HashSet<String> characteristics;
    ArrayList<provider> providers;

    @BeforeEach
    public void setUp() {
        accommodations1=new ArrayList<>();
        characteristics=new HashSet<>();
        characteristics.add("pool");
        characteristics.add("sauna");
        characteristics.add("casino");
        hotel1=new accommodation("king's resort",60, 550, 220, "ioannina",characteristics);
        accommodations1.add(hotel1);
        p1=new provider("kostas","hotel",accommodations1,5);
        providers=new ArrayList<>();
        providers.add(p1);
        accommodations2=new ArrayList<>();
        characteristics.clear();
        characteristics.add("view");
        characteristics.add("sauna");
        characteristics.add("spa");
        hotel2=new accommodation("angelika palace",50, 350, 120, "athens",characteristics);
        accommodations2.add(hotel2);
        p2=new provider("peter","hotel",accommodations2,10);
        providers.add(p2);
        c=new customer(providers,25);
    }

///////////////////////////////////////////////////////////////////////////////////////////////// apothikevonte kai stous 2 providers ta stoixeia toy 2ou

    @Test
    public void getId() {
        c.setId(34);
        assertEquals(34,c.getId());
    }

    @Test
    public void getDuplicate() {
        assertEquals("kostas",c.getDuplicate().get(0).getUsername());
    }

    @Test
    public void getMonD() {
        c.setMonD("March");
        assertEquals("March",c.getMonD());
    }

    @Test
    public void getDateAr() {
        c.setDateAr(23);
        assertEquals(23,c.getDateAr());
    }

    @Test
    public void getDateD() {
        c.setDateD(17);
        assertEquals(17,c.getDateD());
    }

    @Test
    public void getMonAr() {
        c.setMonAr("April");
        assertEquals("April",c.getMonAr());
    }

    @Test
    public void searchAccommodationByName() {
        assertEquals("angelika palace",c.searchAccommodationByName("angelika palace").getName());
        assertEquals("king's resort",c.searchAccommodationByName("king's resort").getName());
    }

    @Test
    public void searchAccommodationSquareMetres() {
        assertEquals("king's resort",c.searchAccommodationSquareMetres(400).get(0));
        assertEquals("angelika palace",c.searchAccommodationSquareMetres(200).get(1));
    }

    @Test
    public void searchAccommodationByPriceRange() {
        assertEquals("king's resort",c.searchAccommodationByPriceRange(70).get(0));
        assertEquals("angelika palace",c.searchAccommodationByPriceRange(70).get(1));
        assertEquals("angelika palace",c.searchAccommodationByPriceRange(55).get(0));
    }

    @Test
    public void searchAccommodationByCapacity() {
        assertEquals("king's resort",c.searchAccommodationByCapacity(70).get(0));
        assertEquals("angelika palace",c.searchAccommodationByCapacity(70).get(1));
        assertEquals("king's resort",c.searchAccommodationByCapacity(150).get(0));
    }

    @Test
    public void searchAccommodationLocation() {
        assertEquals("king's resort",c.searchAccommodationLocation("ioannina").get(0));
        assertEquals("angelika palace",c.searchAccommodationLocation("athens").get(0));
    }
}