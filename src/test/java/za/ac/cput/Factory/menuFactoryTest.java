package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.login;
import za.ac.cput.Entity.menu;

import static org.junit.jupiter.api.Assertions.*;

class menuFactoryTest {

    @Test
    void creatingMenu() {
        menu men = new menu.Builder()
                .setMenuID(1)
                .setMenuCategory("Poultry")
                .build();

        assertEquals(1, men.getMenuID());
        assertEquals("Poultry", men.getMenuCategory());
    }

}