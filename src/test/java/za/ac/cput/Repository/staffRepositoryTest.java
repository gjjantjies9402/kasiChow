package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.staff;
import za.ac.cput.Factory.staffFactory;

import static org.junit.jupiter.api.Assertions.*;

class staffRepositoryTest {
    private static staffRepository staffRepo = staffRepository.getStRepository();
    private static staff st = staffFactory.createStaff("Xola","Olgar","Guys");

    @Test
    void create() {
        staff create = staffRepo.create(st);
        assertEquals(st.getAdminName(), create.getAdminName());
        System.out.println("Create: " + create);
    }

    @Test
    void read() {
        staff read = staffRepo.read(st.getAdminName());
        assertNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        staff update = new staff.Builder().copy(st)
                .setAdminName("Thando")
                .setDeliveryDriver("Constant")
                .setAssistant("loo")
                .build();

        assertNull(staffRepo.update(update));
        System.out.println("Update: " + update);
    }

    @Test
    void delete() {
        boolean delete = staffRepo.delete(st.getAdminName());
        assertTrue(delete);
        System.out.println("Deleted: " + delete);

    }

    @Test
    void getAll() {
        System.out.println("Show all");
        System.out.println(staffRepo.getAll());
    }
}