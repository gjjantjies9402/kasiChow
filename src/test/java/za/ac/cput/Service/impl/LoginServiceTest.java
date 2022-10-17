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
import za.ac.cput.Entity.login;
import za.ac.cput.Entity.staff;
import za.ac.cput.Factory.loginFactory;
import za.ac.cput.Factory.staffFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class LoginServiceTest {

    @Autowired
    private static LoginService services;
    private static login created = loginFactory.createLogin(" ", "Tom", "1234567" );

    @Test
    void create() {
        login saved = created;
        assertEquals(created.getId(), saved.getId());
        System.out.println(saved);
    }

    @Test
    void read() {
        login loginB = services.read(created.getId());
        assertNotNull(loginB);
        System.out.println(loginB);
    }

    @Test
    void update() {
        login updated = services.update(created);
        assertEquals(created.getId(), updated.getId());
        System.out.println(updated);
    }

    @Test
    void delete() {
        boolean delete = services.delete(created.getId());
        assertTrue(delete);
        System.out.println("Deleted: " + true);
        System.out.println(delete);
    }

    @Test
    void getAll(){
        assertEquals(1, services.getAll().size());
        System.out.println("Staff: " + services.getAll());

    }

}