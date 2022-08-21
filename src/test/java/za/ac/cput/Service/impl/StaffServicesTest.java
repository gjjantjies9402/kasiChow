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
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import za.ac.cput.Entity.staff;
import za.ac.cput.Factory.staffFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class StaffServicesTest {

    @Autowired
    private static StaffServices services;
    private static staff created = staffFactory.createStaff("Admin", "Tomas", "John");

    @Test
    void create() {
        staff saved = services.create(created);
        assertEquals(created.getAdminName(), saved.getAdminName());
        System.out.println(saved);
    }

    @Test
    void read() {
        staff staf = services.read(created.getAdminName());
        assertNotNull(staf);
        System.out.println(staf);
    }

    @Test
    void update() {
        staff updated = services.update(created);
        assertEquals(created.getAdminName(), updated.getAdminName());
        System.out.println(updated);
    }

    @Test
    void delete() {
        boolean delete = services.delete(created.getAdminName());
        assertTrue(delete);
        System.out.println("Deleted: " + true);
        System.out.println(delete);
    }

    @Test
    void getAll() {
        assertEquals(1, services.getAll().size());
        System.out.println("Staff: " + services.getAll());

    }
}