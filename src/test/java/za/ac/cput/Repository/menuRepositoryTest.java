package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.login;
import za.ac.cput.Entity.menu;
import za.ac.cput.Factory.loginFactory;
import za.ac.cput.Factory.menuFactory;

import static org.junit.jupiter.api.Assertions.*;

class menuRepositoryTest {
    private static  menuRepository menuRepo = menuRepository.getRepository();
    private static menu men = menuFactory.creatingMenu(1, "Poultry");
    @Test
    void create() {
        menu create = menuRepo.create(men);
        assertEquals(men.getMenuID(), create.getMenuID());
        System.out.println(create);

    }

    @Test
    void read() {
        menu read = menuRepo.read(men.getMenuCategory());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        menu update = new menu.Builder()
                .setMenuCategory("Poultry")
                .build();
    }

    @Test
    void delete() {
        boolean deleted = menuRepo.delete(men.getMenuCategory());
        assertTrue(deleted);
        System.out.println(deleted);
    }

    @Test
    void getAll() {
        System.out.println(menuRepo.getAll());
    }
}