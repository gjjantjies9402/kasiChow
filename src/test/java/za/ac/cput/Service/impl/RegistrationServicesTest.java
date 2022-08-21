/**
 * Mziyanda Mwanda
 * 215133765
 * ADP 3
 * Service class Test implementation
 * */
package za.ac.cput.Service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.registration;
import za.ac.cput.Entity.staff;
import za.ac.cput.Factory.registrationFactory;
import za.ac.cput.Factory.staffFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class RegistrationServicesTest {

    @Autowired
    private static RegistrationServices services;
    private static registration created = registrationFactory.createRegistration("Mziyanda", "Mwanda", "Mz@gmail.com", "123456", "123456", "Mzi@gmail.com");

    @Test
    void create() {
        registration saved = created;
        assertEquals(saved.getFirstName(), saved.getFirstName());
        System.out.println(saved);
    }

    @Test
    void read() {
        registration register =created;
        assertNotNull(register);
        System.out.println(register);
    }

    @Test
    void update() {
        registration updated = services.update(created);
        assertEquals(updated.getFirstName(), updated.getFirstName());
        System.out.println(updated);
    }

    @Test
    void delete() {
        boolean delete = services.delete(created.getFirstName());
        assertTrue(delete);
        System.out.println("Deleted: " + delete + true);
    }

    @Test
    void getAll() {
        assertEquals(1, services.getAll().size());
        System.out.println("Staff: " + services.getAll());

    }

}