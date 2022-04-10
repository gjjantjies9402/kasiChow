package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.registration;
import za.ac.cput.Factory.registrationFactory;

import static org.junit.jupiter.api.Assertions.*;

class registrationRepositoryTest {
    private static registrationRepository regRepository = registrationRepository.getRegRepository();
    private static registration reg = registrationFactory.createRegistration("Mzi","Mwanda","Mzia",
            "1234","1234","M1234@cput.ac.za" );
    @Test
    void create() {
        registration create = regRepository.create(reg);
        assertEquals(reg.getFirstName(), create.getFirstName());
        System.out.println("Created: " + create);
    }

    @Test
    void read() {
        registration read = regRepository.read(reg.getFirstName());
        assertNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        registration update = new registration.Builder().copy(reg)
                .setFirstName("Sethu")
                .setLastName("Mwanda")
                .setUsername("Setu")
                .setPassword("0000")
                .setConfirmPassword("0000")
                .setEmailAddress("Set1234@hotmail.com")
                .build();

        System.out.println("Update: " + update);
    }

    @Test
    void delete() {
        boolean delete = regRepository.delete((reg.getFirstName()));
        assertTrue(delete);
        System.out.println("Delete: " + delete);
    }

    @Test
    void getAll() {
        System.out.println("Show all");
        System.out.println(regRepository.getAll());
    }
}