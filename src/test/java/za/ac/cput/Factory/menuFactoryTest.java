/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Menu;

import static org.junit.jupiter.api.Assertions.*;

class menuFactoryTest {

    @Test
    void creatingMenu() {
        Menu men = new Menu.Builder()
                .setMenuID(1)
                .setMenuCategory("Poultry")
                .build();

        assertEquals(1, men.getMenuID());
        assertEquals("Poultry", men.getMenuCategory());
    }

}