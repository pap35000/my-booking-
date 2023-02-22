import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class userTest {

    user user1;

    @BeforeEach
    public void setUp() {
        user1=new user("nick","lolis","niklol","nik123","male",3,40,10);
    }

    @Test
    public void getAge() {
        user1.setAge(19);
        assertEquals(19,user1.getAge());
    }

    @Test
    public void getType() {
        user1.setType(1);
        assertEquals(1,user1.getType());
    }

    @Test
    public void getName() {
        user1.setName("george");
        assertEquals("george",user1.getName());
    }

    @Test
    public void getSurname() {
        user1.setSurname("pappadakis");
        assertEquals("pappadakis",user1.getSurname());
    }

    @Test
    public void getGender() {
        user1.setGender("female");
        assertEquals("female",user1.getGender());
    }

    @Test
    public void getUsername() {
        user1.setUsername("geop");
        assertEquals("geop",user1.getUsername());
    }

    @Test
    public void getPassword() {
        user1.setPassword("geo321");
        assertEquals("geo321",user1.getPassword());
    }

    @Test
    public void getId() {
        user1.setId(3);
        assertEquals(3,user1.getId());
    }
}