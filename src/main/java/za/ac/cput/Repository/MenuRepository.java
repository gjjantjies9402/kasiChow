//package za.ac.cput.Repository;
//import za.ac.cput.Entity.MenuItem;
//import za.ac.cput.Repository.Interface.iMenuItemRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class MenuItemRepository implements iMenuItemRepository {
//    private static MenuItemRepository repository = null;
//    private Set<MenuItem> menuItemDB = null;
//
//    private MenuItemRepository() {
//        menuItemDB = new HashSet<MenuItem>();
//    }
//
//    public static MenuItemRepository getRepository() {
//        if (repository == null)
//            repository = new MenuItemRepository();
//    return repository;
//}
//    @Override
//    public MenuItem create(MenuItem menuItem) {
//        boolean created = menuItemDB.add(menuItem);
//        if(created)
//            return menuItem;
//        else
//            return null;
//    }
//
//    @Override
//    public Item read(String s) {
//        for (MenuItem menuItem : menuItemDB) {
//            if (menuItem.getItemID().equals(menuItem))
//                return menuItem;
//        }
//        return null;
//    }
//
//    @Override
//    public MenuItem update(MenuItem menuItem) {
//        MenuItem updateMenuItem = read(menuItem.getItemID());
//
//        if (updateMenuItem != null){
//            menuItemDB.remove(updateMenuItem);
//            menuItemDB.add(menuItem);
//            return menuItem;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String s) {
//        MenuItem menuItemDeleted = read(s);
//
//        if (menuItemDeleted == null)
//            return true;
//        menuItemDB.remove(menuItemDeleted);
//        return true;
//    }
//    @Override
//    public Set<MenuItem> getAll() {
//        return null;
//    }
//}
//
//
