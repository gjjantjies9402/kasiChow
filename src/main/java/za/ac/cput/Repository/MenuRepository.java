/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Repository;

import za.ac.cput.Entity.Menu;
import za.ac.cput.Repository.Interface.MenuInterface;

import java.util.HashSet;
import java.util.Set;

public class MenuRepository implements MenuInterface {
    private static MenuRepository repository = null;
    private Set<Menu> menuDb = null;

    private MenuRepository(){
        menuDb = new HashSet<Menu>();
    }

    public static MenuRepository getRepository(){
        if (repository == null){
            repository = new MenuRepository();
        }
        return repository;
    }

    @Override
    public Menu create(Menu menu) {
        boolean success = menuDb.add(menu);
        if (!success)
            return null;

        return menu;
    }

    @Override
    public Menu read(String id) {
        for (Menu m : menuDb) {
            if (m.getMenuCategory().equals(id))
                return m;
        }
        return null;
    }

    @Override
    public Menu update(Menu menu ) {
        Menu newMenu = read(menu.getMenuCategory());

        if (newMenu != null){
            menuDb.remove(newMenu);
            menuDb.add(menu);
            return  menu;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Menu delMenu = read(id);

        if (delMenu == null)
            return false;
        menuDb.remove(delMenu);
        return true;
    }

    @Override
    public Set<Menu> getAll() {
        return menuDb;
    }
}
