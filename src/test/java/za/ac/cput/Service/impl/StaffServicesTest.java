package za.ac.cput.Service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import za.ac.cput.Entity.staff;
import za.ac.cput.Factory.staffFactory;

import static org.junit.jupiter.api.Assertions.*;

class StaffServicesTest {

    @Autowired
    private static StaffServices services;
    private static staff created = staffFactory.createStaff("Admin", "Tomas", "John");

    @Test
    void create() {
        staff saved = services.create(created);
        assertEquals(created.getAdminName(), saved.getAdminName());
    }

    @Test
    void read() {
        staff staf = services.read(created.getAdminName());
        assertNotNull(staf);
    }

    @Test
    void update() {
        staff updated = services.update(created);
        assertEquals(created.getAdminName(), updated.getAdminName());
    }

    @Test
    void delete() {
      /*  staff deleted = services.delete();
        assertNotNull(deleted);*/
    }

    @Test
    void getAll() {
    }
}