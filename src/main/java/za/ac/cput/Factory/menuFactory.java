package za.ac.cput.Factory;

import za.ac.cput.Entity.login;
import za.ac.cput.Entity.menu;

import java.awt.*;

public class menuFactory {
    public static menu creatingMenu(int menuID, String menuCategory) {

        return new menu.Builder().setMenuID(menuID)
            .setMenuCategory(menuCategory)
            .build();
}
}
