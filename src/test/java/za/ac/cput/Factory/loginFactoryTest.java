package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.login;

import static org.junit.jupiter.api.Assertions.*;

class loginFactoryTest {

    @Test
    void createLogin() {
        login login = new login.Builder()
                .setId("1")
                .setUsername("Mzi@pnp.co.za")
                .setPassword("P@ssw0rd")
                .build();

        assertEquals("1",login.getId());
        assertEquals("Mzi@pnp.co.za", login.getUsername());
        assertEquals("P@ssw0rd",login.getPassword());


    }

    @Test
    void fail() {
        login login = new login.Builder()
                .setId("1")
                .setUsername("Mzi@pnp.co.za")
                .setPassword("P@ssw0rd")
                .build();

        assertEquals("1",login.getId());
        assertNotEquals("", login.getUsername());
        assertEquals("P@ssw0rd",login.getPassword());


    }
}