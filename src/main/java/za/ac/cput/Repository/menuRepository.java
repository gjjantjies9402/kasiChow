package za.ac.cput.Repository;

import za.ac.cput.Entity.menu;
import za.ac.cput.Entity.registration;
import za.ac.cput.Repository.Interface.menuInterface;

import java.util.HashSet;
import java.util.Set;

public class menuRepository implements menuInterface {
    private static menuRepository repository = null;
    private Set<menu> menuDb = null;

    private menuRepository(){
        menuDb = new HashSet<menu>();
    }

    public static menuRepository getRepository(){
        if (repository == null){
            repository = new menuRepository();
        }
        return repository;
    }

    @Override
    public menu create(menu menu) {
        boolean success = menuDb.add(menu);
        if (!success)
            return null;

        return menu;
    }

    @Override
    public menu read(String id) {
        for (menu m : menuDb) {
            if (m.getMenuCategory().equals(id))
                return m;
        }
        return null;
    }

    @Override
    public menu update(menu menu ) {
        menu newMenu = read(menu.getMenuCategory());

        if (newMenu != null){
            menuDb.remove(newMenu);
            menuDb.add(menu);
            return  menu;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        menu delMenu = read(id);

        if (delMenu == null)
            return false;
        menuDb.remove(delMenu);
        return true;
    }

    @Override
    public Set<menu> getAll() {
        return menuDb;
    }
}
