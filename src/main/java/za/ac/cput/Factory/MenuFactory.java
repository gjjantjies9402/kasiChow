/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.Menu;

public class MenuFactory {
    public static Menu creatingMenu(int menuID, String menuCategory) {

        return new Menu.Builder().setMenuID(menuID)
            .setMenuCategory(menuCategory)
            .build();
}
}
