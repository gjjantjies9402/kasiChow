package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.registration;

import static org.junit.jupiter.api.Assertions.*;

class registrationFactoryTest {

    @Test
    void createRegistration() {

        registration reg = new registration.Builder()
                .setFirstName("Mzi")
                .setLastName("lona")
                .setPassword("1234")
                .setConfirmPassword("1234")
                .setEmailAddress("Xw12343@pnp.co.za")
                .build();

        assertEquals("Mzi", reg.getFirstName());
        assertEquals("lona",reg.getLastName());
        assertEquals("1234", reg.getPassword());
        assertNotEquals("0000", reg.getConfirmPassword());
        assertEquals("Xw12343@pnp.co.za", reg.getEmailAddress());
    }

    @Test
    void fail() {

        registration reg = new registration.Builder()
                .setFirstName("Mzi")
                .setLastName("Lona")
                .setPassword("1234")
                .setConfirmPassword("1234")
                .setEmailAddress("Xw12343@pnp.co.za")
                .build();

        assertEquals("Mzi", reg.getFirstName());
        assertNotEquals("lona",reg.getLastName());
        assertEquals("1234", reg.getPassword());
        assertNotEquals("0000", reg.getConfirmPassword());
        assertEquals("Xw12343@pnp.co.za", reg.getEmailAddress());
    }
}